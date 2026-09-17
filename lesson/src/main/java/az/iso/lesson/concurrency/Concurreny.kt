package az.iso.lesson.concurrency

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {

    println("Main starts : ${Thread.currentThread().name}")

    val job1 = launch(start = CoroutineStart.LAZY) {
        println("Coroutine starts : ${Thread.currentThread().name}")

        delay(3000.milliseconds)

        println("Coroutine ends : ${Thread.currentThread().name}")
//        try {
//
//        }catch (e: Exception){
//        }
    }
    job1.start()
    delay(2000.milliseconds)
    job1.cancel()

   val job2 =  launch {
        println("Second process start  ${Thread.currentThread().name}")
        delay(4000.milliseconds)
        println("Second process end  ${Thread.currentThread().name}")
    }
//    delay(2000.milliseconds)

    println("Main ends")
}

fun main1() {

    println("Main starts : ${Thread.currentThread().name}")

    Thread {
        println("Coroutine starts : ${Thread.currentThread().name}")

        Thread.sleep(2000)

        println("Coroutine ends : ${Thread.currentThread().name}")
    }.start()

    println("Waiting...")

//    Thread.sleep(2000)

    println("Main ends")
    Thread.currentThread().interrupt()
}