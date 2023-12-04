package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test53() {
    printlnResult(testCase(), 6)
    printlnResult(testCase(), 9)
    printlnResult(testCase(), 11)
}

/**
 * Questions 53: The next node in a binary search tree, all values in this tree are unique
 */
private infix fun <T : Comparable<T>> BinaryTreeNode<T>.nextNode(value: T): T? {
    var pointer: BinaryTreeNode<T>? = this
    var father: BinaryTreeNode<T>? = null
    while (pointer != null) when {
        pointer.value > value -> {
            father = pointer
            pointer = pointer.left
        }
        pointer.value < value -> pointer = pointer.right
        else -> {
            pointer = pointer.right
            break
        }
    }
    return pointer?.value ?: father?.value
}

private fun testCase() = BinaryTreeNode(
    value = 8,
    left = BinaryTreeNode(
        value = 6,
        left = BinaryTreeNode(value = 5),
        right = BinaryTreeNode(value = 7),
    ),
    right = BinaryTreeNode(
        value = 10,
        left = BinaryTreeNode(value = 9),
        right = BinaryTreeNode(value = 11),
    ),
)

private fun printlnResult(root: BinaryTreeNode<Int>, value: Int) =
    println("The next $value in binary search tree ${root.inOrderList()} is ${root.nextNode(value) ?: "null"}")