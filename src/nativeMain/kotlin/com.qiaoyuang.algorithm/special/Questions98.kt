package com.qiaoyuang.algorithm.special

fun test98() {
    printlnResult(1, 1)
    printlnResult(1, 2)
    printlnResult(2, 2)
    printlnResult(3, 2)
    printlnResult(3, 3)
    printlnResult(4, 4)
}

/**
 * Questions 98: The count of paths that a robot from top-left to bottom-right in matrix
 */
private fun countOfPaths(m: Int, n: Int): Int {
    require(m > 0 && n > 0) { "The m and n must greater than 0" }
    val db = Array(m) { i ->
        IntArray(n) { j ->
            if (i == 0 || j == 0) 1 else 0
        }
    }
    for (i in 1 ..< m)
        for (j in 1 ..< n)
            db[i][j] = db[i - 1][j] + db[i][j - 1]
    return db.last().last()
}

private fun countOfPaths2(m: Int, n: Int): Int {
    require(m > 0 && n > 0) { "The m and n must greater than 0" }
    if (m < n)
        return countOfPaths2(n, m)
    val db = IntArray(n)
    db[0] = 1
    for (i in 0 ..< m)
        for (j in 1 ..< n)
            db[j] += db[j - 1]
    return db.last()
}

private fun printlnResult(m: Int, n: Int) =
    println("The count of paths that a robot could from top-left to bottom-right in a $m * $n matrix is ${countOfPaths(m, n)}, ${countOfPaths2(m, n)}")