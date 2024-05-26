package algorithm.hackerrank.kotlin

class Q3 {

}

fun findConsistentLogs(userEvent: Array<Int>): Int {
    // Write your code here
    var maxLen = 0
    var left = 0
    val n = userEvent.size
    val freqMap = mutableMapOf<Int, Long>()

    for (right in 0 until n) {
        freqMap[userEvent[right]] = freqMap.getOrDefault(userEvent[right], 0) + 1

        while (freqMap.values.minOrNull()!! > userEvent.groupBy {it}.values.minOf { it.size }) {
            freqMap[userEvent[left]] = freqMap.getOrDefault(userEvent[left], 0) - 1
            if (freqMap[userEvent[left]] == 0L) {
                freqMap.remove(userEvent[left])
            }
            left++
        }

        maxLen = maxOf(maxLen, right - left + 1)

    }
    return maxLen
}

fun main() {
    val userEventCount = readLine()!!.trim().toInt()

    val userEvent = Array<Int>(userEventCount, { 0 })
    for (i in 0 until userEventCount) {
        val userEventItem = readLine()!!.trim().toInt()
        userEvent[i] = userEventItem
    }

    val result = findConsistentLogs(userEvent)

    println(result)
}
