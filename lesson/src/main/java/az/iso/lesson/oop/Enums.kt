package az.iso.lesson.oop

import java.util.Date

interface TestClass{
    fun testIt()
}
enum class AppColor(val colorCode : String) : TestClass {
    BG_COLOR("#FFFFFF"){
        override fun testIt() {
            super.testIt()
        }
    },
    BRAND_COLOR("#512613"),
    UI_ELEMENT_COLOR("FF001100"),
    TEXT_COLOR("FF000000");

    override fun testIt() {
        TODO("Not yet implemented")
    }


    companion object{
        fun printColor(color : AppColor){
            println(color.colorCode)
        }
    }
}

fun AppColor.printColor(){
    println(this.colorCode)
}


class EnumSim private constructor(val color : String){
    val BG_COLOR = EnumSim("#FFFFFF")
}

enum class PaymentWay{
    CASH,CARD,APPLE_PAY,GOOGLE_PAY
}

class Receipt(
    val amount : Double,
    val date : String,
    val paymentMethod : PaymentWay
)

fun main() {

    val clickButton = AppButton(
        title = "Click me!",
        containerColor = AppColor.BRAND_COLOR.colorCode,
        textColor = AppColor.TEXT_COLOR.colorCode
    )

    clickButton.onClick {
        println("Button clicked")
    }

    val recp = Receipt(
        amount = 20.0,
        date = Date().toString(),
        paymentMethod = PaymentWay.CARD
    )
}


interface Clickable{
    fun onClick(doIt : ()-> Unit)
}

class AppButton(
    val title : String,
    val containerColor : String,
    val textColor : String
) : Clickable{
    override fun onClick(doIt: () -> Unit) {
        doIt()
    }
}