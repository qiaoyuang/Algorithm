package com.qiaoyuang.algorithm.round1

fun test17() {
    println1toBiggest(1u)
    println1toBiggest(2u)
    println1toBiggest(3u)
}

/**
 * Question17: Give a number n, print the 1 to the biggest number(n digits).
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