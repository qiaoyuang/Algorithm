package com.qiaoyuang.algorithm.special

fun test92() {
    printlnResult("00110")
    printlnResult("00110100111011")
}

/**
 * Questions 92: A String just contain 0 and 1, 0 could be changed to 1, 1 could be changed to 0,
 * how many changes at least that we can lead all 0s in front of all 1s.
 */
private fun String.minFlipTimes(): Int {
    require(isNotEmpty()) { "The string must not be empty" }
    if (length == 1)
        return 0
    var count = 0
    val chars = toCharArray()
    for (i in 1 ..< length) {
        if (chars[i] != chars[i - 1] && chars[i] == '0') {
            chars[i] = '1'
            count++
        }
    }
    return count
}

private fun printlnResult(str: String) =
    println("At least need ${str.minFlipTimes()} times to modify $str")