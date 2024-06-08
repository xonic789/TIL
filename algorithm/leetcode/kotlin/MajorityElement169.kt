class MajorityElement169 {
    fun majorityElement(nums: IntArray): Int {
        var table = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (table.containsKey(nums[i])) {
                table[nums[i]] = table[nums[i]]!! + 1
            } else {
                table[nums[i]] = 1
            }
        }
        return table.entries.sortedByDescending { it.value }[0].key
    }
}

fun main() {

}
