package com.example.messenger_kotlin.repositories

import com.example.messenger_kotlin.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<User?,Long> {
    fun findByUsername(username:String):User
    fun findByPhoneNumber(phoneNumber: Number):User?
}