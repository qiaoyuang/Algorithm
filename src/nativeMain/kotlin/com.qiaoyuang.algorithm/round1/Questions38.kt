package com.qiaoyuang.algorithm.round1

fun test38() {
    printResult1("abc")
    printResult1("abcd")

    printlnResult2(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0))
    printlnResult2(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8))
    printlnResult2(intArrayOf(0, 9, 9, 9, 9, 9, 9, 9))
}

/**
 * Questions 38-1: Output the all arrangements of a String
 */

private fun String.printAllArrangements() {
    toCharArray().printAllArrangements(0)
    println()
}

@OptIn(ExperimentalStdlibApi::class)
private fun CharArray.printAllArrangements(begin: Int) {
    if (begin == size) {
        print("${concatToString()} ")
        return
    }
    for (index in begin ..< size) {
        replaceTwoChar(begin, index)
        printAllArrangements(begin + 1)
        replaceTwoChar(begin, index)
    }
}

private fun CharArray.replaceTwoChar(firstIndex: Int, secondIndex: Int) {
    this[firstIndex] = this[secondIndex].also {
        this[secondIndex] = this[firstIndex]
    }
}

private fun printResult1(str: String) {
    println( "The all arrangements of String \"$str\" are:")
    str.printAllArrangements()
    println()
}

/**
 * Questions 38-2: Put 8 numbers onto
 */
private fun IntArray.isEqualsOnCube(): Boolean {
    require(size == 8) { "The size of IntArray must equals to 8" }
    return isEqualsOnCube(0)
}

@OptIn(ExperimentalStdlibApi::class)
private fun IntArray.isEqualsOnCube(begin: Int): Boolean {
    if (begin == size)
        return isEquals()
    for (index in begin ..< size) {
        replaceTwoInt(begin, index)
        if (isEqualsOnCube(begin + 1))
            return true
        replaceTwoInt(begin, index)
    }
    return false
}

private fun IntArray.replaceTwoInt(firstIndex: Int, secondIndex: Int): IntArray {
    this[firstIndex] = this[secondIndex].also {
        this[secondIndex] = this[firstIndex]
    }
    return this
}

private fun IntArray.isEquals(): Boolean =
   this[0] + this[1] + this[2] + this[3] == this[4] + this[5] + this[6] + this[7]
           && this[0] + this[2] + this[4] + this[6] == this[1] + this[3] + this[5] + this[7]
           && this[0] + this[1] + this[4] + this[5] == this[2] + this[3] + this[6] + this[7]

private fun printlnResult2(array: IntArray) {
    println("If the integer array is ${array.toStringWithSpace()}")
    println("if the number in it could be put to eight points on a cube and make the sums of any 4 points of two surfaces equals: ${array.isEqualsOnCube()}")
}

fun IntArray.toStringWithSpace() = buildString {
    this@toStringWithSpace.forEach {
        append("$it ")
    }
}

/**
 * Questions 38-3: N Queens Questions:
 */

fun nQueens(n: Int): Int {

}