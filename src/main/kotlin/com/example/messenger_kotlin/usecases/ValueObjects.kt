package com.example.messenger_kotlin.usecases

data class UserVO(
    val id:Long,
    val username:String,
    val phoneNumber: String,
    val status:String,
    val createAt:String
)

data class UserListVO(
    val users:List<UserVO>
)

data class MessageVO(
    val id:Long,
    val senderId:Long?,
    val recipientId:Long?,
    val conversationId:Long?,
    val body:String?,
    val createAt: String
)

data class ConversationVO(
    val conversationId: Long,
    val secondPartyUsername:String,
    val massages:ArrayList<MessageVO>
)

data class ConversationListVO(
    val conversations:List<ConversationVO>
)
