package com.qiaoyuang.algorithm.round1

fun test19() {
    printlnResult("aaa", "a.a")
    printlnResult("aaa", "ab*ac*a")
    printlnResult("aaa", "aa.a")
    printlnResult("aaa", "ab*a")
    printlnResult("abcd", "abce")
    printlnResult("abccccccc", "abc*")
    printlnResult("abcccccccd", "abc*d")
    printlnResult("abcccccccd", "abc*dd")
    printlnResult("", "z*")
}

/**
 * Questions19: Regex matching. The '.' present any character,
 * and '*' present the character before the '*' could appear many times(include 0)
 */
private fun regexMatching(str: String, regex: String): Boolean = when {
    regex.startsWith('*') -> throw IllegalArgumentException("The regex is illegal")
    str == regex -> true
    str.isEmpty() -> regex.length == 2 && regex.last() == '*'
    else -> {
        var i = 0
        var j = 0
        var result = true
        while (result && i < regex.length) {
            if (j == str.length) {
                result = false
                break
            }
            when (regex[i]) {
                '.', str[j] -> {
                    i++
                    j++
                }
                '*' -> {
                    val pre = regex[i - 1]
                    while (pre == str[j]) {
                        j++
                        if (j >= str.length) {
                            if (i != regex.lastIndex)
                                result = false
                            break
                        }
                    }
                    i++
                }
                else -> when {
                    ++i >= regex.length -> result = false
                    regex[i] != '*' -> result = false
                    else -> i++
                }
            }
        }
        if (i >= regex.length && j < str.length)
            false
        else
            result
    }
}

private fun printlnResult(str: String, regex: String) =
    println("Is string $str could match pattern $regex: ${regexMatching(str, regex)}")