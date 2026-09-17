package az.iso.lesson.generic

import az.iso.lesson.oop.SchoolIndividual
import az.iso.lesson.oop.Student
import az.iso.lesson.oop.Teacher

private interface Animal {}

open private class FLying(
    val type : String
)

private data class Dog(
    val color: String
) : Animal {}

private class Cat(
    val gender: Boolean
) : Animal

private class Box<T : Animal, D : SchoolIndividual>(
    var animal: T,
    var data: D? = null
)

private class Box2< T : Animal>(
    var animal: T
)

private fun <T: Animal>Box2<T>.printProperty(){
    println(this.animal)
}

fun main() {
    val animalBox4: Box2<*> = Box2<Dog>(Dog("dd"))
    val animalBox5: Box2<*> = Box2<Cat>(Cat(false))

//    val animals : ArrayList<Box2<*>> = arrayListOf(animalBox4,animalBox5)
//    for (animal in animals){
//        animal.printProperty()
//    }

    defineWhichType(Int::class.java)

//    feedCat(animalShelter)
}

private inline fun <reified T> defineWhichType(value : Class<T>) {
    val className = value.name
    if(className.contains("String")){
        println("String classi")
    }else{
        println("Other type")
    }
}

private inline fun <reified T> defineWhichType(value : T) {
    val className = value::class.java.name
    val obj = value
    if(className.contains("String")){
        println("String classi")
    }else{
        println("Other type")
    }
}


//private class AnimalShelter<in T>(
//     private val test: T
//) {
//    fun feed(animal: T) {          // ✅ T only used as parameter — OK
//        println("Feeding $animal")
//    }
//
//    fun adopt(): T {
//        return test
//    }            // ❌ Would break contravariance, not allowed
//}

//private fun feedCat(shelter: AnimalShelter<Cat>) {
//    shelter.feed(Cat())
//}

