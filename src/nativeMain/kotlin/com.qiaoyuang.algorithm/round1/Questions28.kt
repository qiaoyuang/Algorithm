package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test28() {
    printlnResult(testCase1())
    printlnResult(testCase2())
    printlnResult(testCase3())
    printlnResult(testCase4())
}

private fun <T> printlnResult(tree: BinaryTreeNode<T>) =
    println("Whether the tree: ${tree.inOrderString()}(in-order) is symmetry: ${tree.isSymmetry()}")

private fun <T> BinaryTreeNode<T>.isSymmetry(): Boolean =
    inOrderString() == reverseInOrderString()

private fun <T> BinaryTreeNode<T>.inOrderString(): String {
    val builder = StringBuilder()
    inOrderString(builder)
    return builder.toString()
}

private fun <T> BinaryTreeNode<T>.inOrderString(builder: StringBuilder) {
    left?.inOrderString(builder)
    builder.append(value)
    right?.inOrderString(builder)
}

private fun <T> BinaryTreeNode<T>.reverseInOrderString(): String {
    val builder = StringBuilder()
    reverseInOrderString(builder)
    return builder.toString()
}

private fun <T> BinaryTreeNode<T>.reverseInOrderString(builder: StringBuilder) {
    right?.reverseInOrderString(builder)
    builder.append(value)
    left?.reverseInOrderString(builder)
}

private fun testCase1(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(6, BinaryTreeNode(5), BinaryTreeNode(7)),
        right = BinaryTreeNode(6, BinaryTreeNode(7), BinaryTreeNode(5)),
    )

private fun testCase2(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(6, left = BinaryTreeNode(5)),
        right = BinaryTreeNode(6, right = BinaryTreeNode(5)),
    )

private fun testCase3(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(6, left = BinaryTreeNode(5)),
        right = BinaryTreeNode(6, left = BinaryTreeNode(5)),
    )

private fun testCase4(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(6, right = BinaryTreeNode(5)),
        right = BinaryTreeNode(6, right = BinaryTreeNode(5)),
    )