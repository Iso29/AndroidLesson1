package az.iso.lesson.multithreads

class IORunnable(
    val file : String,
    val userId : String
) : Runnable {
    override fun run() {
        println("file ${file} : sent to user with id ${userId} ")
    }
}