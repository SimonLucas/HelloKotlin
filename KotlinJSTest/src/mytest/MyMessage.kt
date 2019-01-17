package mytest

import kotlin.random.Random

// import java.util
//
//fun main(args: Array<String>) {
//    Message().randomMessage()
//}

var n = 0
class Message {

    // val random = Random


    fun randomMessage(): String {
        n++
        return n.toString() + " : " + if (Random.nextDouble() < 0.5) "Hello" else "Goodbye"
    }

}

