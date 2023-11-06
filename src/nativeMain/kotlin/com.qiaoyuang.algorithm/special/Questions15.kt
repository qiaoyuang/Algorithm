package com.qiaoyuang.algorithm.special

fun test15() {
    printlnResult("abc", "cbadabacg")
}

/**
 * Questions 15: Find all anagrams of s1 in s2, return the indexes
 */
private fun findAnagrams(s1: String, s2: String): List<Int> {
    require(s2.length >= s1.length) { "The input is illegal" }
    val s1CharMap = HashMap<Char, Int>(s1.length)
    s1.forEach {
        s1CharMap[it] = if (s1CharMap.contains(it)) s1CharMap[it]!! + 1 else 1
    }

    val results = ArrayList<Int>()
    val copyMap = HashMap<Char, Int>(s1.length)
    for (i in 0 .. s2.length - s1.length) {
        s1CharMap.forEach { (key, value) ->
            copyMap[key] = value
        }

        for (j in i ..< i + s1.length) {
            val c = s2[j]

            if (copyMap.contains(c)) {
                copyMap[c] = copyMap[c]!! - 1
                if (copyMap[c] == 0)
                    copyMap.remove(c)
            } else
                continue
        }

        if (copyMap.isEmpty())
            results.add(i)
    }
    return results
}

private fun printlnResult(s1: String, s2: String) =
    println("The indexes are ${findAnagrams(s1, s2)} of all anagrams of s1 in s2")