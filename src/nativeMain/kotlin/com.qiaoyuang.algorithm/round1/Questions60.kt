package com.qiaoyuang.algorithm.round1

fun test60() {
    printlnResult(1)
    printlnResult(2)
    printlnResult(3)
}

/**
 * Questions 60: Find the probabilities of all situations of sums of n dices
 */
private fun getProbabilityOfDices(n: Int): Map<Int, Double> {
    val map = getProbabilityOfDicesRecursion(n)
    val amount = map.values.sum()
    return map.mapValues { (_, value) ->
        value.toDouble() / amount
    }
}

private fun getProbabilityOfDicesRecursion(n: Int): HashMap<Int, Int> {
    val result = HashMap<Int, Int>(6 * n - n + 1)
    if (n == 1) {
        for (i in 1..6)
            result[i] = 1
        return result
    } else {
        val preResult = getProbabilityOfDicesRecursion(n - 1)
        for (i in 1..6)
            preResult.forEach {
                val sum = i + it.key
                result[sum] = if (result.containsKey(sum))
                    result[sum]!! + it.value
                else
                    it.value
            }
    }
    return result
}

private fun getProbabilitiesOfDicesLoop(n: Int): Map<Int, Double> {
    require(n > 0) { "The n must greater than 0" }
    var map = HashMap<Int, Int>(6)
    for (i in 1..6)
        map[i] = 1
    for (i in 2..n) {
        val newMap = HashMap<Int, Int>(6 * i - i + 1)
        for (j in 1..6) {
            map.forEach {
                val sum = j + it.key
                newMap[sum] = if (newMap.containsKey(sum))
                    newMap[sum]!! + it.value
                else
                    it.value
            }
        }
        map = newMap
    }
    val amount = map.values.sum()
    return map.mapValues { (_, value) ->
        value.toDouble() / amount
    }
}

private fun printlnResult(n: Int) {
    val result = getProbabilityOfDices(n) == getProbabilitiesOfDicesLoop(n)
    println("When we have n dices, we find the probabilities of sun of all dices is $result")
}