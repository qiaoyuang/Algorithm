package com.qiaoyuang.algorithm.round1

fun test46() {
    printlnResult(12258)
    printlnResult(-12258)
    printlnResult(1225825)
    printlnResult(0)
    printlnResult(-25262526)
}


/**
 * Questions 47: Translate integer to string, 0-a, 1-b, 2-c...24-y, 25-z. Find the amount of kinds of translation.
 */
private fun Int.findCountOfTranslation(): Int =
    toString().findCountOfTranslation(if (this < 0) 1 else 0)

private fun String.findCountOfTranslation(index: Int): Int {
    if (index == length)
        return 1
    val twoNumberCount = if (index + 1 < length && substring(index, index + 2).toInt() <= 25) findCountOfTranslation(index + 2) else 0
    return findCountOfTranslation(index + 1) + twoNumberCount
}

private fun printlnResult(number: Int) =
    println("The number $number has ${number.findCountOfTranslation()} kinds of translation")
