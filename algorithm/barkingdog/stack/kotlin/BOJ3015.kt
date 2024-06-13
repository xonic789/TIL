package algorithm.barkingdog.stack.kotlin

import java.util.*

class BOJ3015 {
}

fun main() {
    val n = readln().toInt()
    // 스택을 하나 만든다
    val stack = Stack<Pair<Int, Int>>()
    val heights = IntArray(n){ readln().toInt() }
    var count = 0L
    for (height in heights) {
        var sameCount = 1
        // 스택 맨 위가 본인보다 작거나 같다는건 그 뒤사람까지 봐야하는것이고
        // 스택 맨 위가 본인보다 크다는 건 걔는 그 사람까지밖에 못본다는 것이다.
        while (stack.isNotEmpty() && stack.peek().first <= height) {
            // 스택의 맨 위(height의 직전 키)가 지금의 키보다 작을 때까지 스택에서 뺀다
            // 같은 키를 가진 사람은 볼 수 있다.
            val pop = stack.pop()
            count += pop.second

            // 빼고 그 직전 키가 지금의 키와 같다면 sameCount를 올려준다.AAA
            if (pop.first == height) {
                sameCount += pop.second
            }
        }
        if (!stack.isEmpty()) {
            count++
        }
        stack.push(height to sameCount)
    }
    println(count)
}
