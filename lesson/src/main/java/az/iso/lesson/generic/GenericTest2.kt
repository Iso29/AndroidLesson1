package az.iso.lesson.generic

import az.iso.lesson.oop.Student
import az.iso.lesson.oop.Teacher

fun main() {

}

private fun <T>doIt(args : T){
    println(args)
}

private fun <T>doItV2(args : T){
    val test : Array<*> = arrayOf(Student(), Teacher())

    println(args)
}