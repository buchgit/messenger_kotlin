package com.example.messenger_kotlin.services

import ConversationInvalidException
import com.example.messenger_kotlin.models.Conversation
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.ConversationRepository

class ConversationServiceImpl(private val repository: ConversationRepository) : ConversationService {
    override fun createConversation(sender: User, recipient: User): Conversation {
        val conversation = Conversation(sender,recipient)
        repository.save(conversation)
        return conversation
    }

    override fun conversationExist(sender: User, recipient: User): Boolean {
        return when {
            repository.findBySenderIdAndRecipientId(sender.id, recipient.id) != null -> true
            repository.findBySenderIdAndRecipientId(recipient.id, sender.id) != null -> true
            else -> false
        }
    }

    override fun getConversation(sender: User, recipient: User): Conversation? {
        return when {
            repository.findBySenderIdAndRecipientId(sender.id, recipient.id)!=null ->
                repository.findBySenderIdAndRecipientId(sender.id, recipient.id)!!

            repository.findBySenderIdAndRecipientId(recipient.id, sender.id) != null ->
                repository.findBySenderIdAndRecipientId(recipient.id, sender.id)!!

            else -> null
        }
    }

    override fun retrieveThread(conversationId: Long): Conversation {
        val optional = repository.findById(conversationId)
        if (optional.isPresent){
            return optional.get()
        }else{
            throw ConversationInvalidException("Invalid conversation with id '$conversationId'")
        }
    }

    override fun listUserConversation(userId: Long): ArrayList<Conversation> {
        val conversationList:ArrayList<Conversation> = ArrayList()
        conversationList.addAll(repository.findBySenderId(userId))
        conversationList.addAll(repository.findByRecipientId(userId))
        return conversationList
    }

    override fun nameSecondParty(conversation: Conversation, userId: Long): String {
        return when (conversation.sender?.id) {
            userId -> conversation.recipient?.username as String
            else -> conversation.sender?.username as String
        }
    }
}


