package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import kotlin.math.max

fun test51() {
    printlnResult(testCase())
}

/**
 * Questions 51: Find the maximum sum of paths
 */
private fun BinaryTreeNode<Int>.maxSum(): Int {
    val max = intArrayOf(Int.MIN_VALUE)
    maxSum(max)
    return max.first()
}

private infix fun BinaryTreeNode<Int>.maxSum(maxSum: IntArray): Int {
    val maxSumLeft = intArrayOf(Int.MIN_VALUE)
    val leftValue = left?.let {
        max(0, it.maxSum(maxSumLeft))
    } ?: 0
    val maxSumRight = intArrayOf(Int.MIN_VALUE)
    val rightValue = right?.let {
        max(0, it.maxSum(maxSumRight))
    } ?: 0

    maxSum[0] = max(maxSumLeft.first(), maxSumRight.first())
    maxSum[0] = max(maxSum.first(), value + leftValue + rightValue)

    return value + max(leftValue, rightValue)
}

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The maximum sum of paths in binary tree ${root.preOrderList()}(preorder) is ${root.maxSum()}")

private fun testCase() =
    BinaryTreeNode(
        value = -9,
        left = BinaryTreeNode(
            value = 4,
        ),
        right = BinaryTreeNode(
            value = 20,
            left = BinaryTreeNode(
                value = 15,
                left = BinaryTreeNode(value = -3)
            ),
            right = BinaryTreeNode(
                value = 7,
            )
        )
    )