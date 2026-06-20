package az.iso.lesson

fun main() {
//    var student1 = "Orxan"
//    val student2 = "Serxan"
//    val student3 = "Ruslan"
//
//    val students : Array<String?> = arrayOf(student1,student2,student3)
//    students[0] = null
//    println(students[1])

    var a = 10
    var b = a
    a+=2
    println("a = $a , b = $b")

    val arr1 = arrayOf(1,2,3)
    val arr2 = arr1
    arr1[0] = 15

    println("first element arr1 ${arr1[0]}")
    println("first element arr2 ${arr2[0]}")
}