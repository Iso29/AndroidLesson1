package az.iso.lesson.concurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

fun main11() {
    val job = SupervisorJob()
    val scope = CoroutineScope(job)

    val job1 = scope.launch {
        println("Coroutine 1 starts : ${Thread.currentThread().name}")
        delay(2.seconds)
        throw RuntimeException("Boooom")
        println("Coroutine 1 end : ${Thread.currentThread().name}")
    }

    scope.launch {
        println("Coroutine 2 starts : ${Thread.currentThread().name}")
        delay(3.seconds)
        println("Coroutine 2 end : ${Thread.currentThread().name}")
    }
    println("End of main function")
    runBlocking {
        job.join()
    }
}

fun main() {
    val job = Job()
    val scope = CoroutineScope(job)

    scope.launch {
        launch {
            val data1 = getUserDetails()
        }

        launch {
            val data2 = getUserDetails2()
        }

//        println(data2 + data1)
    }

    runBlocking {
        job.join()
    }

}

suspend fun getUserDetails(): String {
    println("started 1")
    delay(3.seconds)
    println("finished 1")
    return "Sala"
}

suspend fun getUserDetails2(): String {
    println("started 2")
    delay(1.seconds)
    println("finished 2")
    return "Salam"
}