package com.qiaoyuang.algorithm.special

fun test94() {
    printlnResult("aaba")
    printlnResult("abcde")
    printlnResult("abaaba")
    printlnResult("abacbcde")
}

/**
 * Questions 94: The least times that split a string to palindrome strings
 */
private fun String.leastSplit(): Int {
    val isPal = Array(length) { i -> BooleanArray(i + 1) }
    for (i in indices)
        for (j in 0..i)
            if (this[i] == this[j] && (i <= j + 1 || isPal[i - 1][j + 1]))
                isPal[i][j] = true
    val db = IntArray(length) { -1 }
    repeat(length) { i ->
        if (isPal[i][0])
            db[i] = 0
        else
            for (j in 1..i)
                if (isPal[i][j] && (db[i] == -1 || db[j - 1] + 1 < db[i]))
                    db[i] = db[j - 1] + 1
    }
    return db.last()
}

private fun printlnResult(string: String) =
    println("The least times that split $string to palindrome strings is ${string.leastSplit()}")