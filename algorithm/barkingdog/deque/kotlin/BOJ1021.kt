package algorithm.barkingdog.deque.kotlin

import java.util.ArrayDeque


class BOJ1021 {
}

fun main() {
    var (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ")
    val deque = ArrayDeque<Int>(n)
    for (i in 1..n) {
        deque.addLast(i)
    }
    var result = 0
    var idx = 0
    while (m-- != 0) {
        val e = arr[idx++].toInt()
        val idx = deque.indexOf(e)
        while (deque.peekFirst() != e) {
            if (idx < deque.size - idx) {
                deque.addLast(deque.peekFirst())
                deque.pollFirst()
            } else {
                deque.addFirst(deque.peekLast())
                deque.pollLast()
            }
            result++
        }
        deque.removeFirst()
    }
    println(result)
}
