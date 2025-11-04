package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test52() {
    printlnResult(testCase())
}

/**
 * Questions 52: Convert Binary Search Tree to Sorted Doubly Linked List, LeetCode 426
 */
private fun <T : Comparable<T>> BinaryTreeNode<T>.flat(): BinaryTreeNode<T> = flatInternal().first

private fun <T : Comparable<T>> BinaryTreeNode<T>.flatInternal(): Pair<BinaryTreeNode<T>, BinaryTreeNode<T>> {
    val leftHead = left?.flatInternal()?.let { (head, trail) ->
        left = null
        trail.right = this
        head
    } ?: this
    val rightTrail = right?.flatInternal()?.let { (head, trail) ->
        head.left = null
        right = head
        trail
    } ?: this
    return leftHead to rightTrail
}

private fun <T : Comparable<T>> BinaryTreeNode<T>.flatList() = buildList {
    var head: BinaryTreeNode<T>? = flat()
    while (head != null) {
        add(head.value)
        head = head.right
    }
}

private fun testCase() = BinaryTreeNode(
    value = 4,
    left = BinaryTreeNode(
        value = 2,
        left = BinaryTreeNode(value = 1),
        right = BinaryTreeNode(value = 3),
        ),
    right = BinaryTreeNode(
        value = 5,
        right = BinaryTreeNode(value = 6)
        ),
)

private fun printlnResult(root: BinaryTreeNode<Int>) =
    println("The binary search tree ${root.inOrderList()}(inorder), flat it we can get ${root.flatList()}")
