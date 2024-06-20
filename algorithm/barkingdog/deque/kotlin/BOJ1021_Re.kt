package algorithm.barkingdog.deque.kotlin

import java.util.ArrayDeque
import java.util.StringTokenizer

class BOJ1021_Re {
}

fun main() {
    var (n, m) = readln().split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>()
    for (i in 1..n) {
        deque.addLast(i)
    }
    var ans = 0
    val st = StringTokenizer(readln())
    while (m-- != 0) {
        // 1 2 3 4 5 6 7 8 9 10
        val e = st.nextToken().toInt()
        val idx = deque.indexOf(e)
        while (deque.peekFirst() != e) {
            // 위치가 앞에서 꺼내야할지 뒤에서 꺼내야할지 결정해야함.
            // 앞에서 꺼내야 하는 경우
            // 10 - 2 < 2
            if (deque.size - idx > idx) {
                deque.addLast(deque.peekFirst())
                deque.removeFirst()
            } else {
                deque.addFirst(deque.peekLast())
                deque.removeLast()
            }

            ans++
        }
        deque.pollFirst()
    }
    println(ans)
}
