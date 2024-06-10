class BestTimeToBuyAndSellStockII122 {
    fun maxProfit(prices: IntArray): Int {
        return maxProfit(prices, 0, prices.size)
    }

    private fun maxProfit(prices: IntArray, s: Int, e: Int): Int {
        var maxProfit = 0
        var minPrice = prices[s]
        for (i in s until e) {
            // day 가 선형적으로 증가하는 관점에서 1일차부터 최솟값을 집어넣는다. (매수 했다고 가정하는 것)
            // 만약 1일차에 매수한 금액보다 2일차 주식 가격이 더 낮다면 2일차를 매수했다고 가정하며 갱신한다
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else {
                // 결국 최소금액보다 현재 주식 가격이 커진다면 매도 후 maxProfit에 더해준다.
                maxProfit += prices[i] - minPrice
                // 매도 후 최소금액을 현재 주식 가격으로 갱신한다. (매수 했다고 가정)
                minPrice = prices[i]
            }
        }
        return maxProfit
    }
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(BestTimeToBuyAndSellStockII122().maxProfit(prices))
}
