package algorithm.hackerrank.kotlin

class Q2 {
}

fun getMinimumCost(cost: Array<Int>, k: Int): Long {
    // Write your code here
    val n = cost.size
    val memo = LongArray(n + 1){-1}
    fun jump(i: Int): Long {
        if (i == n) return 0
        if (memo[i] != -1L) return memo[i]
        var minCost = Long.MAX_VALUE
        for (j in 1..k) {
            if (i + j <= n) {
                minCost = minOf(minCost, jump(i + j) + cost[i + j - 1])
            }
        }
        memo[i] = minCost
        return minCost
    }

    return jump(0)
}

fun main(args: Array<String>) {
    val costCount = readLine()!!.trim().toInt()

    val cost = Array<Int>(costCount, { 0 })
    for (i in 0 until costCount) {
        val costItem = readLine()!!.trim().toInt()
        cost[i] = costItem
    }

    val k = readLine()!!.trim().toInt()

    val result = getMinimumCost(cost, k)

    println(result)
}
