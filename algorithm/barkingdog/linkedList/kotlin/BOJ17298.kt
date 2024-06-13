package algorithm.barkingdog.linkedList.kotlin

import java.util.Stack


class BOJ17298 {
}

fun main() {
    val n = readlnOrNull()?.toInt() ?: throw RuntimeException()
    val inputs = readlnOrNull()?.split(" ") ?: throw RuntimeException()
    val stack = Stack<Int>()
    val result = IntArray(n)
    for (i in n - 1 downTo 0) {
        val s = inputs[i].toInt()
        while (!stack.isEmpty() && stack.peek() <= s) {
            stack.pop()
        }
        if (stack.isEmpty()) {
            result[i] = -1
        } else {
            result[i] = stack.peek()
        }
        stack.push(s)
    }
    result.forEach{print("$it ")}
}
