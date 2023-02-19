package com.example.messenger_kotlin.repositories

import com.example.messenger_kotlin.models.Conversation
import org.springframework.data.repository.CrudRepository

interface ConversationRepository:CrudRepository<Conversation,Long> {
    fun findBySenderId(id: Long):List<Conversation>
    fun findByRecipientId(id:Long):List<Conversation>
    fun findBySenderIdAndRecipientId(senderId:Long, recipientId:Long):Conversation?
}