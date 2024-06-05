import java.util.*

class RemoveDuplicatesFromSortedArray26 {
    fun removeDuplicates(nums: IntArray): Int {
        val table = mutableMapOf<Int, Int>()
        var notContainNum = 101
        for (i in nums.indices) {
            val num = nums[i]
            if (table[num] == null) {
                table[num] = 1
            } else {
                nums[i] = notContainNum
            }
        }
        Arrays.sort(nums)
        return table.count()
    }
}



fun main() {
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(RemoveDuplicatesFromSortedArray26().removeDuplicates(nums))
    println(nums.toList())
}
