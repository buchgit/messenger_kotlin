package com.example.messenger_kotlin.components

import com.example.messenger_kotlin.models.Message
import com.example.messenger_kotlin.usecases.MessageVO
import org.springframework.stereotype.Component

@Component
class MessageAssembler {
    fun toMessageVO(message: Message): MessageVO {
        return MessageVO(
            message.id,
            message.sender?.id,
            message.recipient?.id,
            message.conversation?.id,
            message.body,
            message.createdAt.toString()
        )
    }
}