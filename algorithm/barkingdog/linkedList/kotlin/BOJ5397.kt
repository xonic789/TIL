package algorithm.barkingdog.linkedList.kotlin

import java.util.*

class BOJ5397 {

}

fun main() {
    val n = readlnOrNull()?.toInt() ?: throw RuntimeException()
    val inputs = mutableListOf<String>()
    for (i in 0 until n) {
        inputs.add(readlnOrNull() ?: throw RuntimeException())
    }

    for (i in 0 until n) {
        val input = inputs[i]
        val result = LinkedList<Char>()
        val iter = result.listIterator()
        for (ch in input) {
            when (ch) {
                '<' -> {
                    if (iter.hasPrevious()) {
                        iter.previous()
                    }
                }
                '>' -> {
                    if (iter.hasNext()) {
                        iter.next()
                    }
                }
                '-' -> {
                    if (iter.hasPrevious()) {
                        iter.previous()
                        iter.remove()
                    }
                }
                else -> {
                    iter.add(ch)
                }
            }
        }
        val sb = StringBuilder()
        result.forEach{sb.append(it)}
        println(sb)
    }
}
