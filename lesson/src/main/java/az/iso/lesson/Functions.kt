package az.iso.lesson

import kotlin.random.Random

fun main() {
//    printHello()
//    printMessage()
//    calculate1(
//        op = '+',
//        num1 = 1,
//        num2 = 2,
//    )
//    calculate2(1,2,'+')

    //without function
//    val myNum = readlnOrNull()?.toIntOrNull()?:0
//    var step = 0
//    var currentNum = myNum
//    while (currentNum>1){
//        currentNum /= 10
//        step++
//    }
//    println(step <= 1)

    //with function
//    println(20.isOneStepNum())
//
//    println(20 ustegel 10)

    //call back
//    doItV1(
//        myWorker = {
//            println("Hello!")
//        }
//    )

    doItV2(
        myWorker = { name ->
            println("Hello , $name!")
        }
    )

//    doItV3(
//        myWorker = { name ->
//            println("Hello , $name!")
//            return@doItV3 Random.nextInt()
//        }
//    )

//    doItV1(
//        myWorker = { str ->
//            println("Hello , $str!")
//            return@doIt 1
//        }
//    )

//    myNonInlineFunction()

//    testITV2(
//        worker = {
//            printHello()
//            return
//        }
//    )
//    printHello()

    val name = readlnOrNull()?:""
    test112{
        name.checkIsCorrectName(
            onSuccess = {
                println("Welcome "+name)
                return@checkIsCorrectName
            },
            onError = {
                println("Incorrect name ${name}")
            }
        )
        printHello()
    }

    test1{}
}

fun printHello(){
    println("Hello")
}

fun calculate1(num1 : Int,num2 : Int , op : Char){
    if(op == '+'){
        println(num1+num2)
    }
}

fun calculate2(num1 : Int,num2 : Int , op : Char) : Int{
    if(op == '+'){
        return num1+num2
    }
    return 0
}

fun Int.isOneStepNum() : Boolean {
    var step = 0
    var currentNum = this
    while (currentNum>1){
        currentNum /= 10
        step++
    }
    return step <= 1
}

infix fun Int.ustegel(num2 : Int) : Int{
    return this + num2
}

fun doItV3(myWorker :  (string : String) -> Int){
    print("Enter")
    println("Name")
    val name : String = readlnOrNull()?:""
    myWorker(name)
    println("finish")
}

fun doItV2( myWorker : (string : String) -> Unit){
    print("Enter")
    println("Name")
    val name : String = readlnOrNull()?:""
    myWorker(name)
    println("finish")
}

fun doItV1(myWorker : (() -> Unit)? = {}){
    println("Enter")
    myWorker?.invoke()
    val name : String = readlnOrNull()?:""
}

fun testIt() : Boolean {
    return true
}

fun test1(test : ( ()-> Unit)-> Unit) : Unit{
    test{

    }
}

inline fun myNonInlineFunction(){
    print("Enter")
    println("Name")
    val name : String = readlnOrNull()?:""
    println("finish, ${name}")
}

inline fun testITV2(
    worker :  () -> Int
): Unit{
    print("Enter")
    println("Name")
    val name : String = readlnOrNull()?:""
    worker()
    println("finish, ${name}")
}

inline fun String.checkIsCorrectName(
    onSuccess  : () -> Unit,
    onError: () -> Unit = {}
){
    if(this.isBlank()){
        onError()
    }else{
        if(this.startsWith("1")){
            onError()
        }else{
            onSuccess()
        }
    }
}

fun test112(test : ()-> Unit){
    test()
}

fun foo(){}

fun foo(num1 : Int) : Int{
    return num1
}

