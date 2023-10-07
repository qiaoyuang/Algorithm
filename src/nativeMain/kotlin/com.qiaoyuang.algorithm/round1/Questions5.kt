package com.qiaoyuang.algorithm.round1

fun test5() {
    val charArray0 = charArrayOf('W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' ', ' ', ' ', ' ')
    charArray0.replaceChar(' ', "%20", 13)
    println("Input: \"We are happy\", replace the ' ' with \"%20\"")
    charArray0.forEach {
        print(it)
    }
    println()
    println("Input: \"We are happy\", replace the '&' with \"!@#\"")
    charArray0.replaceChar('&', "!@#", 13)
    charArray0.forEach {
        print(it)
    }
    println()
    val array1 = intArrayOf(1, 2, 3, -1, -1, -1)
    val array2 = intArrayOf(4, 5, 6)
    println("Input: [1, 2, 3], [4, 5, 6]")
    insetArray(array1, 3, array2)
    array1.forEach {
        print(it)
    }
    println()
    val array11 = intArrayOf(1, 3, 5, -1, -1, -1, -1)
    val array21 = intArrayOf(2, 4, 6, 8)
    println("Input: [1, 3, 5], [2, 4, 6, 8]")
    insetArray(array11, 3, array21)
    array11.forEach {
        print(it)
    }
    println()
    val array12 = intArrayOf(1, 3, 5)
    val array22 = intArrayOf()
    println("Input: [1, 3, 5], []")
    insetArray(array12, 3, array22)
    array12.forEach {
        print(it)
    }
    println()
}

/**
 * Questions 5-1: replace char in CharArray with another string. For example, replace the ' ' to "%20"
 */

private fun CharArray.replaceChar(char: Char, str: String, length: Int) {
    var count = 0
    var index = 0
    while (index < length) {
        val c = this[index]
        if (c == char)
            count++
        index++
    }
    if (count == 0) return
    var diff = (str.length - 1) * count
    index = length - 1
    while (index >= 0) {
        val c = this[index]
        var newIndex = index + diff
        if (newIndex < size) {
            if (c == char) {
                for (i in str.lastIndex downTo 0)
                    this[newIndex--] = str[i]
                diff -= str.length - 1
            } else
                this[newIndex] = c
        }
        index--
    }
}

/**
 * Questions 5-2: We have two sorted IntArray a1 and a2, the a1 have enough space to insert a2, please insert a2 to a1 and sorted.
 */

private fun insetArray(a1: IntArray, a1RealSize: Int, a2: IntArray) {
    var a1Index = a1.lastIndex
    var a1RealIndex = a1RealSize - 1
    var a2Index = a2.lastIndex
    while (a1Index >= 0) {
        if (a1RealIndex < 0) {
            a1[a1Index--] = a2[a2Index--]
            continue
        }
        if (a2Index < 0) {
            a1[a1Index--] = a1[a1RealIndex--]
            continue
        }
        val a1Num = a1[a1RealIndex]
        val a2Num = a2[a2Index]
        if (a2Num >= a1Num) {
            a1[a1Index] = a2Num
            a2Index--
        } else {
            a1[a1Index] = a1Num
            a1RealIndex--
        }
        a1Index--
    }
}