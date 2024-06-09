class BestTimeToBuyAndSellStock121 {
    fun maxProfit(prices: IntArray): Int {
        // 먼저 왼쪽부터 탐색해서 최소값을 찾고 && 최소값 이후의 값들 중에서 최대값을 찾는다.
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (i in prices.indices) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice
            }
        }
        return maxProfit
    }
}

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(BestTimeToBuyAndSellStock121().maxProfit(prices))
}
