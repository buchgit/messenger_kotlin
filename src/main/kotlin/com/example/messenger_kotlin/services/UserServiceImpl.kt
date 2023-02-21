package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val repository: UserRepository):UserService {
    @Throws(UsernameUnavailableException::class)
    override fun attemptRegistration(userDetails: User): User {
        if (!userNameExists(userDetails.username)){
            val user = User()
            user.username = userDetails.username
            user.password = userDetails.password
            user.phoneNumber = userDetails.phoneNumber
            repository.save(user)
            obscurePassword(user)
            return user
        }
        throw UsernameUnavailableException("The username ${userDetails.username} is unavaiable!")
    }

    override fun listUsers(currentUser: User): List<User> {
        TODO("Not yet implemented")
    }

    override fun retrieveUserData(userName: String): User? {
        TODO("Not yet implemented")
    }

    @Throws(InvalidUserIdException::class)
    override fun retrieveUserData(id: Long): User? {
        val userOptional = repository.findById(id)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            obscurePassword(user)
        return user
    }
        throw InvalidUserIdException("A user with an id '$id' doesn't exist")
    }


    override fun userNameExists(userName: String): Boolean {
        return repository.findByUserName(userName)!=null
    }

    override fun obscurePassword(user: User?) {
        user?.password = "XXX XXXX XXX"
    }
}

class UsernameUnavailableException(message:String): Throwable() {

}

class InvalidUserIdException(message: String):Throwable() {

}
