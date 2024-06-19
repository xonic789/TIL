package algorithm.barkingdog.deque.kotlin

import java.util.ArrayDeque
import java.util.Deque

class BOJ10866 {
    class Deque(
        private val MX: Int = 1000005,
//        private val MX: Int = 15,
        val dat: IntArray = IntArray(2 * MX + 1),
        var head: Int = MX,
        var tail: Int = MX,
    ) {

        fun pushFront(x: Int) {
            dat[--head] = x
        }

        fun pushBack(x: Int) {
            dat[tail++] = x
        }

        fun popFront(): Int {
            return dat[head++]
        }

        fun popBack(): Int {
            return dat[tail--]
        }

        fun front(): Int {
            return dat[head]
        }

        fun back(): Int {
            return dat[tail - 1]
        }

        fun size(): Int {
            return tail - head
        }

        fun empty(): Boolean {
            return size() == 0
        }
    }
}

fun main() {
    val n = readln().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    for (i in 0 until n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push_back" -> {
                deque.addFirst(command[1].toInt())
            }

            "push_front" -> {
                deque.addLast(command[1].toInt())
            }

            "front" -> {
                if (deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.peekLast()}\n")
                }
            }

            "back" -> {
                if (deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.peekFirst()}\n")
                }

            }

            "size" -> {
                sb.append("${deque.size}\n")

            }

            "empty" -> {
                sb.append("${if (deque.isEmpty()) 1 else 0}\n")
            }

            "pop_front" -> {
                if (deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.pollLast()}\n")
                }
            }

            "pop_back" -> {
                if (deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.pollFirst()}\n")
                }
            }
        }
    }
    println(sb)
}
