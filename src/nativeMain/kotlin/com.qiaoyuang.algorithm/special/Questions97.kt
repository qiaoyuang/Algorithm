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
    val db = Array(s.length) { IntArray(t.length) }
    s.forEachIndexed { i, cs ->
        for (j in 0..min(i, t.lastIndex))
            db[i][j] = if (t[j] == cs) when {
                i - 1 < 0 && j - 1 < 0 -> 1
                i - 1 >= 0 && j - 1 < 0 -> db[i - 1][j] + 1
                else -> db[i - 1][j - 1] + db[i - 1][j]
            } else {
                if (i - 1 < 0) 0 else db[i - 1][j]
            }
    }
    db.forEach {
        it.forEach { i ->
            print("$i ")
        }
        println()
    }
    return db.last().last()
}

private fun countOfSubsequences2(s: String, t: String): Int {
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
    println("The count of all sub-sequences in $s that equal $t is ${countOfSubsequences(s, t)}, ${countOfSubsequences2(s, t)}")