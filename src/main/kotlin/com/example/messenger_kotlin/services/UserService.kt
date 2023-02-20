package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.models.User

interface UserService {
    fun attemptRegistration(userDetails: User):User
    fun listUsers(currentUser: User):List<User>
    fun retrieveUserData(userName:String):User?
    fun retrieveUserData(id:Long):User?
    fun userNameExists(userName:String):Boolean
}