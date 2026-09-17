package az.iso.lesson.multithreads

class IOThread(
    val runnable : Runnable
) : Thread() {
    override fun run() {
        priority = Thread.MAX_PRIORITY
        runnable.run()
    }
}