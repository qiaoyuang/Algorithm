package com.qiaoyuang.algorithm.round1

import kotlin.math.pow

fun test67() {
    printlnResult("+2147483647")
    printlnResult("2147483647")
    printlnResult("-2147483647")
    printlnResult("9858")
    printlnResult("-219")
}

/**
 * Questions 67: Convert a String to integer
 */
private fun String.convert2Int(): Int {
    require(isNotEmpty()) { "The input string can't be empty" }
    var result = 0
    when {
        first().isDigit() -> {
            val max = Int.MAX_VALUE.toString()
            require(length <= max.length) { "The input string greater than range of integer" }
            var currentBit = 10.0.pow(length - 1).toInt()
            val isNeedCheckEveryBit = length == max.length
            for (i in indices) {
                require(get(i).isDigit()) { "The input string illegal" }
                val num = get(i).digitToInt()
                if (isNeedCheckEveryBit)
                    require(num <= max[i].digitToInt()) { "The input string illegal" }
                result += currentBit * num
                currentBit /= 10
            }
        }
        first() == '+' -> {
            val max = Int.MAX_VALUE.toString()
            require(length - 1 <= max.length) { "The input string greater than range of integer" }
            var currentBit = 10.0.pow(length - 2).toInt()
            val isNeedCheckEveryBit = length + 1 == max.length
            for (i in 1..lastIndex) {
                require(get(i).isDigit()) { "The input string illegal" }
                val num = get(i).digitToInt()
                if (isNeedCheckEveryBit)
                    require(num <= max[i - 1].digitToInt()) { "The input string illegal" }
                result += currentBit * num
                currentBit /= 10
            }
        }
        first() == '-' -> {
            val min = Int.MIN_VALUE.toString()
            require(length <= min.length) { "The input string greater than range of integer" }
            var currentBit = 10.0.pow(length - 2).toInt()
            val isNeedCheckEveryBit = length == min.length
            for (i in 1..lastIndex) {
                require(get(i).isDigit()) { "The input string illegal" }
                val num = get(i).digitToInt()
                if (isNeedCheckEveryBit)
                    require(num <= min[i].digitToInt()) { "The input string illegal" }
                result += currentBit * num
                currentBit /= 10
            }
        }
        else -> throw IllegalArgumentException("The input string is not a integer")
    }

    if (first() == '-')
        result = -result
    return result
}

private fun printlnResult(num: String) =
    println("Convert string $num to integer is ${num.convert2Int()}")