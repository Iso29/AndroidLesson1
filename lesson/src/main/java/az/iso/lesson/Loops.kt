package az.iso.lesson

fun main() {
//    for (i in 10 downTo  0){
//        if(i==6){
//            break
//        }
//        println("number : $i")
//    }

    println("Enter start")
    val startInterval = readlnOrNull()?.toIntOrNull()?:0

    println("Enter end")
    val endInterval = readlnOrNull()?.toIntOrNull()?:0

    if(startInterval>endInterval){
        loopMyNumbersV2(endInterval,endInterval,startInterval)
//        loopMyNumbers(endInterval,startInterval)
    }else{
        loopMyNumbersV2(startInterval,startInterval,endInterval)
//        loopMyNumbers(startInterval,endInterval)

    }

//    var i = 0
//    while (i<5){
//        println(i)
//        i++
//    }
//    do {
//        println(i)
//        i++
//    }while (i==5)

}

fun loopMyNumbers(startInterval : Int,endInterval : Int){
    println("$startInterval and ${endInterval}")
    for(i in startInterval .. endInterval){
        println(i)
    }
}

fun loopMyNumbersV2(current : Int,startInterval : Int,endInterval : Int){
    if(current>=startInterval && current<=endInterval){
        println(current)
        loopMyNumbersV2(current+1,startInterval,endInterval)
    }else{
        return
    }
}