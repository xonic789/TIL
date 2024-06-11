package algorithm.barkingdog.linkedList.kotlin

import java.util.LinkedList

class BOJ1406 {
    fun solution() {
        val resultString = LinkedList<Char>()
        val basicKeyword = readlnOrNull() ?: throw RuntimeException()
        basicKeyword.forEach { resultString.add(it) }
        val n = readlnOrNull()?.toInt() ?: throw RuntimeException()
        val commands = mutableListOf<String>()
        for (i in 0 until n) {
            commands.add(readlnOrNull() ?: throw RuntimeException())
        }
        val iter = resultString.listIterator(resultString.size)
        for (i in 0 until n) {
            val command = commands[i].split(" ")
            when (command[0]) {
                "P" -> {
                    iter.add(command[1][0])
                }
                "L" -> {
                    if (iter.hasPrevious()) {
                        iter.previous()
                    }
                }
                "B" -> {
                    if (iter.hasPrevious()) {
                        iter.previous()
                        iter.remove()
                    }
                }
                "D" -> {
                    if (iter.hasNext()) {
                        iter.next()
                    }
                }
            }
        }
        val sb = StringBuilder()
        resultString.forEach{sb.append(it)}
        println(sb)
    }
}

fun main() {
    BOJ1406().solution()
}
