package az.iso.lesson.delegation

class DebugLogManager(
    val logger : LoggerManager
) {
    fun logInternal(eventName : String){
        println("local event : ${eventName}")
        logger.logEvents(eventName)
    }
}