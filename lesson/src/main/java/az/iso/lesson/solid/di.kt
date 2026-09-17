package az.iso.lesson.solid

data class MessageDTO(
    val senderId : String,
    val receiverId : String,
    val message : String
)

class SMSSender : MessageSender{
    override fun sendSMS(
       messageDTO: MessageDTO
    ){
        println("send sms via Phone from ${messageDTO.senderId} to ${messageDTO.receiverId} \n content : ${messageDTO.message}")
    }
}

interface MessageSender{
    fun sendSMS(
        messageDTO: MessageDTO
    )
}

class EmailSender : MessageSender{
    override fun sendSMS(
        messageDTO: MessageDTO
    ){
        println("send sms via email from ${messageDTO.senderId} to ${messageDTO.receiverId} \n content : ${messageDTO.message}")
    }
}

fun main() {
    val smsManager = provideMessageSender()
    smsManager.sendSMS(
        MessageDTO(
            "Ismayil",
            "Mesud",
            "Test signal"
        )
    )
}

fun provideMessageSender() : MessageSender{
    return EmailSender()
}