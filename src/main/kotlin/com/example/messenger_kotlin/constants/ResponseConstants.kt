package com.example.messenger_kotlin.constants

enum class ResponseConstants(val value:String){
    SUCCESS("success"),
    ERROR("error"),
    MESSAGE_EMPTY("MES_001"),
    MESSAGE_RECIPIENT_INVALID("MES_002"),
    ACCOUNT_DEACTIVATED("CLO_001"),
    EMPTY_STATUS("USR_003"),
    INVALID_USER_ID("USR_002"),
    USERNAME_UNAVAILABLE("USR_0001");

}