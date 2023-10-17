package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

import kotlin.math.abs
import kotlin.math.max

fun test55() {
    printlnResult1(testCase1())
    printlnResult1(testCase2())
    printlnResult1(testCase3())
    printlnResult2(testCase1())
    printlnResult2(testCase2())
    printlnResult2(testCase3())
}

/**
 * Questions 55-1: Get the depth of a binary-tree
 */
private fun <T> BinaryTreeNode<T>.depth(): Int =
    1 + max(left?.depth() ?: 0, right?.depth() ?: 0)

private fun testCase1(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 1,
    left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(
            value = 5,
            right = BinaryTreeNode(value = 7),
            )
        ),
    right = BinaryTreeNode(
        value = 3,
        right = BinaryTreeNode(value = 6),
        )
    )

private fun printlnResult1(node: BinaryTreeNode<Int>) =
    println("The depth of binary tree: ${node.inOrderList()} is: ${node.depth()}")

/**
 * Questions 55-2: Judge weather a binary tree is a balance binary tree
 */
private fun <T> BinaryTreeNode<T>.isBalance(): Boolean = isBalanceRec().first

private fun <T> BinaryTreeNode<T>.isBalanceRec(): Pair<Boolean, Int> {
    val (isLeftBalance, leftDepth) = left?.isBalanceRec() ?: (true to 0)
    val (isRightBalance, rightDepth) = right?.isBalanceRec() ?: (true to 0)
    val depth = max(leftDepth, rightDepth) + 1
    return if (isLeftBalance && isRightBalance)
        (abs(leftDepth - rightDepth) <= 1) to depth
    else
        false to depth
}

private fun testCase2(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 5,
    left = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(value = 2),
        right = BinaryTreeNode(value = 4),
    ),
    right = BinaryTreeNode(
        value = 7,
        left = BinaryTreeNode(value = 6),
        right = BinaryTreeNode(value = 8),
    ),
)

private fun testCase3(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 1,
    left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(
            value = 5,
            right = BinaryTreeNode(value = 7),
        )
    ),
    right = BinaryTreeNode(
        value = 3,
        right = BinaryTreeNode(
            value = 6,
            right = BinaryTreeNode(value = 8),
            ),
    )
)

private fun printlnResult2(node: BinaryTreeNode<Int>) =
    println("Is the binary tree: ${node.inOrderList()} balance binary tree: ${node.isBalance()}")