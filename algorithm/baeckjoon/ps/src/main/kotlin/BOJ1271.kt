package algorithm.baeckjoon.ps.src.main.kotlin

import java.math.RoundingMode

class BOJ1271 {
}

fun divideLargeNumbers(dividend: String, divisor: String): Pair<String, String> {
//    if (divisor == "0") {
//        return Pair("0", "0")
//    }

    var quotient = "" // 몫
    var remainder = "" // 나머지
    var currentDividend = "" // 현재 나눗셈을 진행하는 피제수

    // 피제수의 각 자리수를 하나씩 가져와서 나눗셈을 진행
    for (digit in dividend) {
        currentDividend += digit // 현재 자리 수를 피제수에 추가
        // 현재 피제수가 제수보다 작으면 몫은 0이다
        if (currentDividend.toBigDecimal() < divisor.toBigDecimal()) {
            quotient += "0"
        } else {
            // 현재 피제수가 제수보다 크거나 같으면 몫을 구하고 나머지를 구한다
            var count = 0
            while (currentDividend.toBigDecimal() >= divisor.toBigDecimal()) {
                currentDividend = (currentDividend.toBigDecimal() - divisor.toBigDecimal()).toString()
                count++
            }
            quotient += count
        }
    }

    // 맨 앞의 0을 제외하기
    quotient = quotient.dropWhile { it == '0' }
    currentDividend = currentDividend.dropWhile { it == '0' }

    // 나머지는 현재 피제수가 된다
    remainder = if (currentDividend == "") "0" else currentDividend

    return Pair(quotient, remainder)
}
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toBigInteger() }
    println(n / m)
    println(n % m)
}
