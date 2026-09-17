package az.iso.lesson.delegation

fun main() {
    val serverLogger : LoggerManager = LoggerManagerImpl()
    val debugLogger = DebugLogManager(
        serverLogger
    )
    debugLogger.logInternal("Salam")
    val arrayLoggers = listOf(serverLogger,debugLogger)
}

