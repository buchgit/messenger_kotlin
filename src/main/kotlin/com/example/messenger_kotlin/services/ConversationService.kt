package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.models.Conversation
import com.example.messenger_kotlin.models.User

interface ConversationService {
    fun createConversation(sender: User, recipient: User):Conversation
    fun conversationExist(sender: User, recipient: User):Boolean
    fun getConversation(sender: User, recipient: User):Conversation

}
