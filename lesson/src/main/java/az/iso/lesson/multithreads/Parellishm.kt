package az.iso.lesson.multithreads

fun main() {
//    val customRunnable = IORunnable(
//        file = "test/test",
//        userId = "12"
//    )
//
//    val sender = IOThread(
//       customRunnable
//    )
    val worker0 = Thread{
        Thread.sleep(1000)
        println("Worker 0")
    }
    val worker1 = Thread{
        Thread.sleep(4000)
        println("Worker 1")
//        test1()
    }
    val worker2 = Thread{
        Thread.sleep(10000)
        println("Worker 2")
//        sayHi()
    }
    println(worker1.state)
   worker1.start()
    println(worker1.state)
    worker1.join()
    println(worker1.state)

//    worker2.start()
//    worker2.join()
//
//    worker1.start()
//    worker1.join()
//
//    worker0.start()
//    worker0.join()

    println("Prosses ended")
}

private fun test1(){
    repeat(10){
        println("test1")
    }
}

private fun sayHi(){
    repeat(10){
        println("sayHi")
    }
}

