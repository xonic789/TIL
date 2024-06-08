import java.util.Stack

class RotateArray189 {
    fun rotate(nums: IntArray, k: Int) {
//        val stack = Stack<Int>()
//        var currentK = k % nums.size
//        nums.forEach { stack.push(it) }
//        while (currentK > 0) {
//            val num = stack.pop()
//            stack.add(0, num)
//            currentK--
//        }
//        for (i in nums.indices) {
//            nums[i] = stack[i]
//        }

        // 참고: 3번 뒤집으면 k만큼 오른쪽으로 회전하는 것과 같아진다.
        /*
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        val kEffective = k % n // k가 배열 크기를 넘어가는 경우 처리
        reverse(nums, 0, n - 1) // 전체 배열 뒤집기
        reverse(nums, 0, kEffective - 1) // 앞부분 k개 요소 뒤집기
        reverse(nums, kEffective, n - 1) // 나머지 요소 뒤집기
    }

fun reverse(nums: IntArray, start: Int, end: Int) {
var left = start
var right = end
while (left < right) {
    // swap
    val temp = nums[left]
    nums[left] = nums[right]
    nums[right] = temp
    left++
    right--
}
}
         */
        val tempArray = IntArray(nums.size)
        val index = nums.size - (k % nums.size)
        for(i in index..<nums.size) {
            tempArray[i - index] = nums[i]
        }

        for(i in 0..index - 1) {
            tempArray[i + nums.size - index] = nums[i]
        }
        for (i in nums.indices) {
            nums[i] = tempArray[i]
        }
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    RotateArray189().rotate(nums, 3)
    println(nums.toList())
}
