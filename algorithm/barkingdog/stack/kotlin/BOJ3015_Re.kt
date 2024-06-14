package algorithm.barkingdog.stack.kotlin

import java.util.*

class BOJ3015_Re {
}

fun main() {
    val n = readln().toInt()
    // 같은 키를 가진 사람들은 상대적으로 해당 사람들보다 키가 큰 사람이 줄 뒤에 있으면 키가 큰 사람은 키가 같은 사람들을 모두 볼 수 있다는 전제가 있다.
    // 그러므로 스택에는 줄에 같은 키가 몇명이 있는지 저장할 필요가 있다.
    val stack = Stack<Pair<Int, Int>>()
    val heights = IntArray(n){readln().toInt()}
    var count = 0L
    for (height in heights) {
        var sameCount = 1
        // 현재 키가 스택에 저장돼있는 키보다 크거나 같으면
        while (stack.isNotEmpty() && height >= stack.peek().first ) {
            val stackPoped = stack.pop()
            count += stackPoped.second

            if (stackPoped.first == height) {
                sameCount += stackPoped.second
            }
        }

        if (stack.isNotEmpty()) {
            count++
        }
        stack.push(height to sameCount)
    }
    println(count)
}
