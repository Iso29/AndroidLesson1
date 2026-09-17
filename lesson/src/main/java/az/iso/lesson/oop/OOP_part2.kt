package az.iso.lesson.oop

class Car(
    val mark: String,
    val model: String
) : Any() {
    override fun toString(): String {
        return "$mark $model"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Car) {
            (this.mark == other.mark && this.model == other.model)
        } else {
            super.equals(other)
        }
    }
}

//fun main() {
//    val str = String(charArrayOf('s','s')) //String("ss")
//    val str2 = String(charArrayOf('s','s'))
//
//    val poolStr1 = "Salam"
//    val poolStr2 = "Salam"
//    println("${poolStr1===poolStr2}")
//
////    val car1 = Car("Ford", "Mustang")
////    val car2 = Car("Ford", "Mustang")
////    val car3 = car2
////    println("{car1==car2}")
////    println("${car1 == car2}")
////
////    println("{car2==car3}")
////    println("${car2 == car3}")
//}

data class Machine(
    var mark: String,
    var model: String,
    var test: String? = null,
    var engine: Boolean = false
) {
    var year: Int = 0

    constructor(
        mark: String,
        model: String,
        test: String? = null,
        engine: Boolean = false,
        year: Int
    ) : this(
        mark,
        model,
        test,
        engine,
    ) {
        this.year = year
    }
}


//fun main() {
//    val m1 = Machine(
//        "BMW",
//        "F10"
//    )
//
//    val (year, mark) = m1
//
//    val m2 = m1.copy(
//        engine = true
//    )
//    val m3 = Machine(
//        "Tesla",
//        "ModelX"
//    )
//
//    val m4 = Machine(
//        "Tesla",
//        "ModelX",
//        year = 2020
//    )
//
//    val listCar = arrayOf(m1, m2, m3, m4)
//    listCar.forEach {
//        println(it)
//    }
////    println("car 1 == car 2")
////    println("${m1 === m2}")
////
////    println("car 2 == car 3")
////    println("${m2 == m3}")
////
////    println("car 1 == car 3")
////    println("${m1 == m3}")
//}


fun main() {
    TestCl("ISO")
}

class UserSystem {
    private var name: String? = ""
        get() = if (field.isNullOrBlank()) {
            throw RuntimeException("Name is empty")
        } else {
            field
        }
        set(value) {
            if (value.isNullOrBlank())
                throw RuntimeException("Name is empty")
            else field = value.trim()
        }

    fun getName1() : String{
       return if (this.name.isNullOrBlank()) {
            throw RuntimeException("Name is empty")
        } else {
            this.name?:""
        }
    }

    fun setName1(str : String?) {
        if (str.isNullOrBlank())
            throw RuntimeException("Name is empty")
        else this.name = str.trim()
    }
}

class TestCl{
    var name : String = ""
    constructor(name : String){
        this.name = name
        println("constructor ${this.name}")
    }

    init {
        println("init ${this.name}")
    }

    companion object{
        init {
            println("companion object")
        }
    }
}

