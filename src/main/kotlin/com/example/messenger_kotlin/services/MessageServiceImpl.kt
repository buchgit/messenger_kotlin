package com.example.messenger_kotlin.services

import MessageEmptyException
import MessageRecipientInvalidException
import com.example.messenger_kotlin.models.Conversation
import com.example.messenger_kotlin.models.Message
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.ConversationRepository
import com.example.messenger_kotlin.repositories.MessageRepository
import com.example.messenger_kotlin.repositories.UserRepository

class MessageServiceImpl(
    val repository: MessageRepository,
    val conversationRepository: ConversationRepository,
    val conversationService: ConversationService,
    val userRepository: UserRepository
) : MessageService {
    @Throws(MessageEmptyException::class, MessageRecipientInvalidException::class)
    override fun sendMessage(
        sender: User,
        recipientId: Long,
        messageText: String
    ): Message {
        val optional = userRepository.findById(recipientId)
        if (optional.isPresent) {
            val recipient = optional.get()
            if (!messageText.isEmpty()) {
                val conversation: Conversation =
                    if (conversationService.conversationExist(sender, recipient)) {
                        conversationService.getConversation(sender, recipient) as Conversation
                    } else {
                        conversationService.createConversation(sender, recipient)
                    }
                conversationRepository.save(conversation)

                val message = Message(sender, recipient, messageText, conversation)
                repository.save(message)
                return message
            }
        } else {
            throw MessageRecipientInvalidException("The recipien id '$recipientId' is invalid")
        }
        throw MessageEmptyException()
    }
}