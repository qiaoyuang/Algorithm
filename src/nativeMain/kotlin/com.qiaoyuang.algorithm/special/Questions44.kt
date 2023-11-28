package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Queue

fun test44() {
    printlnResult(binaryTreeTestCase1())
    printlnResult(binaryTreeTestCase2())
}

/**
 * Questions 44: Find the biggest values every line in a binary tree
 */
private fun <T : Comparable<T>> BinaryTreeNode<T>.maxValues(): List<T> {
    var queue1 = Queue<BinaryTreeNode<T>>()
    var queue2 = Queue<BinaryTreeNode<T>>()
    val result = ArrayList<T>()
    queue1.enqueue(this)
    var currentLineMaxValue = value
    while (queue1.isNotEmpty) {
        val node = queue1.dequeue()
        node.left?.let { queue2.enqueue(it) }
        node.right?.let { queue2.enqueue(it) }
        if (node.value > currentLineMaxValue)
            currentLineMaxValue = node.value
        if (queue1.isEmpty) {
            result.add(currentLineMaxValue)
            if (queue2.isNotEmpty) {
                queue1 = queue2.also { queue2 = queue1 }
                currentLineMaxValue = queue1.last.value
            }
        }
    }
    return result
}

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The maximum values line by line in binary tree: ${root.postOrderList()}(post order) is ${root.maxValues()}")

fun binaryTreeTestCase1() = BinaryTreeNode(
    value = 3,
    left = BinaryTreeNode(
        value = 4,
        left = BinaryTreeNode(value = 5),
        right = BinaryTreeNode(value = 1),
    ),
    right = BinaryTreeNode(
        value = 2,
        right = BinaryTreeNode(value = 9))
)