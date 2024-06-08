import java.util.*

class RemoveDuplicatesFromSortedArrayII80 {
    fun removeDuplicates(nums: IntArray): Int {
        val table = mutableMapOf<Int, Int>()
        var notContainNum = 10001
        for (i in nums.indices) {
            val num = nums[i]
            if (table[num] == null || table[num] == 1) {
                var count = table[num] ?: 0
                table[num] = ++count
            } else {
                nums[i] = notContainNum
            }
        }

        Arrays.sort(nums)

        return table.values.sum()
    }
}


fun main() {

    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    println(RemoveDuplicatesFromSortedArrayII80().removeDuplicates(nums))
    println(nums.toList())
}
