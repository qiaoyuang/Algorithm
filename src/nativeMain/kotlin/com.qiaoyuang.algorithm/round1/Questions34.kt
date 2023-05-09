package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Stack
import com.qiaoyuang.algorithm.round0.toIntArray

fun test34() {
    val (root, target) = testCase()
    printlnResults(root, target)
    printlnResults(root, 21)
    printlnResults(root, 19)
}

/**
 * Find all the paths that sum equals a number in a binary tree
 */
private infix fun BinaryTreeNode<Int>.findAllPathsInBinaryTree(target: Int): List<IntArray> = buildList {
    findAllPathsInBinaryTree(target, 0, Stack(), this)
}

private fun BinaryTreeNode<Int>.findAllPathsInBinaryTree(target: Int, current: Int, stack: Stack<Int>, results: MutableList<IntArray>) {
    stack.push(value)
    val sum = value + current
    when {
        sum == target -> results.add(stack.toIntArray())
        sum < target -> {
            left?.findAllPathsInBinaryTree(target, sum, stack, results)
            right?.findAllPathsInBinaryTree(target, sum, stack, results)
        }
    }
    stack.pop()
}

private fun printlnResults(root: BinaryTreeNode<Int>, target: Int) {
    println("The paths that sum equals $target are: ")
    val results = root findAllPathsInBinaryTree target
    if (results.isEmpty())
        println("No path;")
    else results.forEach {
        println(it.toList())
    }
}

private fun testCase(): Pair<BinaryTreeNode<Int>, Int> = BinaryTreeNode(10,
    left = BinaryTreeNode(5,
        left = BinaryTreeNode(4),
        right = BinaryTreeNode(7)
    ),
    right = BinaryTreeNode(12),
) to 22
