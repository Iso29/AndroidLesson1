package az.iso.lesson.oop

import java.security.MessageDigest

class UserDTOUser(
    private var userName : String,
    private var password : String
){

    companion object{
//        val users = arrayListOf<User>()
    }

    fun setUserName(userName : String){
        if(userName.isBlank())
            println("Invalid username input")
        else this.userName = userName.trim()
    }

    fun getUserName() : String{
        return this.userName
    }

    fun getPassword() : String{
        return hashSHA256(this.password)
    }

    fun hashSHA256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(input.toByteArray(Charsets.UTF_8))
        return hashBytes.joinToString("") { "%02x".format(it) }
    }
}