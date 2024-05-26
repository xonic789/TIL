import java.util.*

class MergeSortedArray88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1 // nums1의 마지막 요소 인덱스
        var p2 = n - 1 // nums2의 마지막 요소 인덱스
        var p = m + n - 1 // nums1의 병합 결과를 저장할 위치
        // 참고: 해당 문제에서 non-decreasing order는 숫자가 증가하거나 증가하지 않을 수 있지만 결코 감소하지 않는 경우이다.
        // 예: 1, 2, 2, 3, 4, 5, 6
        // merge sort 중 merge 부분

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--]
            } else {
                nums1[p] = nums2[p2--]
            }
            p--
        }

        // nums2에 남은 요소가 있는 경우
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--]
        }
    }
}

fun main() {
    MergeSortedArray88().merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)

}
