package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Queue

fun test46() {
    printlnResult(BinaryTreeNode(8))
    printlnResult(binaryTreeTestCase1())
    printlnResult(binaryTreeTestCase2())
    printlnResult(binaryTreeTestCase3())
    printlnResult(binaryTreeTestCase4())
}

/**
 * Questions 46: The right view of a binary tree
 */
private fun <T> BinaryTreeNode<T>.rightView(): List<T> {
    var queue1 = Queue<BinaryTreeNode<T>>()
    var queue2 = Queue<BinaryTreeNode<T>>()
    queue1.enqueue(this)
    return buildList {
        while (queue1.isNotEmpty) {
            val node = queue1.dequeue()
            node.left?.let { queue2.enqueue(it) }
            node.right?.let { queue2.enqueue(it) }
            if (queue1.isEmpty) {
                add(node.value)
                if (queue2.isNotEmpty)
                    queue1 = queue2.also { queue2 = queue1 }
            }
        }
    }
}

fun binaryTreeTestCase4(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(
            value = 6,
            left = BinaryTreeNode(value = 5),
            right = BinaryTreeNode(value = 7),
        ),
        right = BinaryTreeNode(
            value = 10,
        )
    )

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The right view of binary tree: ${root.postOrderList()}(post order) is ${root.rightView()}")