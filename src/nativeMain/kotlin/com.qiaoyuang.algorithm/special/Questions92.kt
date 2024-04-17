package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test92() {
    printlnResult("00110")
    printlnResult("00110100111011")
}

/**
 * Questions 92: A String just contain 0 and 1, 0 could be changed to 1, 1 could be changed to 0,
 * how many times of changing at least that we can lead all 0s in front of all 1s.
 */
private fun minFlipTimes(str: String): Int {
    if (str.isEmpty())
        return 0

    val dp = Array(2) { IntArray(2) }
    val c0 = str.first()
    dp[0][0] = if (c0 == '0') 0 else 1
    dp[1][0] = if (c0 == '1') 0 else 1

    for (i in 1 ..< str.length) {
        val prevI = (i - 1) % 2
        val prev0 = dp[0][prevI]
        val prev1 = dp[1][prevI]
        val c = str[i]
        val currI = i % 2
        dp[0][currI] = prev0 + (if (c == '0') 0 else 1)
        dp[1][currI] = min(prev0, prev1) + if (c == '1') 0 else 1
    }

    val index = str.lastIndex % 2
    return min(dp[0][index], dp[1][index])
}

private fun printlnResult(str: String) =
    println("At least need ${minFlipTimes(str)} times to modify $str")