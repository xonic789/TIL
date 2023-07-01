class 약수의합 {
    fun solution(n: Int): Int {
        return (1..n).filter { n % it == 0 }.sum()
    }
}
