package com.qiaoyuang.algorithm.special

fun test32() {
    printlnResult("anagram", "nagaram")
    printlnResult("ab", "ab")
    printlnResult("ba", "ab")
}

/**
 * Questions 32: Judge two strings are anagrams for each other
 */
private infix fun String.isAnagrams(t: String): Boolean {
    val s = this
    if (s.length != t.length)
        return false
    val array = IntArray(26)
    var isSequenceSame = true
    repeat(length) { i ->
        val sc = s[i].lowercaseChar()
        val tc = t[i].lowercaseChar()
        if (sc != tc) {
            if (isSequenceSame)
                isSequenceSame = false
            array[sc.code - 'a'.code]++
            array[tc.code - 'a'.code]--
        }
    }
    return !isSequenceSame && array.all { it == 0 }
}

private fun printlnResult(s: String, t: String) =
    println("Are the $s and $t anagrams for each other: ${s isAnagrams t}")