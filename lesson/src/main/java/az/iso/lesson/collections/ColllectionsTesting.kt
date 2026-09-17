package az.iso.lesson.collections

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Stack

fun main1() {
    val numbersList = arrayOf(1,2,4,2)
    numbersList[4] = 0

    val ageList = arrayListOf<Int>() //24


    ageList.addAll(arrayListOf(23,29,22))
    ageList.contains(0)
    // [ null -> 0, 29 -> 1 , 22 -> 2, 24] - > [ 23 ,27 , 29 , 22, 24]
    ageList.add(24)
    ageList.add(1,27)
    ageList.removeAt(1)
    ageList.clear()

    //[ , , , , , , ] size = 10
    // var arry = [ 23, 29, 22, , , , ] size = 10

    // val tempArr = Array(20)
    //for -> arry kocurur tempArr , arry = tempArr
}

fun main2() {
    val linkedList = LinkedList<Int>()
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)
    linkedList.add(4)

    linkedList.forEachIndexed { index, i ->
        println("index - $index . number : $i")
    }

    // [ 1 -> 2 -> 8 -> 3 -> 4 -> null ]
}


fun main3() {
    val stack1 = Stack<String>()
    stack1.add("Ana ekran")
    stack1.add("Profil ekran")
    stack1.add("Tenzimlemeler ekran")

    println(stack1.pop())

    println(stack1.peek())

    stack1.forEachIndexed { index, i ->
        println("index - $index . number : $i")
    }
}

fun main() {
    val queue = PriorityQueue<Int>()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)

    queue.forEachIndexed { index, i ->
        println("index - $index . number : $i")
    }
}
