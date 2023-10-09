package com.qiaoyuang.algorithm.round1

import kotlin.math.abs

fun test46() {
    printlnResult(12258)
    printlnResult(-12258)
    printlnResult(1225825)
    printlnResult(0)
    printlnResult(-25262526)
}


/**
 * Questions 46: Translate integer to string, 0-a, 1-b, 2-c...24-y, 25-z. Find the amount of kinds of translation.
 */
private fun Int.findCountOfTranslation(): Int =
    abs(this).toString().findCountOfTranslation(0)

private fun String.findCountOfTranslation(index: Int): Int {
    if (index == length)
        return 1
    val twoNumberCount = if (index + 1 < length && substring(index, index + 2).toInt() <= 25) findCountOfTranslation(index + 2) else 0
    return findCountOfTranslation(index + 1) + twoNumberCount
}

private fun Int.findCountOfTranslationForLoop(): Int {
    val str = abs(this).toString()
    val counts = IntArray(str.length) { 0 }
    for (i in str.lastIndex downTo 0) {
        var count = if (i < str.lastIndex)
            counts[i + 1]
        else
            1

        if (i < str.lastIndex) {
            val digit1 = str[i].digitToInt()
            val digit2 = str[i + 1].digitToInt()
            val converted = digit1 * 10 + digit2
            if (converted in 10..25)
                count += if (i < str.length - 2) counts[i + 2] else 1
        }
        counts[i] = count
    }
    return counts.first()
}

private fun printlnResult(number: Int) =
    println("The number $number has (${number.findCountOfTranslation()}, ${number.findCountOfTranslationForLoop()}) kinds of translation")
