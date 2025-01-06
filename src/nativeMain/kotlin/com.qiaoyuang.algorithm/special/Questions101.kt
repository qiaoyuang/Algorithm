package com.qiaoyuang.algorithm.special

fun test101() {
    printlnResult(3, 4, 1)
    printlnResult(1, 2, 3, 5)
    printlnResult(1, 2, 3, 6)
    printlnResult(1, 2, 3, 8)
}

/**
 * Questions 101: Partition Equal Subset Sum, LeetCode 416
 */
private fun IntArray.is2PartsEqual(): Boolean {
    val sum = sum()
    if (sum % 2 == 1)
        return false
    val load = sum shr 1
    val db = Array(size) { BooleanArray(load + 1) }
    db.forEach { it[0] = true }
    for (i in indices)
        for (j in 1..load)
            db[i][j] = i - 1 >= 0 && (db[i - 1][j] || (j >= this[i] && db[i - 1][j - this[i]]))
    return db.last().last()
}

private fun IntArray.is2PartsEqual2(): Boolean {
    val sum = sum()
    if (sum % 2 == 1)
        return false
    val load = sum shr 1
    val db = BooleanArray(load + 1)
    db[0] = true
    for (i in indices)
        for (j in load downTo 1)
            if (!db[j])
                db[j] = j >= this[i] && db[j - this[i]]
    return db.last()
}

private fun is2PartsEqual(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 == 1)
        return false
    val target = sum shr 1
    val dp = Array(nums.size) { BooleanArray(target + 1) }
    for (i in nums.indices) {
        dp[i][0] = true
        for (j in 1 .. target)
            dp[i][j] = if (i > 0) dp[i - 1][j] || (target >= nums[i] && dp[i - 1][target - nums[i]]) else nums[i] == j
    }
    return dp.last().last()
}

private fun is2PartsEqual2(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 == 1)
        return false
    val target = sum shr 1
    val dp = BooleanArray(target + 1)
    dp[0] = true
    nums.forEach {
        for (j in target downTo 1)
            dp[j] = dp[j] || (j >= it && dp[j - it])
    }
    return dp.last()
}

private fun printlnResult(vararg nums: Int) =
    println("Is the IntArray: ${nums.toList()} could be divided 2 parts that's sums are equal: ${nums.is2PartsEqual()}, ${nums.is2PartsEqual2()}, ${is2PartsEqual(nums)}, ${is2PartsEqual2(nums)}")