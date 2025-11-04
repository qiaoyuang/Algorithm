package com.qiaoyuang.algorithm.special

fun test96() {
    printlnResult("aabcc", "dbbca", "aadbbcbcac")
    printlnResult("aabccx", "dbbcaz", "aadbbcbcacxy")
}

/**
 * Questions 96: Interleaving String, LeetCode 97
 */
private fun String.isMadeBy(s1: String, s2: String): Boolean {
    if (length != s1.length + s2.length)
        return false
    if (s1.isEmpty())
        return this == s2
    if (s2.isEmpty())
        return this == s1
    if (s1.length < s2.length)
        return isMadeBy(s2, s1)
    val s3 = this
    val db = BooleanArray(s2.length)
    db[0] = true
    s1.forEachIndexed { i, c1 ->
        s2.forEachIndexed { j, c2 ->
            val id1 = i - 1
            val jd1 = j - 1
            db[j] = when (s3[i + j + 1]) {
                c1 -> id1 < 0 || db[j]
                c2 -> jd1 < 0 || db[jd1]
                else -> false
            }
        }
    }
    return db.last()
}

private fun printlnResult(s1: String, s2: String, s3: String) =
    println("Whether the $s3 could be made by $s1 and $s2: ${s3.isMadeBy(s1, s2)}")