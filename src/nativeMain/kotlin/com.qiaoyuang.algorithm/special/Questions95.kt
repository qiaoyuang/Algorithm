package com.qiaoyuang.algorithm.special

import kotlin.math.max

fun test95() {
    printlnResult("abcde", "badfe")
    printlnResult("abcdefghi", "bpdeqfowhzyi")
}

/**
 * Questions 95: Find the length of the longest sub-sequence of 2 strings
 */
private fun longestSubsequence(str1: String, str2: String): Int {
    if (str1.length < str2.length)
        return longestSubsequence(str2, str1)
    val result = IntArray(str2.length)
    str1.forEachIndexed { i, c1 ->
        str2.forEachIndexed { j, c2 ->
            val preI = i - 1
            val preJ = j - 1
            result[j] = if (c1 == c2)
                (if (preI < 0 || preJ < 0) 0 else result[preJ]) + 1
            else
                max(
                    if (preI < 0) 0 else result[j],
                    if (preJ < 0) 0 else result[preJ],
                )
        }
    }
    return result.last()
}

private fun printlnResult(str1: String, str2: String) =
    println("The length of longest sub-sequence between $str1 and $str2 is ${longestSubsequence(str1, str2)}")