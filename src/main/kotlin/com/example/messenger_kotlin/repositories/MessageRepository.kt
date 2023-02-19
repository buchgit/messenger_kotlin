package com.example.messenger_kotlin.repositories

import com.example.messenger_kotlin.models.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository:CrudRepository<Message,Long> {
    fun findByConversationId(conversationId: Long):List<Message>
}