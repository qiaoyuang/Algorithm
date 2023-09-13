package com.qiaoyuang.algorithm.round1

fun test17() {
    println1toBiggest(1u)
    println1toBiggest(2u)
    println1toBiggest(3u)

    printlnResult2("123456", "5678")
    printlnResult2("9999999", "1")
    printlnResult2("5555", "5555")
    printlnResult2("0", "0")
    printlnResult2("-123456", "-5678")
    printlnResult2("-999999", "-1")
    printlnResult2("-5555", "-5555")
    printlnResult2("123456", "-5678")
    printlnResult2("-9999999", "1")
    printlnResult2("5555", "-5555")
}

/**
 * Question 17-1: Give a number n, print the 1 to the biggest number(n digits).
 */
private fun println1toBiggest(n: UInt) {
    if (n == 0u)
        throw IllegalArgumentException("The n must great than 0")
    print("The sequence is: ")
    val biggest = buildString {
        repeat(n.toInt()) {
            append('9')
        }
    }
    val numberBuilder = StringBuilder("1")
    var number = numberBuilder.toString()
    while (number != biggest) {
        print("$number, ")

        for (i in numberBuilder.lastIndex downTo 0) {
            val charI = numberBuilder[i]
            if (charI == '9') {
                numberBuilder[i] = '0'
                if (i == 0)
                    numberBuilder.insert(0, 1)
            } else {
                numberBuilder[i] = (charI.digitToInt() + 1).digitToChar()
                break
            }
        }

        number = numberBuilder.toString()
    }
    println("$number;")
}

/**
 * Questions 17-2: Use String to implement the addition of two integer
 */
private infix fun String.add(target: String): String = when {
    first() == '-' && target.first() == '-' -> {
        val (small, big) = if (length < target.length)
            this to target
        else
            target to this
        twoNegative(small, big)
    }
    first() != '-' && target.first() != '-' -> {
        val (small, big) = if (length < target.length)
            this to target
        else
            target to this
        twoPositive(small, big)
    }
    else -> {
        val (positive, negative) = if (first() == '-') target to this else this to target
        positiveAndNegative(positive, negative)
    }
}

private fun twoPositive(small: String, big: String): String = buildString {
    val diff = big.length - small.length
    var carry = 0
    for (smallIndex in small.lastIndex downTo 0) {
        val bigIndex = smallIndex + diff
        val sum = (small[smallIndex].digitToInt() + big[bigIndex].digitToInt() + carry).toString()
        append(sum.last())
        carry = if (sum.length > 1) sum.first().digitToInt() else 0
    }
    val startIndex = diff - 1
    if (startIndex > 0) for (i in startIndex downTo 0) {
        val sum = (big[i].digitToInt() + carry).toString()
        append(sum.last())
        carry = if (sum.length > 1) sum.first().digitToInt() else 0
    }
    if (carry > 0)
        append(carry)
}.reversed()

private fun twoNegative(small: String, big: String): String = buildString {
    var smallIndex = small.lastIndex
    var bigIndex = big.lastIndex
    var carry = 0
    while (bigIndex > 0) {
        val sum = if (smallIndex > 0)
            (small[smallIndex--].digitToInt() + big[bigIndex--].digitToInt() + carry).toString()
        else
            (big[bigIndex--].digitToInt() + carry).toString()
        append(sum.last())
        carry = if (sum.length > 1) sum.first().digitToInt() else 0
    }
    if (carry > 0)
        append(carry)
    append('-')
}.reversed()

private fun positiveAndNegative(positive: String, negative: String): String = buildString {
    var isAbsPositiveBigger = true
    val (big, small) = when {
        positive.length > negative.lastIndex -> positive to negative
        positive.length < negative.lastIndex -> {
            isAbsPositiveBigger = false
            negative to positive
        }
        else -> {
            var result = 0
            for (i in 0..positive.lastIndex) {
                when {
                    positive[i] > negative[i + 1] -> {
                        result = 1
                        break
                    }
                    positive[i] < negative[i + 1] -> {
                        result = -1
                        isAbsPositiveBigger = false
                        break
                    }
                }
            }
            when {
                result > 0 -> positive to negative
                result < 0 -> {
                    isAbsPositiveBigger = false
                    negative to positive
                }
                else -> {
                    append('0')
                    return@buildString
                }
            }
        }
    }

    var smallIndex = small.lastIndex
    var bigIndex = big.lastIndex
    var carry = 0
    val (bigFinalIndex, smallFinalIndex) = if (isAbsPositiveBigger) intArrayOf(0, 1) else intArrayOf(1, 0)
    while (bigIndex >= bigFinalIndex) {
        val bigDigital = big[bigIndex--].digitToInt()
        val subtrahend = if (smallIndex >= smallFinalIndex)
            small[smallIndex--].digitToInt() + carry
        else
            carry

        val sub = if (bigDigital >= subtrahend) {
            carry = 0
            bigDigital - subtrahend
        } else {
            carry = 1
            bigDigital + 10 - subtrahend
        }
        append(sub.toString().last())
    }
    if (!isAbsPositiveBigger)
        append('-')
}.reversed()

private fun printlnResult2(num1: String, num2: String) {
    val sum = num1 add num2
    println("The sum of $num1 and $num2 is ${num1 add num2}, is the result correct: ${sum.toInt() == (num1.toInt() + num2.toInt())}")
}
