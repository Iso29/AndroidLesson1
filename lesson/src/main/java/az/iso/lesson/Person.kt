package az.iso.lesson

class Person {
    private var name: String = ""
    internal var surname: String = ""
    public var age: Int = 0
    var height: Float = 0.0f

    fun getName() : String {
        return this.name
    }

    companion object{
        var personCounter = 0

        fun printObjCount(){
            println("$personCounter obj created")
        }
    }

    init {
        personCounter++
    }

    constructor(
        name: String,
        surname: String,
        age: Int,
        height: Float
    ) {
        this.name = name
        this.surname = surname
        this.age = age
        this.height = height

    }

    constructor() {

    }

    fun printObject(){
        println(this.name)
        println(this.surname)
        println(this.age)
        println(this.height)
    }
}