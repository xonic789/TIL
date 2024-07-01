package algorithm.barkingdog.stack.kotlin

import java.util.*

class BOJ4949 {
}

fun main() {
    while (true) {
        val str = readlnOrNull() ?: break
        if (str == "." || str.isEmpty()) {
            break
        }
        println(extracted(str))
    }
}

private fun extracted(str: String): String {
    val stack = Stack<Char>()
    for (ch in str) {
        if (ch.isLetter() || ch == ' ' || ch == '.') continue
        if (ch == '[' || ch == '(') {
            stack.push(ch)
        } else {
            if (stack.isEmpty()) {
                return "no"
            } else if (stack.peek() == '(' && ch == ')') stack.pop()
            else if (stack.peek() == '[' && ch == ']') stack.pop()
        }
    }
    return if (stack.isNotEmpty()) {
        "no"
    } else {
        "yes"
    }
}
