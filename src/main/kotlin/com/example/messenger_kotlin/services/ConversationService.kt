package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.models.Conversation
import com.example.messenger_kotlin.models.User

interface ConversationService {
    fun createConversation(sender: User, recipient: User):Conversation
    fun conversationExist(sender: User, recipient: User):Boolean
    fun getConversation(sender: User, recipient: User):Conversation?
    fun retrieveThread(conversationId:Long):Conversation
    fun listUserConversation(userId:Long):List<Conversation>
    fun nameSecondParty(conversation: Conversation,userId: Long):String
}
