package az.iso.lesson.collections

class MyHashMap<K, V> : Iterable<Pair<K, V>> {

    private data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null
    )

    private var capacity = DEFAULT_CAPACITY
    private val loadFactor = LOAD_FACTOR

    private var buckets = MutableList<Node<K, V>?>(capacity) { null }

    var size = 0
        private set

    companion object {
        private const val DEFAULT_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75f
    }

    private fun index(key: K): Int {
        return (key?.hashCode() ?: 0)
            .and(Int.MAX_VALUE) % capacity
    }

    fun put(key: K, value: V) {

        if (size >= capacity * loadFactor) {
            resize()
        }

        val index = index(key)

        var current = buckets[index]

        if (current == null) {
            buckets[index] = Node(key, value)
            size++
            return
        }

        while (true) {

            if (current!!.key == key) {
                current.value = value
                return
            }

            if (current.next == null) {
                current.next = Node(key, value)
                size++
                return
            }

            current = current.next
        }
    }

    fun getValue(key: K): V? {

        var current = buckets[index(key)]

        while (current != null) {

            if (current.key == key) {
                return current.value
            }

            current = current.next
        }

        return null
    }

    fun remove(key: K): V? {

        val index = index(key)

        var current = buckets[index]
        var previous: Node<K, V>? = null

        while (current != null) {

            if (current.key == key) {

                if (previous == null) {
                    buckets[index] = current.next
                } else {
                    previous.next = current.next
                }

                size--
                return current.value
            }

            previous = current
            current = current.next
        }

        return null
    }

    fun containsKey(key: K): Boolean {
        return get(key) != null
    }

    fun containsValue(value: V): Boolean {

        for ((_, v) in this) {
            if (v == value) {
                return true
            }
        }

        return false
    }

    fun clear() {

        buckets = MutableList(capacity) { null }
        size = 0
    }

    fun isEmpty(): Boolean = size == 0

    private fun resize() {

        val oldBuckets = buckets

        capacity *= 2

        buckets = MutableList(capacity) { null }

        size = 0

        for (bucket in oldBuckets) {

            var current = bucket

            while (current != null) {

                put(current.key, current.value)

                current = current.next
            }
        }
    }

    operator fun set(key: K, value: V) {
        put(key, value)
    }

    operator fun get(key: K): V? {
        return getValue(key)
    }

    override fun iterator(): Iterator<Pair<K, V>> {

        return object : Iterator<Pair<K, V>> {

            private var bucketIndex = 0
            private var current: Node<K, V>? = null

            init {
                moveToNextBucket()
            }

            private fun moveToNextBucket() {

                while (bucketIndex < buckets.size && current == null) {
                    current = buckets[bucketIndex++]
                }
            }

            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Pair<K, V> {

                val node = current ?: throw NoSuchElementException()

                val result = node.key to node.value

                current = node.next

                if (current == null) {
                    moveToNextBucket()
                }

                return result
            }
        }
    }

    override fun toString(): String {

        val builder = StringBuilder("{")

        var first = true

        for ((key, value) in this) {

            if (!first) {
                builder.append(", ")
            }

            builder.append("$key=$value")

            first = false
        }

        builder.append("}")

        return builder.toString()
    }
}