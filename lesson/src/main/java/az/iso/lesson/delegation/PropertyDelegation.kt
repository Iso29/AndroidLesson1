package az.iso.lesson.delegation

import kotlin.reflect.KProperty

fun main() {
    var test by SingletonDelegate{
        "Salam"
        12
    }

    test
}


class SingletonDelegate<T>(
    private val creator: () -> T
) {

    private var instance: T? = null

    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {

        if (instance == null) {
            println("Creating ${property.name}")
            instance = creator()
        }

        return instance!!
    }
    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        instance = newValue
    }
}