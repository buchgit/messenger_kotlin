package com.example.messenger_kotlin.controllers

import com.example.messenger_kotlin.components.UserAssembler
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.UserRepository
import com.example.messenger_kotlin.services.UserServiceImpl
import com.example.messenger_kotlin.usecases.UserListVO
import com.example.messenger_kotlin.usecases.UserVO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

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
    @GetMapping
    @RequestMapping("/{user_id}")
    fun show(@PathVariable("user_id") userId:Long):ResponseEntity<UserVO>{
        val user = userServiceImpl.retrieveUserData(userId)
        return ResponseEntity.ok(userAssembler.toUserVO(user))
    }
    @GetMapping
    fun index(request:HttpServletRequest):ResponseEntity<UserListVO>{
        val user = userRepository.findByUsername(request.userPrincipal.name) as User
        val users = userServiceImpl.listUsers(user)
        return ResponseEntity.ok(userAssembler.toUserListVO(users))
    }
    @PutMapping
    fun update(@RequestBody updateDetails:User, request: HttpServletRequest):ResponseEntity<UserVO>{
        val currentUser = userRepository.findByUsername(request.userPrincipal.name)
        userServiceImpl.updateUserStatus(currentUser as User,updateDetails)
        return ResponseEntity.ok(userAssembler.toUserVO(currentUser))
    }
}