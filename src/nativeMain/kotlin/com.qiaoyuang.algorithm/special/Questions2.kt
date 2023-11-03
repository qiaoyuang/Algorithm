package com.qiaoyuang.algorithm.special

fun test2() {
    printlnResult("1011", "10001")
    printlnResult("1010101001", "1001110111")
}

/**
 * Input two strings to present two unsigned binary integers, write a function to implement binary addition
 */
private infix fun String.addBinary(str: String): String {
    require(isNotEmpty() && str.isNotEmpty()) { "The Input strings are illegal" }
    val (bigger, smaller) = if (length > str.length) this to str else str to this
    var biggerIndex = bigger.lastIndex
    var smallerIndex = smaller.lastIndex
    var carry = '0'
    return buildString {
        while (smallerIndex >= 0) {
            val biggerDigital = bigger[biggerIndex--]
            val smallerDigital = smaller[smallerIndex--]

            require(
                biggerDigital == '0' || biggerDigital == '1'
                        && (smallerDigital == '0' || smallerDigital == '1')) {
                "The input strings are illegal"
            }

            when {
                biggerDigital == '1' && smallerDigital == '0' && carry == '0' -> {
                    insert(0, '1')
                    carry = '0'
                }
                biggerDigital == '0' && smallerDigital == '1' && carry == '0' -> {
                    insert(0, '1')
                    carry = '0'
                }
                biggerDigital == '0' && smallerDigital == '0' && carry == '1' -> {
                    insert(0, '1')
                    carry = '0'
                }

                biggerDigital == '0' && smallerDigital == '1' && carry == '1' -> {
                    insert(0, '0')
                    carry = '1'
                }
                biggerDigital == '1' && smallerDigital == '0' && carry == '1' -> {
                    insert(0, '0')
                    carry = '1'
                }
                biggerDigital == '1' && smallerDigital == '1' && carry == '0' -> {
                    insert(0, '0')
                    carry = '1'
                }

                biggerDigital == '0' && smallerDigital == '0' && carry == '0' -> {
                    insert(0, '0')
                    carry = '0'
                }

                biggerDigital == '1' && smallerDigital == '1' && carry == '1' -> {
                    insert(0, '1')
                    carry = '1'
                }
            }
        }

        while (biggerIndex >= 0) {
            val biggerDigital = bigger[biggerIndex--]
            when {
                biggerDigital == '1' && carry == '0' -> {
                    insert(0, '1')
                    carry = '0'
                }
                biggerDigital == '0' && carry == '1' -> {
                    insert(0, '1')
                    carry = '0'
                }
                biggerDigital == '1' && carry == '1' -> {
                    insert(0, '0')
                    carry = '1'
                }
                biggerDigital == '0' && carry == '0' -> {
                    insert(0, '0')
                    carry = '0'
                }
            }
        }

        if (carry == '1')
            insert(0, '1')
    }
}

private fun printlnResult(num1: String, num2: String) {
    val result = num1 addBinary num2
    println("The $num1 adds $num2, we got the result $result, the result is (${(num1.toInt(2) + num2.toInt(2)).toString(2) == result})")
}