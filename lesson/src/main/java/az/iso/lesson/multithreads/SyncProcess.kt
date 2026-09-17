package az.iso.lesson.multithreads

import java.util.concurrent.atomic.AtomicInteger
import kotlin.synchronized

fun main() {
    val t1 = Thread {
        repeat(1000000) {
            incrementAtomic()
        }
    }

    val t2 = Thread {
        repeat(1000000) {
            incrementAtomic()
        }
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println(counterAtomic)
}

val counterAtomic = AtomicInteger()
private var counter1 = 0
private val salam = Any()

private fun increment() {
    synchronized(salam) {
        counter1++
    }
}

private fun incrementAtomic() {
   counterAtomic.incrementAndGet()
}