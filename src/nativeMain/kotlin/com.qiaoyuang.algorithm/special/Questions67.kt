package com.qiaoyuang.algorithm.special

import kotlin.math.pow
import kotlin.math.max

fun test67() {
    printlnResult(1, 3, 4, 7)
}

/**
 * Questions 67: Find the two numbers in an IntArray(all integers equal or greater than 0) that their results of exclusive or is maximum
 */
private fun IntArray.maxXor(): Int {
    val trieTree = TrieTree()
    val binaryStringSequence = asSequence().map { it.toBinaryString() }
    binaryStringSequence.forEach { trieTree.insert(it) }

    var max = 0
    binaryStringSequence.forEachIndexed { index, num ->
        var pointer: TrieNode? = trieTree.head
        val builder = StringBuilder()
        repeat(31) {
            val bit = num[it]
            val nextNode = pointer?.next?.let { next ->
                if (next[0] != null && next[1] != null) {
                    if (next[0]?.character != bit) next[0] else next[1]
                } else {
                    next[0] ?: next[1]
                }
            }
            builder.append(nextNode?.character)
            pointer = nextNode
        }
        max = max(max, builder.toString().toInt(2) xor this[index])
    }
    return max
}

private fun Int.toBinaryString(): String {
    var number = 2.0.pow(30).toInt()
    return buildString(31) {
        while (number > 0) {
            val bit = if (this@toBinaryString and number != 0) '1' else '0'
            append(bit)
            number = number shr 1
        }
    }
}

private fun printlnResult(vararg numbers: Int) =
    println("The maximum exclusive or value in IntArray ${numbers.toList()} is ${numbers.maxXor()}")
