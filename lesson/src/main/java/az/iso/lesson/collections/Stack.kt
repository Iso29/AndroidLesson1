package az.iso.lesson.collections

class MyStack<T> : Iterable<T>{

    private var elements = arrayOfNulls<Any>(4)

    private var size = 0

    fun push(value: T) {

        ensureCapacity()

        elements[size++] = value
    }

    fun pop(): T {

        if (size == 0)
            throw NoSuchElementException("Stack is empty")

        size--

        @Suppress("UNCHECKED_CAST")
        val value = elements[size] as T

        elements[size] = null

        return value
    }

    fun peek(): T {

        if (size == 0)
            throw NoSuchElementException("Stack is empty")

        @Suppress("UNCHECKED_CAST")
        return elements[size - 1] as T
    }

    fun isEmpty(): Boolean = size == 0

    fun size(): Int = size

    private fun ensureCapacity() {

        if (size < elements.size)
            return

        val newArray = arrayOfNulls<Any>(elements.size * 2)

        for (i in elements.indices)
            newArray[i] = elements[i]

        elements = newArray
    }

    override fun toString(): String {

        val builder = StringBuilder("[")

        for (i in 0 until size) {

            builder.append(elements[i])

            if (i != size - 1)
                builder.append(", ")
        }

        builder.append("]")

        return builder.toString()
    }

    override fun iterator(): Iterator<T> {

        return object : Iterator<T> {

            private var currentIndex = size - 1

            override fun hasNext(): Boolean {
                return currentIndex >= 0
            }

            override fun next(): T {

                if (!hasNext())
                    throw NoSuchElementException()

                @Suppress("UNCHECKED_CAST")
                return elements[currentIndex--] as T
            }
        }
    }
}