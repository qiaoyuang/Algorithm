package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Queue

fun test32() {
    testCase1().run {
        println("Print top to bottom: ")
        printlnBinaryTreeFromTop2Bottom()
        println("Print line by line: ")
        printlnBinaryTreeFromTop2BottomByLine()
    }
}

/**
 * Questions32-1: Print a binary tree from top to bottom
 */

private fun <T> BinaryTreeNode<T>.printlnBinaryTreeFromTop2Bottom() {
    val line = Queue<BinaryTreeNode<T>>()
    line.enqueue(this)
    while (!line.isEmpty) {
        val node = line.dequeue()
        print("${node.value}, ")
        node.left?.let { line.enqueue(it) }
        node.right?.let { line.enqueue(it) }
    }
    println()
}

/**
 * Questions32-2: Print a binary tree from top to bottom by line
 */
private fun <T> BinaryTreeNode<T>.printlnBinaryTreeFromTop2BottomByLine() {
    val line = Queue<BinaryTreeNode<T>>()
    line.enqueue(this)
    var thisLineNodesCount = 1
    var nextLineNodesCount = 0
    while (!line.isEmpty) {
        if (thisLineNodesCount == 0) {
            thisLineNodesCount = nextLineNodesCount
            nextLineNodesCount = 0
        }
        val node = line.dequeue()
        print("${node.value}, ")
        if (--thisLineNodesCount == 0)
            println()
        node.left?.let {
            line.enqueue(it)
            nextLineNodesCount++
        }
        node.right?.let {
            line.enqueue(it)
            nextLineNodesCount++
        }
    }
}

private fun testCase1(): BinaryTreeNode<Int> {
    val node0 = BinaryTreeNode(0)
    val node1 = BinaryTreeNode(1, BinaryTreeNode(3), BinaryTreeNode(4,
        BinaryTreeNode(7), BinaryTreeNode(8)))
    val node2 = BinaryTreeNode(2, BinaryTreeNode(5), BinaryTreeNode(6))
    node0.left = node1
    node0.right = node2
    return node0
}
