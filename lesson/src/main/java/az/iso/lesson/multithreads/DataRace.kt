package az.iso.lesson.multithreads

var counter = 0

fun main() {

    val t1 = Thread {
        repeat(1000000) {
            counter++
        }
    }

    val t2 = Thread {
        repeat(1000000) {
            counter++
        }
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println(counter)
}