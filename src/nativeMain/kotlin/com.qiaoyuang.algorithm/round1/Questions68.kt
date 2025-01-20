package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test68() {
    printlnResult('F', 'I')
    printlnResult('H', 'I')
    printlnResult('B', 'C')
    printlnResult('H', 'I')
    printlnResult('F', 'G')
    printlnResult('D', 'E')
    printlnResult('D', 'I')
    printlnResult('F', 'E')
}

/**
 * Questions 68: LeetCode: 235, 236, 1644 1650
 */
private fun <T> findLowestParent(root: BinaryTreeNode<T>, node1: T, node2: T): BinaryTreeNode<T>? =
    root.findLowestParent(node1, node2).second

private fun <T> BinaryTreeNode<T>.findLowestParent(node1: T, node2: T): Pair<Boolean, BinaryTreeNode<T>?> {
    if (value == node1 || value == node2)
        return true to null
    val leftFound = left?.findLowestParent(node1, node2)
    val rightFound = right?.findLowestParent(node1, node2)
    return when {
        leftFound?.second != null -> true to leftFound.second
        rightFound?.second != null -> true to rightFound.second
        leftFound?.first == true && rightFound?.first == true -> true to this
        else -> (leftFound?.first == true || rightFound?.first == true) to null
    }
}

private fun buildBinaryTreeTest(): BinaryTreeNode<Char> =
    BinaryTreeNode(
        value = 'A',
        left = BinaryTreeNode(
            value = 'B',
            left = BinaryTreeNode(
                value = 'D',
                left = BinaryTreeNode(value = 'F'),
                right = BinaryTreeNode(value = 'G'),
            ),
            right = BinaryTreeNode(
                value = 'E',
                left = BinaryTreeNode('H'),
                right = BinaryTreeNode('I'),
            ),
        ),
        right = BinaryTreeNode(value ='C'))

private fun printlnResult(c1: Char, c2: Char) =
    println("The lowest parent of node $c1 and $c2 is ${findLowestParent(buildBinaryTreeTest(), c1, c2)?.value}")