package az.iso.lesson

fun main() {
    var systemOut = false
    while (!systemOut){
        val user = register()
        if(user!=null){
            println("user pass" + user.getPassword())
            login()
        }else{
            println("Do you want retry?")
            val y = readlnOrNull()?.toIntOrNull()?:1
            if(y==1){
                systemOut = true
            }
        }
    }
}

fun register() : User?{
    println("Register, Enter username and password")
    val user = User(readlnOrNull()?:"",readlnOrNull()?:"")
    User.users.forEach { us ->
        if(us.getUserName().equals(user.getUserName())){
            return null
        }
    }
    User.users.add(user)
    return user
}

fun login(){
    println("Pls login, Enter username and password")
    val user = User(readlnOrNull()?:"",readlnOrNull()?:"")
    User.users.forEach { us ->
        if(us.getUserName().equals(user.getUserName())
            && us.getPassword().equals(user.getPassword())){
            println("Welcome ${user.getUserName()}")
            return
        }
    }
    println("Password : ${user.getPassword()}")
    println("Invalid credentials")
    return
}



