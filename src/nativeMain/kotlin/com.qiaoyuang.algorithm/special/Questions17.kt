package com.qiaoyuang.algorithm.special

fun test17() {
    printlnResult("ADDBANCAD", "ABC")
    printlnResult("ADDBANCADCBA", "ABC")
    printlnResult("ADDBANCADCBAXY", "ABC")
}

/**
 * Given two strings s and t, find the shortest substring in s that contains all alphabets in t
 */
private fun minWindow(s: String, t: String): String {
    val map = HashMap<Char, Int>()
    t.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    var count = map.size
    var i = 0
    var j = 0
    var minI = 0
    var minJ = 0
    var minLength = Int.MAX_VALUE
    while (j < s.length || (count == 0 && j == s.length)) {
        if (count > 0) {
            val jCH = s[j]
            if (map.containsKey(jCH)) {
                map[jCH] = map[jCH]!! - 1
                if (map[jCH] == 0)
                    count--
            }
            j++
        } else {
            if (j - i < minLength) {
                minLength = j - i
                minI = i
                minJ = j
            }
            val iCH = s[i]
            if (map.containsKey(iCH)) {
                map[iCH] = map[iCH]!! + 1
                if (map[iCH] == 1)
                    count++
            }
            i++
        }
    }
    return if (minLength < Int.MAX_VALUE) s.substring(minI, minJ) else ""
}

private fun printlnResult(s: String, t: String) =
    println("The shortest substring in $s that contains all alphabets in $t is ${minWindow(s, t)}")