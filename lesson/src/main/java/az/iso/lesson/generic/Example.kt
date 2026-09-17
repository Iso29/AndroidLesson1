package az.iso.lesson.generic

class GenericTest<T>(
    val value: T
) {

}

inline fun <reified T> test() {
    T::class.javaClass.name
}

class GenericTestV2(
    val value: Any
)

fun main() {
    val test = GenericTest<String>("aaa")
    test.value

    val test3 = GenericTest<Int>(10)
    test3.value

    val test2 = GenericTestV2("aaaa")
    (test2.value as? String)

    val test4 = GenericTestV2(10)
    (test2.value as? Int)

    try {
        throw TestException()
    }catch (e: NullPointerException){

    }catch (e: Exception){

    }catch (e: Throwable) {

    }finally {

    }
}

class TestException() : Throwable(){

}

