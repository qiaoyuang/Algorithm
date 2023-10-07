package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test7() {
    fun printlnResults(preOrder: IntArray, inOrder: IntArray) {
        val tree = rebuildBinaryTree(preOrder, inOrder)
        val preOrderList = preOrder.toList()
        val inOrderList = inOrder.toList()
        val assert = tree.preOrderList() == preOrderList && tree.inOrderList() == inOrderList
        println("The pre-order is $preOrderList, the in-order is $inOrderList, rebuild binary tree is $assert")
    }
    val preOrder0 = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val inOrder0 = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)
    printlnResults(preOrder0, inOrder0)
    printlnResults(intArrayOf(1), intArrayOf(1))
    val preOrder1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val inOrder1 = intArrayOf(8, 7, 6, 5, 4, 3, 2, 1)
    printlnResults(preOrder1, inOrder1)
    val preOrder2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val inOrder2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    printlnResults(preOrder2, inOrder2)
}

/**
 * Questions 7: Input a Binary Tree's pre-order and in-order results, please rebuild this Binary Tree.
 */

fun rebuildBinaryTree(preOrder: IntArray, inOrder: IntArray): BinaryTreeNode<Int> {
    if (preOrder.isEmpty() || inOrder.isEmpty())
        throw IllegalArgumentException("The pre-order and in-order cannot be empty IntArray")
    if (preOrder.size != inOrder.size)
        throw IllegalArgumentException("The pre-order's length must equals in-order's length")
    val rootElement = preOrder.first()
    return BinaryTreeNode(rootElement).apply {
        val inIndexOfRoot = inOrder.indexOf(rootElement)
        if (inIndexOfRoot >= 0) {
            left = rebuildBinaryTree(preOrder, 1, inIndexOfRoot, inOrder, 0, inIndexOfRoot - 1)
            right = rebuildBinaryTree(preOrder, inIndexOfRoot + 1, preOrder.lastIndex, inOrder, inIndexOfRoot + 1, inOrder.lastIndex)
        } else
            throw IllegalArgumentException("The pre-order and in-order not matching")
    }
}

private fun rebuildBinaryTree(
    preOrder: IntArray, preStart: Int, preEnd: Int,
    inOrder: IntArray, inStart: Int, inEnd: Int,
): BinaryTreeNode<Int>? {
    if (preEnd >= preOrder.size || inEnd >= inOrder.size || preStart > preEnd || inStart > inEnd || preStart < 0 || inStart < 0)
        return null
    val rootElement = preOrder[preStart]
    return BinaryTreeNode(rootElement).apply {
        val rootIndexInInOrder = inOrder.indexOf(rootElement)
        val countOfLeftNodes = rootIndexInInOrder - inStart
        left = rebuildBinaryTree(
            preOrder, preStart + 1, preStart + countOfLeftNodes,
            inOrder, inStart, rootIndexInInOrder - 1,
        )
        right = rebuildBinaryTree(
            preOrder, preStart + countOfLeftNodes + 1, preEnd,
            inOrder, rootIndexInInOrder + 1, inEnd,
        )
    }
}