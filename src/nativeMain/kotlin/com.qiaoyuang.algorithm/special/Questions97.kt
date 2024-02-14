package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test97() {
    printlnResult("appplep", "apple")
}

/**
 * Questions 97: The number of all sub-sequences that equal a string of a string
 */
private fun countOfSubsequences(s: String, t: String): Int {
    require(s.isNotEmpty() && t.isNotEmpty()) { "The parameters can't be empty" }
    val db = IntArray(t.length + 1)
    db[0] = 1
    s.forEachIndexed { i, cs ->
        for (j in min(i, t.lastIndex) downTo 0)
            if (t[j] == cs)
                db[j + 1] += db[j]
    }
    return db.last()
}

private fun printlnResult(s: String, t: String) =
    println("The count of all sub-sequences in $s that equal $t is ${countOfSubsequences(s, t)}")