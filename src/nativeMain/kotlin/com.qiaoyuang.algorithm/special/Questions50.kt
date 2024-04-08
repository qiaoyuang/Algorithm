package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test50() {
    printlnResult(testCase(), 8)
}

/**
 * Questions 50: Given a binary tree and a sum number, find the count of paths that equals the sum
 */
private fun findPathCount(root: BinaryTreeNode<Int>, sum: Int): Int {
    val map = hashMapOf(0 to 1)
    return dfs(root, sum, map, 0)
}

private fun dfs(node: BinaryTreeNode<Int>, sum: Int, map: HashMap<Int, Int>, path: Int): Int {
    val newPath = path + node.value
    var count = map[newPath - sum] ?: 0
    map[newPath] = (map[newPath] ?: 0) + 1

    node.left?.let {
        count += dfs(it, sum, map, newPath)
    }
    node.right?.let {
        count += dfs(it, sum, map, newPath)
    }

    map[newPath] = map[newPath]!! - 1
    return count
}

private fun printlnResult(root: BinaryTreeNode<Int>, sum: Int) =
    println("The count of paths that sum equals $sum is ${findPathCount(root, sum)} in binary tree ${root.preOrderList()}(preorder)")

private fun testCase(): BinaryTreeNode<Int> =
    BinaryTreeNode(
        value = 5,
        left = BinaryTreeNode(
            value = 2,
            left = BinaryTreeNode(value = 1),
            right = BinaryTreeNode(value = 6),
        ),
        right = BinaryTreeNode(
            value = 4,
            left = BinaryTreeNode(value = 3),
            right = BinaryTreeNode(value = 7),
        )
    )
