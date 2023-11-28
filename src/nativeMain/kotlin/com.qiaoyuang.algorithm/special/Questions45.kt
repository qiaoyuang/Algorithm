package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Queue

fun test45() {
    printlnResult(BinaryTreeNode(8))
    printlnResult(binaryTreeTestCase1())
    printlnResult(binaryTreeTestCase2())
    printlnResult(binaryTreeTestCase3())
}

/**
 * Questions 45: Find the far left value in the lowest layer in a binary tree
 */
private fun <T> BinaryTreeNode<T>.farLeftValueInLowestLayer(): T {
    var queue1 = Queue<BinaryTreeNode<T>>()
    var queue2 = Queue<BinaryTreeNode<T>>()
    queue1.enqueue(this)
    while (queue1.isNotEmpty) {
        val node = queue1.dequeue()
        node.right?.let { queue2.enqueue(it) }
        node.left?.let { queue2.enqueue(it) }
        if (queue1.isEmpty) {
            if (queue2.isEmpty)
                return node.value
            else
                queue1 = queue2.also { queue2 = queue1 }
        }
    }
    throw IllegalArgumentException("The binary tree is illegal")
}

fun binaryTreeTestCase3(): BinaryTreeNode<Int> {
    val root = BinaryTreeNode(1)
    root.left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(5),
    )
    root.right = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(
            value = 6,
            right = BinaryTreeNode(8)
            ),
        right = BinaryTreeNode(7),
    )
    return root
}

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The far left value in the lowest layer in binary tree: ${root.postOrderList()}(post order) is ${root.farLeftValueInLowestLayer()}")