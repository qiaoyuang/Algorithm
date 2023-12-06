package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Stack

fun test54() {
    printlnResult(binarySearchTreeTestCase())
}

/**
 * Questions 54: Given a binary search tree, replace values in all
 * nodes to the sum of all values that greater the value.
 */
private fun BinaryTreeNode<Int>.replaceValues(): BinaryTreeNode<Int> {
    var pointer: BinaryTreeNode<Int>? = this
    var sum = 0
    val stack = Stack<BinaryTreeNode<Int>>()
    while (pointer != null || stack.isNotEmpty) {
        while (pointer != null) {
            stack.push(pointer)
            pointer = pointer.right
        }
        pointer = stack.pop()
        sum += pointer.value
        pointer.value = sum
        pointer = pointer.left
    }
    return this
}

fun binarySearchTreeTestCase() =
    BinaryTreeNode(
        value = 4,
        left = BinaryTreeNode(
            value = 2,
            left = BinaryTreeNode(value = 1),
            right = BinaryTreeNode(value = 3),
            ),
        right = BinaryTreeNode(
            value = 6,
            left = BinaryTreeNode(value = 5),
            right = BinaryTreeNode(value = 7),
        )
    )

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("Replace the values in the binary search tree ${root.inOrderList()}(inorder), we get ${root.replaceValues().inOrderList()}(inorder)")