package com.example.messenger_kotlin.components

import com.example.messenger_kotlin.models.Conversation
import com.example.messenger_kotlin.services.ConversationServiceImpl
import com.example.messenger_kotlin.usecases.ConversationListVO
import com.example.messenger_kotlin.usecases.ConversationVO
import com.example.messenger_kotlin.usecases.MessageVO
import org.springframework.stereotype.Component

@Component
class ConversationAssembler(val conversationService: ConversationServiceImpl,val messageAssembler: MessageAssembler) {
    fun toConversationVO(conversation: Conversation,userId:Long):ConversationVO{
        val conversationMessages:ArrayList<MessageVO> = ArrayList()
        conversation.messages.mapTo(conversationMessages){
            messageAssembler.toMessageVO(it)
        }
        return ConversationVO(conversation.id,conversationService.nameSecondParty(conversation,userId),conversationMessages)
    }
    fun toConversationListVO(conversations:ArrayList<Conversation>,userId: Long):ConversationListVO{
        val conversationVOList = conversations.map { ConversationVO(it,userId) }
        return ConversationListVO(conversationVOList)
    }
}