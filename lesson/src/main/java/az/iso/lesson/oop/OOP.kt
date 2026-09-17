package az.iso.lesson.oop

fun main() {
    //public , protected , internal, private

    val person1 = Person(
        name = "Ismayil",
        surname = "Islamzada",
        age = 23,
        height = 1.78f
    )

    val person2 = Person(
        name = "Ismayil2",
        surname = "Islamzada2",
        age = 23,
        height = 1.78f
    )

    val person3 = Person(
        name = "Ismayil3",
        surname = "Islamzada3",
        age = 23,
        height = 1.78f
    )

//    val person4 = buildPersonFromTerminal()

    val personList = arrayOf(person1, person2, person3)

    personList.forEachIndexed { index, person ->
        println(index + 1)
        person.printObject()
    }
    Person.printObjCount()
}

fun buildPersonFromTerminal() : Person{
    println("Enter name : ")
    val person1Name = readlnOrNull()?:""

    println("Enter surname : ")
    val person1Surname = readlnOrNull()?:""

    println("Enter age : ")
    val person1Age = readlnOrNull()?.toIntOrNull()?:0

    println("Enter height : ")
    val person1Height = readlnOrNull()?.toFloatOrNull()?:0.0f

    return Person(
        person1Name,
        person1Surname,
        person1Age,
        person1Height
    )
}