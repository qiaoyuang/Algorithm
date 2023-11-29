package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test49() {
    printlnResult(testCase())
}

/**
 * Questions 49: Get the sum of all paths that from root to seed, all nodes just contain number in 0 ~ 9
 */
private fun BinaryTreeNode<Int>.sumOfPaths(path: Int): Int {
    val current = path * 10 + value
    if (left == null && right == null)
        return current
    return (left?.sumOfPaths(current) ?: 0) + (right?.sumOfPaths(current) ?: 0)
}

private fun testCase() =
    BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(
            value = 9,
            left = BinaryTreeNode(value = 5),
            right = BinaryTreeNode(value = 1),
        ),
        right = BinaryTreeNode(
            value = 0,
            right = BinaryTreeNode(value = 2)
        )
    )

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The sum of all paths that from root to seeds in binary tree ${root.preOrderList()}(preorder) is ${root.sumOfPaths(0)}")