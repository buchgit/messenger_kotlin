package com.example.messenger_kotlin.components

import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.usecases.UserListVO
import com.example.messenger_kotlin.usecases.UserVO
import org.springframework.stereotype.Component

@Component
class UserAssembler {
    fun toUserVO(user:User):UserVO{
        return UserVO(user.id,user.username,user.phoneNumber,user.status,user.createdAt.toString())
    }

    fun toUserListVO(users:List<User>):UserListVO{
        val userVOList = users.map { toUserVO(it) }
        return UserListVO(userVOList)
    }
}