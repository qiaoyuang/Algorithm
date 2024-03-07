package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test103() {
    printlnResult(intArrayOf(1, 3, 9, 10), 15)
}

/**
 * Questions 103: Given an IntArray as the coins and a value as amount,
 * please find how many coins at least we need, that equals the amount.
 */
private fun countOfCoins(coins: IntArray, amount: Int): Int {
    val max = amount + 1
    val db = Array(coins.size) { IntArray(max) { max } }
    db.forEach {
        it[0] = 0
    }
    for (i in coins.indices)
        for (j in 1..amount) {
            db[i][j] = if (i - 1 < 0) max else db[i - 1][j]
            var k = 1
            while (j >= k * coins[i])
                db[i][j] = min(db[i][j], db[i][j - k * coins[i]] + k++)
        }
    val result = db.last().last()
    return if (result == max) -1 else result
}

private fun countOfCoins2(coins: IntArray, amount: Int): Int {
    val max = amount + 1
    val db = IntArray(max) { max }
    db[0] = 0
    coins.forEach { coin ->
        for (j in amount downTo 1) {
            var k = 1
            while (j >= k * coin)
                db[j] = min(db[j], db[j - k * coin] + k++)
        }
    }
    return if (db.last() == max) -1 else db.last()
}

private fun countOfCoins3(coins: IntArray, amount: Int): Int {
    val max = amount + 1
    val db = IntArray(max)
    for (i in 1..amount) {
        db[i] = max
        coins.forEach { coin ->
            if (i >= coin)
                db[i] = min(db[i], db[i - coin] + 1)
        }
    }
    return if (db.last() == max) -1 else db.last()
}

private fun printlnResult(coins: IntArray, amount: Int) =
    println("We need at least (${countOfCoins(coins, amount)}, ${countOfCoins2(coins, amount)}, ${countOfCoins3(coins, amount)}) coins could make enough $amount")