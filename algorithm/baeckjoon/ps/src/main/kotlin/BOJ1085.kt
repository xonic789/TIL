package ps.src.main.kotlin

import java.util.*

class BOJ1085 {
    fun solution() {
        val line = readLine()?.split(" ")
        val (x, y, w, h) = line?.map { it.toInt() } ?: listOf(0, 0, 0, 0)
        val result = Math.min(Math.min(x, w - x), Math.min(y, h - y))
        println(result)
    }
}

fun main() {
    BOJ1085().solution()
}
