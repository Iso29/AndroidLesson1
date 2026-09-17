package az.iso.lesson.basics


class MyNumber(val value: Int) {
    operator fun invoke() : Unit {}
}

operator fun MyNumber.plus(other: MyNumber): MyNumber {
    return MyNumber(this.value + other.value - 1)
}

fun main() {
    val a = MyNumber(1)
    val b = MyNumber(1)


    println((a + b).value)
}