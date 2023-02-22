package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.models.Message
import com.example.messenger_kotlin.models.User

interface MessageService {
    fun sendMessage(sender:User, recipientId:Long, messageText: String):Message
}