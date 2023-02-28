package com.example.messenger_kotlin.components

import MessageEmptyException
import MessageRecipientInvalidException
import com.example.messenger_kotlin.constants.ErrorResponse
import com.example.messenger_kotlin.constants.ResponseConstants
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class MessageControllerAdvice {
    @ExceptionHandler(MessageEmptyException::class)
    fun messageEmpty(messageEmptyException: MessageEmptyException):ResponseEntity<ErrorResponse>{
        val res = ErrorResponse(ResponseConstants.MESSAGE_EMPTY.value, messageEmptyException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }

    @ExceptionHandler(MessageRecipientInvalidException::class)
    fun messageRecipientInvalid(messageEmptyException: MessageEmptyException):ResponseEntity<ErrorResponse>{
        val res = ErrorResponse(ResponseConstants.MESSAGE_RECIPIENT_INVALID.value, messageEmptyException.message)
        return ResponseEntity.badRequest().body(res)
    }
}