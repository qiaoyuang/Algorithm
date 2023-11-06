package com.qiaoyuang.algorithm.special

fun test17() {
    printlnResult("ADDBANCAD", "ABC")
    printlnResult("ADDBANCADCBA", "ABC")
    printlnResult("ADDBANCADCBAXY", "ABC")
}

/**
 * Given two strings s and t, find the shortest substring in s that contains all alphabets in t
 */
private fun findShortestSubstring(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty())
        return ""

    val charHashSet = HashSet<Char>(t.length)
    t.forEach {
        charHashSet.add(it)
    }
    val copySet = HashSet<Char>(t.length)
    var start = 0
    var end: Int

    var shortest = ""

    while (start < s.length) {
        charHashSet.forEach {
            copySet.add(it)
        }

        while (start < s.length) {
            if (copySet.contains(s[start]))
                break
            else
                start++
        }

        end = start
        val currentHashMap = HashMap<Char, Int>(t.length)
        while (end < s.length && copySet.isNotEmpty()) {
            val c = s[end++]
            if (charHashSet.contains(c)) {
                copySet.remove(c)
                currentHashMap[c] = if (currentHashMap[c] == null) 1 else currentHashMap[c]!! + 1
            }
        }

        if (copySet.isNotEmpty())
            return shortest

        while (start < end) {
            val c = s[start++]
            if (currentHashMap.contains(c)) {
                if (currentHashMap[c]!! > 1)
                    currentHashMap[c] = currentHashMap[c]!! - 1
                else
                    break
            }
        }

        if (shortest.isEmpty() || end - start - 1 < shortest.length)
            shortest = s.substring(start - 1, end)
    }

    return shortest
}

private fun printlnResult(s: String, t: String) =
    println("The shortest substring in $s that contains all alphabets in $t is ${findShortestSubstring(s, t)}")