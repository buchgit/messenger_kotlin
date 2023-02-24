class UsernameUnavailableException(override val message:String = "Invalid user name"): RuntimeException() {

}

class InvalidUserIdException(override val message: String = "Invalid user id"): RuntimeException() {

}

class UserStatusEmptyException(override val message: String = "A user's status cannot be empty"):RuntimeException(){

}

class MessageEmptyException(override val message: String = "A message can't be empty"):RuntimeException() {

}

class MessageRecipientInvalidException(message:String) :RuntimeException(){

}

class ConversationInvalidException(s: String) : RuntimeException() {

}