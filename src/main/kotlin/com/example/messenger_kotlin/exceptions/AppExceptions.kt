class UsernameUnavailableException(override val message:String = "Invalid user name"): RuntimeException() {

}

class InvalidUserIdException(override val message: String = "Invalid user id"): RuntimeException() {

}

class UserStatusEmptyException(override val message: String = "A user's status cannot be empty"):RuntimeException(){

}

class UserDeactivatedException(override val message: String) :RuntimeException(){

}

class MessageEmptyException(override val message: String = "A message can't be empty"):RuntimeException() {

}

class MessageRecipientInvalidException(override val message:String) :RuntimeException(){

}

class ConversationInvalidException(override  val message:String = "Conversation is invalid") : RuntimeException() {

}