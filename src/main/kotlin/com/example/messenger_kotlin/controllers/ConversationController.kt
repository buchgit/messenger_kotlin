package com.example.messenger_kotlin.controllers

import com.example.messenger_kotlin.components.ConversationAssembler
import com.example.messenger_kotlin.repositories.UserRepository
import com.example.messenger_kotlin.services.ConversationServiceImpl
import com.example.messenger_kotlin.usecases.ConversationListVO
import com.example.messenger_kotlin.usecases.ConversationVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/conversations")
class ConversationController(
    val conversationService: ConversationServiceImpl,
    val conversationAssembler: ConversationAssembler,
    val userRepository: UserRepository
) {
    @GetMapping
    fun list(request:HttpServletRequest):ResponseEntity<ConversationListVO>{
        val user = userRepository.findByUsername(request.userPrincipal.name)
        val conversations = conversationService.listUserConversation(user.id)
        return ResponseEntity.ok(conversationAssembler.toConversationListVO(conversations,user.id))
    }
    @GetMapping
    @RequestMapping("/{conversation_id}")
    fun show(@PathVariable(name = "conversation_id") conversationId:Long, request: HttpServletRequest):ResponseEntity<ConversationVO>{
        val user = userRepository.findByUsername(request.userPrincipal.name)
        val conversationThread = conversationService.retrieveThread(conversationId)
        return ResponseEntity.ok(conversationAssembler.toConversationVO(conversationThread,user.id))
    }

}