package az.iso.lesson

class Customer(
    name: String,
    surname: String,
    phone: String,
    wallet: Double,
    var isCash: Boolean,
    var isSessionActive: Boolean
) : SystemPerson(
    name,
    surname,
    wallet,
    phone,
) {
    override fun call() {
        if (isSessionActive) {
            println("Calling...")
        } else {
            println("There is no active session!")
        }
    }

}

class Restaurant(
    var filialName: String,
    var address: String,
    phone: String,
    val haveMain: Boolean
) : Callable(
    phone
) {
    override fun call() {
        println("${filialName} Calling..")
        val response = readlnOrNull()?.toIntOrNull() ?: 0
        if (response == 1)
            return
        else {
             println("calling main...")
        }
    }
}

class Currier(
    name: String,
    surname: String,
    phone: String,
    wallet: Double,
    var isActive: Boolean,
    var isRiding: Boolean
) : SystemPerson(
    name,
    surname,
    wallet,
    phone,
) {
    override fun call() {
        if (isActive) {
            if (isRiding) {
                println("Curier is on the way...")
            } else {
                println("Calling")
            }
        } else {
            println("Is not available now")
        }
    }
}

abstract class Locale(
    var address : String
)

abstract class Callable(
    var phone: String
) {
    abstract fun call()
}

abstract class SystemPerson(
    var name: String,
    var surname: String,
    var wallet: Double,
    phone: String
) : Callable(phone) {
    open fun printFullName() {
        println("${name} ${surname}")
    }
}

fun main() {
    val cust1 = Customer(
        "Ismayil",
        "Islamzada",
        "+9977",
        19.90,
        true,
        true
    )

    val rest1 = Restaurant(
        "Friday",
        "PortBaku",
        "+99111",
        true
    )

    val cur1 = Currier(
        "TestCurName",
        "TestCurSurname",
        "+9912931",
        219.90,
        true,
        true
    )

    val systemPerson = object : SystemPerson(
        "TestCurName",
        "TestCurSurname",
        219.90,
        "+9912931"
    ){
        override fun call() {
            println("calling...")
        }
    }

    printHello()
}