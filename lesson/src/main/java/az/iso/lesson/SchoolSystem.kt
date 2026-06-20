package az.iso.lesson

import kotlin.random.Random

class Student(
    id: Long,
    name: String,
    surname: String,
    var average: Float,
    var speciality: String
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
    id: Long,
    name: String,
    surname: String,
    var salary: Double
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
    var id: Long,
    var name: String,
    var surname: String
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