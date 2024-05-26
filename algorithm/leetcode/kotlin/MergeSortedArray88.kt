import java.util.*

class MergeSortedArray88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // return 이 없고 nums1을 직접 수정한다.
        // m 은 nums1 에 원소의 수, n 은 nums2 에 원소의 수
        // m - nums.size
        // 6 - 3 = 3 -> 3번째부터 nums.size까지
        //
        if (n == 0) {
            Arrays.sort(nums1, 0, nums1.size)
            return
        }
        if (m == 0) {
            for (i in 0 until n) {
                nums1[i] = nums2[i]
            }
            Arrays.sort(nums1, 0, nums1.size)
            return
        }

        for (i in m until nums1.size) {
            nums1[i] = nums2[i - m]
        }

        Arrays.sort(nums1, 0, nums1.size)
        nums1.forEach { print("$it ") }
    }
}

fun main() {
    // 10^9 = 1000000000
    MergeSortedArray88().merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)

}
