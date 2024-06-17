package algorithm.barkingdog.stack.kotlin

class BOJ10828_Re {

    class Stack(
        val MX: Int = 10000005,
        val dat: IntArray = IntArray(MX),
        var pos: Int = 0
    ) {

        fun push(x: Int) {
            dat[pos++] = x
        }

        fun pop(): Int {
            return dat[--pos]
        }

        fun peek(): Int {
            return dat[pos - 1]
        }

        fun empty(): Boolean {
            return pos == 0
        }

        fun size(): Int {
            return pos
        }
    }

}

fun main() {
    val n = readln().toInt()
    val stack = BOJ10828_Re.Stack()
    for (i in 0 until n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push" -> {
                stack.push(command[1].toInt())
            }

            "pop" -> {
                if (stack.empty()) {
                    println(-1)
                } else {
                    println(stack.pop())
                }
            }

            "size" -> {
                println(stack.size())
            }

            "empty" -> {
                println(if (stack.empty()) 1 else 0)
            }

            "top" -> {
                if (stack.empty()) {
                    println(-1)
                } else {
                    println(stack.peek())
                }
            }
        }

    }

}
