package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Stack

fun test27() {
    printlnResult(testCass1())
}

/**
 * Questions27: Give a binary tree root node, output the mirror image of this binary tree
 */

// Recursion
private fun <T> BinaryTreeNode<T>.getMirrorImageRecursion(): BinaryTreeNode<T> =
    BinaryTreeNode(value, right?.getMirrorImageRecursion(), left?.getMirrorImageRecursion())

// Loop
private fun <T> BinaryTreeNode<T>.getMirrorImageLoop(): BinaryTreeNode<T> {
    val nodeStack = Stack<BinaryTreeNode<T>>()
    val root = BinaryTreeNode(value, left, right)
    nodeStack.push(root)
    while (!nodeStack.isEmpty) {
        val node = nodeStack.pop()
        node.left = node.right.apply { node.right = node.left }
        node.left?.let { nodeStack.push(it) }
        node.right?.let { nodeStack.push(it) }
    }
    return root
}

private fun <T> printlnResult(node: BinaryTreeNode<T>) {
    println("The mirror image of the tree: ${node.inOrderList()}(in-order) is: ")
    println("Recursion: ${node.getMirrorImageRecursion().inOrderList()}(in-order)")
    println("Loop: ${node.getMirrorImageLoop().inOrderList()}(in-order)")
}

private fun testCass1(): BinaryTreeNode<Int> {
    val node0 = BinaryTreeNode(8)
    val node1 = BinaryTreeNode(6, BinaryTreeNode(5), BinaryTreeNode(7))
    val node2 = BinaryTreeNode(10, BinaryTreeNode(9), BinaryTreeNode(11))
    node0.left = node1
    node0.right = node2
    return node0
}