package com.qiaoyuang.algorithm.round1

fun test29() {
    printlnResult(testCase1())
    printlnResult(testCase2())
    printlnResult(testCase3())
    printlnResult(testCase4())
    printlnResult(testCase5())
    printlnResult(testCase6())
}

/**
 * Questions29: Println the matrix by clockwise and from outside to inside
 */
private fun Array<IntArray>.printClockwise(): String {
    if (isEmpty()) return ""
    return buildString {
        var minX = 0
        var minY = 0
        var maxX = this@printClockwise.first().lastIndex
        var maxY = this@printClockwise.lastIndex
        while (minX <= maxX && minY <= maxY)
            printCycle(this, minX++, maxX--, minY++, maxY--)
    }
}

private fun Array<IntArray>.printCycle(builder: StringBuilder, minX: Int, maxX: Int, minY: Int, maxY: Int) {
    var x = minX
    var y = minY
    while (x < maxX) {
        builder.append(this[y][x])
        builder.append(' ')
        x++
    }
    while (y < maxY) {
        builder.append(this[y][x])
        builder.append(' ')
        y++
    }
    if (minX == maxX || minY == maxY) {
        builder.append(this[y][x])
        builder.append(' ')
        return
    }
    while (x > minX) {
        builder.append(this[y][x])
        builder.append(' ')
        x--
    }
    while (y > minY) {
        builder.append(this[y][x])
        builder.append(' ')
        y--
    }
}

private fun printlnResult(matrix: Array<IntArray>) {
    println("The matrix is:")
    matrix.forEach {
        it.forEach { num ->
            print("$num ")
        }
        println()
    }
    println("The clockwise print is: ${matrix.printClockwise()}")
}

private fun testCase1(): Array<IntArray> = arrayOf(
    intArrayOf(1, 2, 3, 4),
    intArrayOf(5, 6, 7, 8),
    intArrayOf(9, 10, 11, 12),
    intArrayOf(13, 14, 15, 16),
)

private fun testCase2(): Array<IntArray> = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(5, 6, 7),
    intArrayOf(9, 10, 11),
    intArrayOf(13, 14, 15),
)

private fun testCase3(): Array<IntArray> = arrayOf(
    intArrayOf(1, 2, 3, 4),
    intArrayOf(5, 6, 7, 8),
    intArrayOf(9, 10, 11, 12),
)

private fun testCase4(): Array<IntArray> = arrayOf(
    intArrayOf(1, 2, 3, 4),
)

private fun testCase5(): Array<IntArray> = arrayOf(
    intArrayOf(1),
    intArrayOf(5),
    intArrayOf(9),
    intArrayOf(13),
)

private fun testCase6(): Array<IntArray> = arrayOf(
    intArrayOf(1),
)