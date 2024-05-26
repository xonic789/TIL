package algorithm.hackerrank.kotlin

class Q1 {
}


/*
 * Complete the 'getMaxProfit' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY pnl
 *  2. INTEGER k
 */

fun getMaxProfit(pnl: Array<Int>, k: Int): Long {
    // Write your code here
    val n = pnl.size
    var maxProfit = Long.MIN_VALUE
    for (windowSize in 1..k) {
        var currentProfit = 0L
        for (i in 0 until windowSize) {
            currentProfit += pnl[i]
        }
        // 최대 이익 계산
        for (i in windowSize until n) {
            currentProfit += pnl[i] - pnl[i - windowSize]
            maxProfit = maxOf(maxProfit, currentProfit)
        }
        maxProfit = maxOf(maxProfit, currentProfit)
    }
    return maxProfit
}

fun main(args: Array<String>) {
    val pnlCount = readLine()!!.trim().toInt()

    val pnl = Array<Int>(pnlCount, { 0 })
    for (i in 0 until pnlCount) {
        val pnlItem = readLine()!!.trim().toInt()
        pnl[i] = pnlItem
    }

    val k = readLine()!!.trim().toInt()

    val result = getMaxProfit(pnl, k)

    println(result)
}
// 2, 5, -7, 8, -6, 4, 1, -9

// 2 + 5 + -7 + 8 + -6 = 2
// 5 + -7 + 8 + -6 + 4 = 4
// -7 + 8 + -6 + 4 + 1 = 0
// 8 + -6 + 4 + 1 + -9 = -2
// -6 + 4 + 1 + -9 + 2 = -8
// 4 + 1 + -9 + 2 + 5 = 3
// 1 + -9 + 2 + 5 + -7 = -8
// -9 + 2 + 5 + -7 + 8 = -1
