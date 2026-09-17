package az.iso.lesson.delegation

class LoggerManagerImpl : LoggerManager {
    override fun logEvents(eventName: String) {
        println("Sent to our server , event name : ${eventName}")
    }
}