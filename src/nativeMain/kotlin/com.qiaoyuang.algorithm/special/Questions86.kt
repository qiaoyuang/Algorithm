package com.qiaoyuang.algorithm.special

fun test86() {
    println("google".splitToPalindromeStrings())
}

/**
 * Questions 86: Palindrome Partitioning, LeetCode 131
 */
private fun String.splitToPalindromeStrings(): List<List<String>> {
    require(isNotEmpty()) { "The string can't be empty" }
    return buildList {
        backTrack(this@splitToPalindromeStrings, mutableListOf(), 0, 1)
    }
}

private fun MutableList<List<String>>.backTrack(str: String, subset: MutableList<String>, i: Int, j: Int) {
    if (i == str.length)
        add(ArrayList(subset))
    else if (j > str.length)
        return
    else {
        val sub = str.substring(i, j)
        if (sub.isPalindrome()) {
            subset.add(sub)
            backTrack(str, subset, j, j + 1)
            subset.removeLast()
        }
        backTrack(str, subset, i, j + 1)
    }
}

private fun CharSequence.isPalindrome(): Boolean {
    return when {
        length == 1 -> true
        isEmpty() -> false
        else -> {
            var i = 0
            var j = lastIndex
            while (i < j) {
                if (this[i++] != this[j--])
                    return false
            }
            true
        }
    }
}