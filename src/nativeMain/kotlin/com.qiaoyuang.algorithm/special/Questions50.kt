package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test50() {
    printlnResult(testCase(), 8)
}

/**
 * Questions 50: Given a binary tree and a sum number, find the count of paths that equals the sum
 */
private infix fun BinaryTreeNode<Int>.findPathCount(sum: Int): Int {
    val count = intArrayOf(0)
    findPathCount(sum, listOf(), count)
    return count.first()
}

private fun BinaryTreeNode<Int>.findPathCount(sum: Int, preValues: List<Int>, count: IntArray) {
    when {
        value == sum -> {
            count[0]++
            return
        }
        value > sum -> return
    }
    val nextPreValues = mutableListOf<Int>()

    preValues.forEach {
        val newValue = it + value
        when {
            newValue == sum -> count[0]++
            newValue < sum -> nextPreValues.add(newValue)
        }
    }
    nextPreValues.add(value)

    left?.run { findPathCount(sum, nextPreValues, count) }
    right?.run { findPathCount(sum, nextPreValues, count) }
}

private fun printlnResult(root: BinaryTreeNode<Int>, sum: Int) =
    println("The count of paths that sum equals $sum is ${root findPathCount sum} in binary tree ${root.preOrderList()}(preorder)")

private fun testCase(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 5,
        left = BinaryTreeNode(
            value = 2,
            left = BinaryTreeNode(value = 1),
            right = BinaryTreeNode(value = 6),
        ),
        right = BinaryTreeNode(
            value = 4,
            left = BinaryTreeNode(value = 3),
            right = BinaryTreeNode(value = 7),
        )
    )
