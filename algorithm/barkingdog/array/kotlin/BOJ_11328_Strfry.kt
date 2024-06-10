class BOJ_11328_Strfry {
    fun solution() {
        val n = readlnOrNull()?.toInt() ?: 0
        val strings = mutableListOf<List<String>>()
        for (i in 0 until n) {
            strings.add(readlnOrNull()?.split(" ") ?: listOf("", ""))
        }
        for (i in 0 until n) {
            val arr = strings[i]
            val a = arr[0]
            val b = arr[1]
            // a, b의 길이가 다를 때 Impossible
            IntArray(26) { 0 }.let { _arr ->
                a.forEach { _arr[it - 'a']++ }
                b.forEach { _arr[it - 'a']-- }
                if (_arr.any { it != 0}) {
                    println("Impossible")
                } else {
                    println("Possible")
                }
            }
        }
    }
}

fun main() {
    BOJ_11328_Strfry().solution()
}
