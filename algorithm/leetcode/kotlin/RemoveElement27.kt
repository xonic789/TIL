import java.util.*

class RemoveElement27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val notContainNumber = 51
        for (i in nums.indices) {
            if (nums[i] == `val`) {
                nums[i] = notContainNumber
            }
        }

        // -1을 배열 끝으로 이동
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            if (nums[left] == notContainNumber) {
                nums[left] = nums[right]
                nums[right] = notContainNumber
                right--
            } else {
                left++
            }
        }

        return nums.count{it != notContainNumber}
    }
}



fun main() {
    var nums = intArrayOf(3, 2, 2, 3)
    val `val` = 3
    println(RemoveElement27().removeElement(nums, `val`))
    println(nums.contentToString())

    var nums1 = intArrayOf(0,1,2,2,3,0,4,2)
    val `val1` = 2
    Arrays.sort(nums1, 0, nums1.size);
    println(RemoveElement27().removeElement(nums1, `val1`))
    println(nums1.contentToString())
}
