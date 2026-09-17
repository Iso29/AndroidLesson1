package az.iso.lesson.concurrency

class Database private constructor() {

    init {
        println("Database created on thread: ${Thread.currentThread().name}")
    }

    fun query(sql: String) {
        println("Executing: $sql")
    }

    companion object {

        @Volatile
        private var INSTANCE: Database? = null

        fun getInstance(): Database {

            // First check (no lock)
            INSTANCE?.let { return it }

            synchronized(this) {

                // Second check (with lock)
                INSTANCE?.let { return it }

                val instance = Database()
                INSTANCE = instance
                return instance
            }
        }
    }
}