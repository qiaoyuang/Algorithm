package com.qiaoyuang.algorithm.special

fun test15() {
    printlnResult("abc", "cbadabacg")
}

/**
 * Questions 15: Find all anagrams of s1 in s2, return the indexes
 */
private fun findAnagrams(s1: String, s2: String): List<Int> {
    if (s1.length > s2.length)
        return listOf()
    val map = HashMap<Char, Int>() // Using map is faster than using IntArray that's length is 26, because we save the time to judge all elements equal 0 in the IntArray
    s1.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    var length = map.size
    repeat(s1.length) {
        val c = s2[it]
        if (map.containsKey(c)) {
            map[c] = map[c]!! - 1
            if (map[c] == 0)
                length--
        }
    }
    var i = 0
    var j = s1.length
    val result = ArrayList<Int>()
    while (j < s2.length) {
        if (length == 0)
            result.add(i)
        val cj = s2[j++]
        if (map.containsKey(cj)) {
            map[cj] = map[cj]!! - 1
            if (map[cj] == 0)
                length--
        }
        val ci = s2[i++]
        if (map.containsKey(ci)) {
            if (map[ci] == 0)
                length++
            map[ci] = map[ci]!! + 1
        }
    }
    return result
}

private fun printlnResult(s1: String, s2: String) =
    println("The indexes are ${findAnagrams(s1, s2)} of all anagrams of s1 in s2")