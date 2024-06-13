package algorithm.barkingdog.stack.kotlin

import java.util.*

class BOJ10828 {
}

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    val commands = mutableListOf<String>()
    for (i in 0 until n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push" -> {
                stack.push(command[1].toInt())
            }
            "top" -> {
                val e = if (stack.isNotEmpty()) {
                    stack.peek()
                } else {
                    -1
                }
                println(e)
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                println(if (stack.isEmpty()) 1 else 0)
            }
            "pop" -> {
                val e = if (stack.isNotEmpty()) {
                    stack.pop()
                } else {
                    -1
                }
                println(e)
            }
        }
    }
}
