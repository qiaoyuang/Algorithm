package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Queue

fun test43() {
    printlnResult(testCase1(), 7)
    printlnResult(testCase2(), 9)
    printlnResult(testCase3(), 8)
}

/**
 * Questions 43: Inset value to a complete binary tree
 */
private class CBTInserter(val root: BinaryTreeNode<Int>) {

    infix fun insert(v: Int): BinaryTreeNode<Int> {
        val line = Queue<BinaryTreeNode<Int>>()
        line.enqueue(root)
        while (!line.isEmpty) {
            val node = line.dequeue()
            node.left?.let {
                line.enqueue(it)
            } ?: kotlin.run {
                node.left = BinaryTreeNode(v)
                return node
            }
            node.right?.let {
                line.enqueue(it)
            } ?: kotlin.run {
                if (node.left != null) {
                    node.right = BinaryTreeNode(v)
                    return node
                }
            }
        }
        throw IllegalArgumentException("The inputted binary tree seems like getting some problems")
    }
}

private fun printlnResult(root: BinaryTreeNode<Int>, v: Int) {
    println("Insert the value $v to binary tree: ${root.postOrderList()}")
    println("We can get the parent of $v is: ${CBTInserter(root).insert(v).value}")
    println("Now, the binary tree is: ${root.postOrderList()}")
    println("----------------------------------------------")
}

private fun testCase1(): BinaryTreeNode<Int> {
    val root = BinaryTreeNode(1)
    root.left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(4),
        right = BinaryTreeNode(5),
    )
    root.right = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(6),
    )
    return root
}

private fun testCase2(): BinaryTreeNode<Int> {
    val root = BinaryTreeNode(1)
    root.left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(
            value = 4,
            left = BinaryTreeNode(8)
        ),
        right = BinaryTreeNode(5),
    )
    root.right = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(6),
        right = BinaryTreeNode(7),
    )
    return root
}

private fun testCase3(): BinaryTreeNode<Int> {
    val root = BinaryTreeNode(1)
    root.left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(5),
    )
    root.right = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(6),
        right = BinaryTreeNode(7),
    )
    return root
}