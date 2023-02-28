package com.example.messenger_kotlin.components

import UserDeactivatedException
import com.example.messenger_kotlin.constants.ErrorResponse
import com.example.messenger_kotlin.constants.ResponseConstants
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestControllerAdvice {
    @ExceptionHandler(UserDeactivatedException::class)
    fun userDeactivated(userDeactivatedException: UserDeactivatedException):ResponseEntity<ErrorResponse>{
        val res = ErrorResponse(ResponseConstants.ACCOUNT_DEACTIVATED.value,userDeactivatedException.message)
        return ResponseEntity(res,HttpStatus.UNAUTHORIZED)
    }
}


