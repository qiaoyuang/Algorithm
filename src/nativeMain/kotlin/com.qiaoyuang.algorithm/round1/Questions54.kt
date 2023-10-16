package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test54() {
    printlnResult(testCase1(), 3)
    printlnResult(testCase1(), 1)
    printlnResult(testCase1(), 7)
    printlnResult(testCase1(), 4)
}

/**
 * Questions 54: Find the Kth smallest node in a Binary-search tree
 */
private infix fun <T : Comparable<T>> BinaryTreeNode<T>.findKNode(k: Int): BinaryTreeNode<T> =
    findKNode(k, 0).first ?: throw IllegalArgumentException("This binary-tree's size smaller than k")

private fun <T : Comparable<T>> BinaryTreeNode<T>.findKNode(k: Int, count: Int): Pair<BinaryTreeNode<T>?, Int> {
   val pair = left?.findKNode(k, count)?.also { pair ->
        val (node, _) = pair
        node?.let {
            return pair
        }
    }
    val newCount = (pair?.second ?: count) + 1
    if (k == newCount)
        return this to newCount
    return right?.findKNode(k, newCount) ?: (null to newCount)
}

private fun testCase1(): BinaryTreeNode<Int> = BinaryTreeNode(
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

private fun printlnResult(node: BinaryTreeNode<Int>, k: Int) =
    println("The ${k}th smallest node is: ${node.findKNode(k).value} in binary-search tree: ${node.inOrderList()}")