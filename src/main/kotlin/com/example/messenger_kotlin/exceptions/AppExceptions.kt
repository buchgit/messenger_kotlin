class UsernameUnavailableException(message:String): RuntimeException() {

}

class InvalidUserIdException(message: String): RuntimeException() {

}

class MessageEmptyException:RuntimeException() {

}

class MessageRecipientInvalidException(message:String) :RuntimeException(){

}