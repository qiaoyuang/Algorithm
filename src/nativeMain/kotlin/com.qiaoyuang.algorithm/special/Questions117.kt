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
        for (j in i + 1 .. strings.lastIndex)
            if (strings[i] isSimilarWord strings[j] && union(fathers, i, j))
                count--
    return count
}

private infix fun String.isSimilarWord(word: String): Boolean {
    var diff = 0
    for (i in indices)
        if (this[i] != word[i])
            diff++
    return diff == 2
}

private fun CharArray.exchange(i: Int, j: Int): CharArray {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
    return this
}

private fun findFathers(fathers: IntArray, i: Int): Int {
    if (fathers[i] != i)
        fathers[i] = findFathers(fathers, fathers[i])
    return fathers[i]
}

private fun union(fathers: IntArray, i: Int, j: Int): Boolean {
    val fatherOfI = findFathers(fathers, i)
    val fatherOfJ = findFathers(fathers, j)
    val result = fatherOfI != fatherOfJ
    if (result)
        fathers[fatherOfI] = fatherOfJ
    return result
}

private fun printlnResult(vararg strings: String) =
    println("There are ${groupCount(strings)} groups for strings: ${strings.toList()}")