package algorithm.barkingdog.queue.kotiln

import java.io.BufferedWriter
import java.io.OutputStreamWriter

class BOJ10854 {
    class Queue(
        val dat: IntArray = IntArray(20000001),
        private var front: Int = 0,
        var back: Int = 0,
        var size: Int = 0,
    ) {
        fun push(x: Int) {
            dat[back++] = x
            size++
        }

        fun pop(): Int {
            size--
            return dat[front++]
        }

        fun front(): Int {
            return dat[front]
        }

        fun back(): Int {
            return dat[back - 1]
        }

        fun size(): Int {
            return size
        }

        fun empty(): Boolean {
            return back - front == 0
        }
    }
}

fun main() {
    val n = readln().toInt()
    val queue = BOJ10854.Queue()
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    for (i in 0 until n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push" -> {
                queue.push(command[1].toInt())
            }

            "front" -> {
                if (queue.empty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.front()}\n")
                }
            }

            "back" -> {
                if (queue.empty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.back()}\n")
                }
            }

            "size" -> {
                sb.append("${queue.size()}\n")
            }

            "empty" -> {
                sb.append("${if (queue.empty()) 1 else 0}\n")
            }

            "pop" -> {
                if (queue.empty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.pop()}\n")
                }
            }
        }
    }
    bw.write(sb.toString())
    bw.flush()
}
