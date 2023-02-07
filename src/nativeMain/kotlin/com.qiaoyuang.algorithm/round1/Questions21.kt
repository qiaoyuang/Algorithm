package com.qiaoyuang.algorithm.round1

fun test21() {
    printlnResult(arrayOf(
        OddAndEven(0),
        OddAndEven(1),
        OddAndEven(2),
        OddAndEven(3),
        OddAndEven(4),
        OddAndEven(5),
        OddAndEven(6),
        OddAndEven(7),
        OddAndEven(8),
        OddAndEven(9),
    ))
    printlnResult(arrayOf(
        OddAndEven(0),
        OddAndEven(0),
        OddAndEven(0),
        OddAndEven(0),
        OddAndEven(0),
    ))
    printlnResult(arrayOf(
        OddAndEven(1),
        OddAndEven(1),
        OddAndEven(1),
        OddAndEven(1),
        OddAndEven(1),
    ))
}

/**
 * Questions21: Put even numbers to behind and odd number to front in a Array. This algorithm must be extendable.
 */
private fun <T : Operation<T>> Array<T>.putOddFrontEvenBehind(): Array<T> = also {
    if (isEmpty())
        return this
    var i = 0
    var j = it.lastIndex
    while (i != j && i < it.size) {
        if (it[i].optional()) {
            while (j > i && it[j].optional())
                j--
            if (j > i) {
                it[j] = it[i].also { _ -> it[i] = it[j] }
                i++
            }
        } else
            i++
    }
}

private interface Operation<T> {
    fun optional(): Boolean
}

private value class OddAndEven(val num: Int) : Operation<OddAndEven> {
    override fun optional(): Boolean = num % 2 == 0 // Is even
}

private fun <T : Operation<T>> printlnResult(array: Array<T>) =
    println("Input: ${array.toList()}, output: ${array.putOddFrontEvenBehind().toList()}")