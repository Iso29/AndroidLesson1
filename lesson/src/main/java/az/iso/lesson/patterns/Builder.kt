package az.iso.lesson.patterns

class UserDTO private constructor(
    val name: String,
    val age: Int,
    val email: String?,
    val phone: String?
) {

    class Builder() {

        private var name = ""
        private var age = 0
        private var email: String? = null
        private var phone: String? = null

        fun setName(name: String) = apply {
            this.name = name
        }

        fun setAge(age: Int) = apply {
            this.age = age
        }

        fun setEmail(email: String) = apply {
            this.email = email
        }

        fun setPhone(phone: String) = apply {
            this.phone = phone
        }

        fun build(): UserDTO {
            return UserDTO(
                name,
                age,
                email,
                phone
            )
        }
    }
}

fun main() {
//    val user1 = UserDTO(
//        name = "Ismayil",
//        age = 23
//    )

    val user2 = UserDTO.Builder()
        .setPhone("+999")
        .setName("Ismayil")
        .setAge(23)
        .build()
}