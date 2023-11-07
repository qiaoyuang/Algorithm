package com.qiaoyuang.algorithm.special

fun test19() {
    printlnResult("Was it a cats I saw?")
    printlnResult("race a car")
}

/**
 * Questions 19: Given a string, judge whether we can delete a character and got a palindrome string
 */
private fun String.isPalindromeAfterDeleteOneCharacter(): Boolean {
    require(isNotEmpty()) { "The string can't be empty" }
    return isPalindromeAfterDeleteOneCharacter(0, lastIndex, true)
}

private fun String.isPalindromeAfterDeleteOneCharacter(p1: Int, p2: Int, oneChance: Boolean): Boolean {
    var pointer1 = p1
    var pointer2 = p2
    while (pointer1 <= pointer2) {
        while (!this[pointer1].isDigit() && !this[pointer1].isLetter())
            pointer1++
        while (!this[pointer2].isDigit() && !this[pointer2].isLetter())
            pointer2--
        if (this[pointer1].equals(this[pointer2], true)) {
            pointer1++
            pointer2--
        } else {
            return if (oneChance)
                leftChange(pointer1 + 1, pointer2) || rightChange(pointer1, pointer2 - 1)
            else
                false
        }
    }
    return !oneChance
}

private fun String.leftChange(p1: Int, p2: Int): Boolean {
    var pointer1 = p1
    while (!this[pointer1].isDigit() && !this[pointer1].isLetter())
        pointer1++
    return isPalindromeAfterDeleteOneCharacter(pointer1, p2, false)
}

private fun String.rightChange(p1: Int, p2: Int): Boolean {
    var pointer2 = p2
    while (!this[pointer2].isDigit() && !this[pointer2].isLetter())
        pointer2--
    return isPalindromeAfterDeleteOneCharacter(p1, pointer2, false)
}

private fun printlnResult(str: String) =
    println("Whether the string $str deletes one letter could get a palindrome string: ${str.isPalindromeAfterDeleteOneCharacter()}")