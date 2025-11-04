package com.qiaoyuang.algorithm.special

fun test117() {
    printlnResult("tars", "rats", "arts", "star")
}

/**
 * Questions 117: Input a string array, divide the array to different group that contains similar strings, find the count of groups.
 * Similar: if a string exchange 2 letters, and we can get the other string, we can say these 2 strings are similar
 */
private fun groupCount(strings: Array<out String>): Int {
    val fathers = IntArray(strings.size) { it }
    var count = strings.size
    for (i in 0 ..< strings.lastIndex)
        for (j in i + 1 ..< strings.size)
            if (isSimilarWord(strings[i], strings[j]) && union(i, j, fathers))
                count--
    return count
}

private fun findFather(i: Int, fathers: IntArray): Int {
    if (fathers[i] != i)
        fathers[i] = findFather(fathers[i], fathers)
    return fathers[i]
}

private fun union(i: Int, j: Int, fathers: IntArray): Boolean {
    val fatherOfI = findFather(i, fathers)
    val fatherOfJ = findFather(j, fathers)
    val result = fatherOfI != fatherOfJ
    if (fatherOfI != fatherOfJ)
        fathers[fatherOfJ] = fatherOfI
    return result
}

private fun isSimilarWord(word1: String, word2: String): Boolean {
    if (word1.length != word2.length)
        return false
    var diff1: Char? = null
    var diff2: Char? = null
    var isUsed = false
    for (i in word1.indices)
        if (word1[i] != word2[i]) {
            if (diff1 == null) {
                diff1 = word1[i]
                diff2 = word2[i]
            } else if (isUsed) {
                return false
            } else {
                if (diff1 == word2[i] && diff2 == word1[i])
                    isUsed = true
                else
                    return false
            }
        }
    return true
}

private fun printlnResult(vararg strings: String) =
    println("There are ${groupCount(strings)} groups for strings: ${strings.toList()}")