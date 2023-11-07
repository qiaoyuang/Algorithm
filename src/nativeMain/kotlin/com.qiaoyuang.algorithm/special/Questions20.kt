package com.qiaoyuang.algorithm.special

fun test20() {
    printlnResult("abc")
    printlnResult("aaa")
    printlnResult("aaabaaa")
}

/**
 * Questions 20: Get the count of palindrome substrings in a string
 */
private fun String.getPalindromeCount(): Int {
    require(isNotEmpty()) { "The string can't be empty" }
    if (length == 1)
        return 1
    var count = length
    var start = 0
    var end = 1
    while (start <= lastIndex - 1 && end <= lastIndex) {
        if (this[start] == this[end]) {
            count++
            var pointer1 = start - 1
            var pointer2 = end + 1
            while (pointer1 >= 0 && pointer2 <= lastIndex) {
                if (this[pointer1--] == this[pointer2++])
                    count++
                else
                    break
            }
        }
        if (end - start == 1)
            end++
        else
            start++
    }
    return count
}

private fun printlnResult(str: String) =
    println("The string $str contained ${str.getPalindromeCount()} palindrome substrings")