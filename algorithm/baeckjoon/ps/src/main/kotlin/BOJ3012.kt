import java.util.Stack

class BOJ3012 {

}

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val leftBrackets = listOf('(', '[', '{')
    val rightBrackets = listOf(')', ']', '}')
    val mod = 100000L

    fun dfs(index: Int, stack: Stack<Char>): Long {
        if (index == n) {
            return if (stack.isEmpty()) 1 else 0 // 스택이 비어있어야 올바른 괄호 문자열
        }

        var count = 0L

        fun isPair(open: Char, close: Char): Boolean {
            return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}')
        }
        when (s[index]) {
            '(', '[', '{' -> {
                stack.push(s[index])
                count = (count + dfs(index + 1, stack))
                if (stack.isNotEmpty())
                stack.pop()
            }
            ')', ']', '}' -> {
                if (!stack.isEmpty() && isPair(stack.peek(), s[index])) { // 짝이 맞는 경우
                    stack.pop()
                    count = (count + dfs(index + 1, stack))
                }
            }
            '?' -> {
                for (bracket in listOf('(', '[', '{', ')', ']', '}')) {
                    if (leftBrackets.contains(bracket)) {
                        stack.push(bracket)
                        count = (count + dfs(index + 1, stack))
                        if (stack.isNotEmpty())
                            stack.pop()
                    } else {
                        if (stack.isEmpty() || !isPair(stack.peek(), bracket)) {
                            continue
                        }
                        stack.pop()
                        count = (count + dfs(index + 1, stack))
                    }
                }
            }
        }
        return count
    }


    println(dfs(0, Stack<Char>()))
}
