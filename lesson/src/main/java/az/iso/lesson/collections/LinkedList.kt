package az.iso.lesson.collections

// * -> * -> * -> * -> *
// * -> null
data class Node<T>(
    var value: T,
    var next: Node<T>? = null
)

class MyLinkedList<T> : Iterable<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun add(value: T) {

        val node = Node(value)

        if (head == null) {
            head = node
            tail = node
        } else {
            tail!!.next = node
            tail = node
        }

        size++
    }

    operator fun get(index: Int): T {

        checkIndex(index)

        var current = head

        repeat(index) {
            current = current!!.next
        }

        return current!!.value
    }

    fun removeAt(index: Int): T {

        checkIndex(index)

        if (index == 0) {

            val value = head!!.value

            head = head!!.next

            if (head == null)
                tail = null

            size--

            return value
        }

        var previous = head!!

        repeat(index - 1) {
            previous = previous.next!!
        }

        val removed = previous.next!!

        previous.next = removed.next

        if (removed == tail)
            tail = previous

        size--

        return removed.value
    }

    private fun checkIndex(index: Int) {
        require(index in 0 until size) {
            "Index: $index, Size: $size"
        }
    }

    override fun iterator(): Iterator<T> {

        return object : Iterator<T> {

            private var current = head

            override fun hasNext() : Boolean{
                return current != null
            }

            override fun next(): T {

                if (!hasNext())
                    throw NoSuchElementException()

                val value = current!!.value

                current = current!!.next

                return value
            }
        }
    }

    override fun toString(): String =
        joinToString(prefix = "[", postfix = "]")
}