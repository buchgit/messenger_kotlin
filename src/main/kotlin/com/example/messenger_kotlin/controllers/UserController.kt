package com.example.messenger_kotlin.controllers

import com.example.messenger_kotlin.components.UserAssembler
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.UserRepository
import com.example.messenger_kotlin.services.UserServiceImpl
import com.example.messenger_kotlin.usecases.UserVO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userServiceImpl: UserServiceImpl,
    val userRepository: UserRepository,
    val userAssembler: UserAssembler
) {
    @PostMapping
    @RequestMapping("/registrations")
    fun create(@Validated @RequestBody userModel: User): ResponseEntity<UserVO> {
        val user = userServiceImpl.attemptRegistration(userModel)
        val userVO = userAssembler.toUserVO(user)
        return ResponseEntity.ok(userVO)
    }
}