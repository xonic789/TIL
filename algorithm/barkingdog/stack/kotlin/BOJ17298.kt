package algorithm.barkingdog.stack.kotlin

import java.util.Stack


class BOJ17298 {
}

fun main() {
    val n = readlnOrNull()?.toInt() ?: throw RuntimeException()
    val inputs = readlnOrNull()?.split(" ")?.map { it.toInt() } ?: throw RuntimeException()
    val stack = Stack<Int>()
    val result = IntArray(n)
    for (i in n - 1 downTo 0) {
        while (!stack.isEmpty() && stack.peek() <= inputs[i]) {
            stack.pop()
        }
        if (stack.isEmpty()) {
            result[i] = -1
        } else {
            result[i] = stack.peek()
        }
        stack.push(inputs[i])
    }
    result.forEach{print("$it ")}
}
