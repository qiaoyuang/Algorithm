package com.qiaoyuang.algorithm.special

fun test101() {
    printlnResult(3, 4, 1)
    printlnResult(1, 2, 3, 5)
    printlnResult(1, 2, 3, 6)
    printlnResult(1, 2, 3, 8)
}

/**
 * Questions 101: Judge can we divide an IntArray to 2 parts and their sums are equal
 */
private fun IntArray.is2PartsEqual(): Boolean {
    val sum = sum()
    if (sum % 2 == 1)
        return false
    val load = sum shr 1
    val db = Array(size) { BooleanArray(load + 1) }
    db.forEach { it[0] = true }
    for (i in indices)
        for (j in 1..load)
            db[i][j] = i - 1 >= 0 && (db[i - 1][j] || (j >= this[i] && db[i - 1][j - this[i]]))
    return db.last().last()
}

private fun IntArray.is2PartsEqual2(): Boolean {
    val sum = sum()
    if (sum % 2 == 1)
        return false
    val load = sum shr 1
    val db = BooleanArray(load + 1)
    db[0] = true
    for (i in indices)
        for (j in load downTo 1)
            if (!db[j])
                db[j] = j >= this[i] && db[j - this[i]]
    return db.last()
}

private fun printlnResult(vararg nums: Int) =
    println("Is the IntArray: ${nums.toList()} could be divided 2 parts that's sums are equal: ${nums.is2PartsEqual()}, ${nums.is2PartsEqual2()}")