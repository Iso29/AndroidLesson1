package az.iso.lesson.generic

import java.util.Date
import java.util.UUID

data class ServerUser(
    val userName: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val expDate: Date = Date()
)

fun main() {
    try {
        val dbUser = listOf(
            ServerUser(
                "ISO", "ISO11"
            )
        )
        println("Enter username")
        val inputUN = readlnOrNull() ?: ""

        println("Enter password")
        val inputPass = readlnOrNull() ?: ""

        val user = ServerUser(
            inputUN, inputPass
        )
        filterInputs(user)
        if (validateUser(user, dbUser)) {
            println("TOken...")
            val loginRes = LoginResponse(
                token = UUID.randomUUID().toString()
            )
            val res = Response(
                statusCode = 200,
                data = loginRes
            )
            println(res)
        } else {
            println("invalid cred")
        }
    } catch (e: Exception) {
        println(e.message)
        e.printStackTrace()
    }
}

private fun filterInputs(user: ServerUser) {
    if (user.userName.isBlank() || user.password.isBlank())
        throw InvalidLoginException()
}

class InvalidLoginException(message: String = "Invalid cred") : Exception(message)

fun validateUser(user: ServerUser, db: List<ServerUser>): Boolean {
    for (u in db) {
        if (u.equals(user)) {
            return true
        }
    }
    return false
}

data class Response<T>(
    val statusCode: Int? = null,
    val error: ErrorData? = null,
    val data: T? = null
)

data class UserInfoResponse(
    val userName: String,
    val email: String
)

data class ErrorData(
    val errorCode: Int,
    val errorMessage: String
)

