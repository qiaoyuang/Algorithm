package com.qiaoyuang.algorithm.round1

fun test58() {
    printlnResult1("I am a student.")
    printlnResult1("I am  a   student. ")
    printlnResult2(charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 2)
    printlnResult2(charArrayOf('H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'), 6)
}

/**
 * Questions 58-1: Reverse all vocabularies in an English statement
 */
private fun String.reverse(): String {
    var pointer1 = lastIndex
    var pointer2 = lastIndex
    val str = this
    return buildString {
        while (pointer2 >= 0) {
            if (str[pointer2] == ' ') {
                append(str.substring(pointer2 + 1, pointer1 + 1))
                pointer1 = pointer2
                while (str[pointer2] == ' ')
                    pointer2--
            } else if (pointer2 == 0) {
                append(str.substring(pointer2, pointer1 + 1))
                break
            } else
                pointer2--
        }
    }
}

private fun printlnResult1(str: String) =
    println("Input a str: '$str', the reverse is '${str.reverse()}'")

/**
 * Questions 58-2: Input an integer n and a CharArray, put the first nth characters behind on other characters in the CharArray
 */
private fun reverse(array: CharArray, n: Int): CharArray {
    val slash = n - 1
    var i = 0
    var j = slash
    while (i < j)
        swap(array, i++, j--)
    i = n
    j = array.lastIndex
    while (i < j)
        swap(array, i++, j--)
    i = 0
    j = array.lastIndex
    while (i < j)
        swap(array, i++, j--)
    return array
}

private fun swap(array: CharArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

private fun printlnResult2(array: CharArray, n: Int) =
    println("Rotate the first ${n}th character of ${array.toList()}, then we can get: ${reverse(array, n)}")