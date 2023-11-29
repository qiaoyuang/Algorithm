package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test47() {
    printlnResult(testCase1())
    printlnResult(testCase2())
}

/**
 * Questions 47: A binary tree only contains 0 or 1 in its nodes, cut all subtrees that only contains 0
 */
private fun BinaryTreeNode<Int>.cutSubtree(): BinaryTreeNode<Int>? =
    if (cutSubtreeByPreorder()) null else this

private fun BinaryTreeNode<Int>.cutSubtreeByPreorder(): Boolean = when (value) {
    0 -> {
        val leftResult = left?.cutSubtreeByPreorder()
        val rightResult = right?.cutSubtreeByPreorder()
        if (leftResult == true && rightResult == false)
            left = null
        if (rightResult == true && leftResult == false)
            right = null
        leftResult ?: true && rightResult ?: true
    }
    1 -> {
        if (left?.cutSubtreeByPreorder() == true)
            left = null
        if (right?.cutSubtreeByPreorder() == true)
            right = null
        false
    }
    else -> throw IllegalArgumentException("The binary tree can't contain other number except 0 or 1")
}

private fun testCase1() =
    BinaryTreeNode(
        value = 0,
        left = BinaryTreeNode(value = 0),
        right = BinaryTreeNode(value = 0),
    )

private fun testCase2() =
    BinaryTreeNode(
        value = 1,
        left = BinaryTreeNode(
            value = 0,
            left = BinaryTreeNode(value = 0),
            right = BinaryTreeNode(value = 0),
            ),
        right = BinaryTreeNode(
            value = 0,
            left = BinaryTreeNode(value = 0),
            right = BinaryTreeNode(value = 1),
            ),
    )

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("We cut the binary tree ${root.preOrderList()}, we can get ${root.cutSubtree()?.preOrderList() ?: listOf()}")