package az.iso.lesson.solid

import az.iso.lesson.oop.PaymentWay

class PaymentUtil(
    private val paymentFactory: PaymentFactory
){
    fun pay(paymentWay: PaymentWay){
        val paymentProcessor = paymentFactory.getPaymentInstance(paymentWay)
        paymentProcessor.pay()
    }
}

class PaymentFactoryProvider : PaymentFactory{
    override fun getPaymentInstance(paymentWay: PaymentWay) : PaymentInterface {
        return when(paymentWay){
            PaymentWay.CASH -> Cash()
            PaymentWay.CARD -> Card()
            PaymentWay.APPLE_PAY -> ApplePay()
            PaymentWay.GOOGLE_PAY -> GooglePay()
//                PaymentWay.FACE -> Face()
        }
    }
}

interface PaymentFactory{
    fun getPaymentInstance(paymentWay: PaymentWay) : PaymentInterface
}

interface PaymentInterface{
    fun pay()
}

class Face() : PaymentInterface{
    override fun pay() {
        println("Pay by face")
    }
}
class Cash() : PaymentInterface{
    override fun pay(){
        ///

        ///
        println("Pay by CASH")
    }
}
class Card() : PaymentInterface{
    override fun pay(){
        ///

        ///
        println("Pay by Card")
    }
}
class ApplePay() : PaymentInterface{
    override fun pay(){
        ///

        ///
        println("Pay by ApplePay")
    }
}
class GooglePay() : PaymentInterface{
    override fun pay(){
        ///

        ///
        println("Pay by GooglePay")
    }
}

fun main() {
    PaymentUtil(
        PaymentFactoryProvider()
    ).pay(PaymentWay.CARD)
}