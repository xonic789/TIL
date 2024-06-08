class Candy135 {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }
        // i - 1 비교 후 본인의 레이팅이 i-1 보다 크면 i-1의 캔디수 + 1 을 해준다.
        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }
        // i + 1 비교 후 본인의 레이팅이 i+1 보다 크면 i+1의 본인의 캔디와 본인 + 1의 캔디의 +1 에서 큰 값을 취한다.
        // 앞사람 보단 레이팅이 높으면 많이 가졌고 && 뒷 사람보다 레이팅이 높으면 많이 가지게 된다.
        for (i in ratings.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
            }
        }
        return candies.sum()
    }
}


fun main() {
    var ratings = intArrayOf(1, 0, 2)
    println(Candy135().candy(ratings))
    println(ratings.contentToString())

    var ratings1 = intArrayOf(1, 2, 2)
    println(Candy135().candy(ratings1))
    println(ratings1.contentToString())
}
