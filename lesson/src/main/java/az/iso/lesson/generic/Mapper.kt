package az.iso.lesson.generic

private interface MyMapper<in Response,out DomainData>{
    fun map(input : Response) : DomainData
}
private interface MyMapperAny{
    fun map(input : Any) : Any
}

private class LoginResponseV2(
    val token : String,
    val loginMessage : String,
    val layer : String
)

private class LoginDomainModel(
    val loginMessage : String
)

fun main() {
    val response = LoginResponseV2(
        "afce","mess","VIP"
    )

    val mapperStar : MyMapper<*, *> = LoginMapper()
//    mapperStar.map(
//        response
//    )

    val mapper = LoginMapper().map(response)

}


private class LoginMapper : MyMapper<LoginResponseV2, LoginDomainModel>{
    override fun map(input: LoginResponseV2): LoginDomainModel {
        return LoginDomainModel(
            loginMessage = input.loginMessage + input.layer
        )
    }
}