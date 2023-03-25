package com.example.messenger_kotlin.controllers

import com.example.messenger_kotlin.components.MessageAssembler
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.UserRepository
import com.example.messenger_kotlin.services.MessageServiceImpl
import com.example.messenger_kotlin.usecases.MessageVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpRequest
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/messages")
class MessageController(
    val messageService: MessageServiceImpl,
    val userRepository: UserRepository,
    val messageAssembler: MessageAssembler
) {
    @PostMapping
    fun create(@RequestBody messageDetails:MessageRequest,request: HttpServletRequest):ResponseEntity<MessageVO>{
        val principal = request.userPrincipal
        val sender = userRepository.findByUsername(principal.name) as User
        val message = messageService.sendMessage(sender,messageDetails.recipientId,messageDetails.message)
        return ResponseEntity.ok(messageAssembler.toMessageVO(message))
    }

    data class MessageRequest(val recipientId:Long,val message:String)

}