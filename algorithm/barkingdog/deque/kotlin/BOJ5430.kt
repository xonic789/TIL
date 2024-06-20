package algorithm.barkingdog.deque.kotlin

import java.util.ArrayDeque

class BOJ5430 {
}

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        println(result())
    }
}

private fun result(): String {
    val p = readln()
    val n = readln()
    val arrayString = readln()
    val deque = ArrayDeque<String>()
    var reverse = false
    if (n != "0") {
        arrayString.substring(1, arrayString.length - 1).split(",").forEach {
            if (it == "") {
                return@forEach
            }
            deque.addLast(it)
        }
    }
    for (c in p) {
        when (c) {
            'R' -> {
                reverse = !reverse
            }

            'D' -> {
                if (deque.isEmpty()) {
                    return "error"
                }
                if (reverse) {
                    deque.removeLast()
                } else {
                    deque.removeFirst()
                }
            }
        }
    }
    val sb = StringBuilder()
    sb.append("[")
    while (deque.isNotEmpty()) {
        if (reverse) {
            sb.append(deque.pollLast())
        } else {
            sb.append(deque.pollFirst())
        }
        if (deque.size != 0) {
            sb.append(",")
        }
    }
    sb.append("]")
    return sb.toString()
}
