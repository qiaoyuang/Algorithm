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
    require(s2.length >= s1.length) { "The input is illegal" }
    val s1CharMap = HashMap<Char, Int>(s1.length)
    s1.forEach {
        s1CharMap[it] = if (s1CharMap.contains(it)) s1CharMap[it]!! + 1 else 1
    }

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
            return true
    }
    return false
}

private fun printlnResult(s1: String, s2: String) =
    println("Is $s2 contain an anagram of $s1: ${isAnagram(s1, s2)}")
