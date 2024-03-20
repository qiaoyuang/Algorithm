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
private fun kthSmallest(root: BinaryTreeNode<Int>, k: Int): Int = kth(root, k, 0).first!!.value

private fun kth(node: BinaryTreeNode<Int>, k: Int, c: Int): Pair<BinaryTreeNode<Int>?, Int> {
    val (ln, lc) = node.left?.let { kth(it, k, c) } ?: (null to c)
    if (ln != null)
        return ln to lc
    val count = lc + 1
    if (count == k)
        return node to k
    val (rn, rc) = node.right?.let { kth(it, k, count) } ?: (null to count)
    return rn to rc
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
    println("The ${k}th smallest node is: ${kthSmallest(node, k)} in binary-search tree: ${node.inOrderList()}")