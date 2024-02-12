package com.qiaoyuang.algorithm.special

fun test18() {
    printlnResult("Was it a cat I saw?")
    printlnResult("race a car")
}

/**
 * Questions 18: Judge whether a string is a palindrome
 */
fun String.isPalindrome(): Boolean {
    require(isNotEmpty()) { "The string can't be empty" }
    var pointer1 = 0
    var pointer2 = lastIndex
    while (pointer1 <= pointer2) {
        while (!this[pointer1].isDigit() && !this[pointer1].isLetter())
            pointer1++
        while (!this[pointer2].isDigit() && !this[pointer2].isLetter())
            pointer2--
        if (!this[pointer1++].equals(this[pointer2--], true))
            return false
    }
    return true
}

private fun printlnResult(str: String) =
    println("Whether the string \"$str\" is a palindrome: ${str.isPalindrome()}")