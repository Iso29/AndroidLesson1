package az.iso.lesson.multithreads

fun main() {
    val thread = Thread {
        try {
            while (true) {
                println("Working...")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            println("Interrupted!")
        }

    }


    thread.start()

    Thread.sleep(3000)

    thread.interrupt()
}
