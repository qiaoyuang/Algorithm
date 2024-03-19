package com.qiaoyuang.algorithm.special

fun test14() {
    printlnResult("ac", "dgcaf")
    printlnResult("tops", "tuacstopszpxm")
    printlnResult("ac", "dgccaaf")
    printlnResult("tops", "tuacstotpzpxm")
    printlnResult("tops", "pots")
    printlnResult("tops", "potp")
}

/**
 * Questions 14: Judge whether a string s2 contain any of an anagram of string s1
 */
private fun isAnagram(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false
    val map = HashMap<Char, Int>() // Using map is faster than using IntArray that's length is 26, because we save the time to judge all elements equal 0 in the IntArray
    s1.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    var length = map.size
    repeat(s1.length) { j ->
        val c = s2[j]
        if (map.containsKey(c)) {
            map[c] = map[c]!! - 1
            if (map[c] == 0)
                length--
        }
    }
    if (length == 0)
        return true
    var i = 0
    var j = s1.length
    while (j < s2.length) {
        val cj = s2[j]
        if (map.containsKey(cj)) {
            map[cj] = map[cj]!! - 1
            if (map[cj] == 0)
                length--
        }
        val ci = s2[i]
        if (map.containsKey(ci)) {
            if (map[ci] == 0)
                length++
            map[ci] = map[ci]!! + 1
        }
        if (length == 0)
            return true
        i++
        j++
    }
    return false
}

private fun printlnResult(s1: String, s2: String) =
    println("Is $s2 contain an anagram of $s1: ${isAnagram(s1, s2)}")
