package az.iso.lesson.multithreads

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main() {

    val executor = ThreadPoolExecutor(
        2,
        4,
        30,
        TimeUnit.SECONDS,
        LinkedBlockingQueue()
    )

    repeat(10) { index ->

        executor.execute {

            println(
                "Task $index running on ${Thread.currentThread().name}"
            )

            Thread.sleep(1000)

            println(
                "Task $index finished"
            )
        }
    }

    executor.shutdown()
}