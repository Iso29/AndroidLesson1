package az.iso.lesson.collections

class MyArrayList<T> : Iterable<T> {
    private var elements = arrayOfNulls<Any>(4)
    private var size = 0

    fun add(item: T) {
        ensureCapacity()
        elements[size++] = item
    }

    operator fun get(index: Int): T {
        check(index)
        @Suppress("UNCHECKED_CAST")
        return elements[index] as T
    }

    private fun ensureCapacity() {
        if (size < elements.size) return

        val newArray = arrayOfNulls<Any>(elements.size * 2)

        for (i in elements.indices) {
            newArray[i] = elements[i]
        }

        elements = newArray
    }

    private fun check(index: Int) {
        if (index !in 0 until size)
            throw IndexOutOfBoundsException()
    }

    override fun iterator(): Iterator<T> {

        return object : Iterator<T> {

            private var currentIndex = 0

            override fun hasNext(): Boolean {
                return currentIndex < size
            }

            override fun next(): T {

                if (!hasNext())
                    throw NoSuchElementException()

                @Suppress("UNCHECKED_CAST")
                return elements[currentIndex++] as T
            }
        }
    }
}