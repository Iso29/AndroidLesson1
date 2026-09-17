package az.iso.lesson.oop

abstract class Animal(
    val type : String
){
    abstract fun eat()
}

interface  Walkable{
    abstract fun walk()
}

interface Swimables{
    fun swim()
}

interface Flyable{
    fun fly()
}

class Cat(
    val color : String,
    type: String
) : Animal(type) , Walkable{

    override fun walk() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }
}

class Penguen(
    val color : String,
    type: String
): Animal(type) , Walkable, Swimables{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun walk() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }
}

class Bird(
    val color : String,
    type: String
) : Animal(type) , Walkable , Flyable{
    override fun walk() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }
}

class Crocadile(
    val isWild : Boolean,
    type: String
) : Animal(type) , Walkable , Swimables{
    override fun walk() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    fun test(){

    }
}

fun main() {
    val flyable = object : Flyable{
        override fun fly() {
            TODO("Not yet implemented")
        }
    }
}