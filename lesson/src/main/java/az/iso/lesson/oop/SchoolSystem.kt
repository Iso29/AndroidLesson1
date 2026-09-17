package az.iso.lesson.oop

import kotlin.random.Random

class Student(
    id: Long = 0,
    name: String = "",
    surname: String ="",
    var average: Float = 0.0f,
    var speciality: String = ""
) : SchoolIndividual(
    id = id,
    name = name,
    surname = surname
){
    override fun printFullName() {
        super.printFullName()
        println("student avarage ${this.average}")
    }
}

class Teacher(
    id: Long = 0,
    name: String = "",
    surname: String ="",
    var salary: Double = 0.0
) : SchoolIndividual(
    id = id,
    name = name,
    surname = surname
) {
    override fun printFullName() {
        super.printFullName()
        println("Salary : ${this.salary}")
    }
}

open class SchoolIndividual(
    var id: Long = 0,
    var name: String = "",
    var surname: String = ""
) {
    open fun printFullName() {
        println(this.name + " " + this.surname)
    }
}

fun main() {
    val student = Student(
        Random.nextLong(),
        "Orxan",
        "XXXXX",
        82.0f,
        "ITIF"
    )

    val teacher = Teacher(
        Random.nextLong(),
        "Ismayil",
        "Islamzada",
        1200.0,
    )

    val schIndv = SchoolIndividual(
        Random.nextLong(),
        "XXXX",
        "SCH",
    )

    val array = arrayOf(student,teacher,schIndv)
    array.forEach { ind ->
       ind.printFullName()
    }
}