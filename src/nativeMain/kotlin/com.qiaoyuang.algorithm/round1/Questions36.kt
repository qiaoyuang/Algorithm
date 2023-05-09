package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test36() {
    printlnResult(testCase1())
    printlnResult(testCase2())
    printlnResult(testCase3())
    printlnResult(testCase4())
    printlnResult(testCase5())
    printlnResult(testCase6())
    printlnResult(testCase7())
    printlnResult(testCase8())
    printlnResult(testCase9())
}

/**
 * Questions 36: Converting a binary search tree to a double directions linked list in order
 */
private fun <T> BinaryTreeNode<T>.convertToLinkedList(): Pair<BinaryTreeNode<T>, BinaryTreeNode<T>> {
    val leftPair = left?.convertToLinkedList()
    val rightPair = right?.convertToLinkedList()
    leftPair?.second?.let {
        it.right = this
        left = it
    }
    rightPair?.first?.let {
        it.left = this
        right = it
    }
    return (leftPair?.first ?: this) to (rightPair?.second ?: this)
}

private fun printlnResult(root: BinaryTreeNode<Int>) {
    var pointer = root.convertToLinkedList().first
    println("The converted linked list form small to large:")
    while (pointer.right != null) {
        print("${pointer.value}, ")
        pointer = pointer.right!!
    }
    println(pointer.value)
    println("The converted linked list form small to large:")
    while (pointer.left != null) {
        print("${pointer.value}, ")
        pointer = pointer.left!!
    }
    println(pointer.value)
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~")
}
private fun testCase1(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase2(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4, left = BinaryTreeNode(value = 3)),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase3(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4, right = BinaryTreeNode(value = 5)),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase4(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8, left = BinaryTreeNode(value = 7)),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase5(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8, right = BinaryTreeNode(value = 9)),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase6(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12, left = BinaryTreeNode(value = 11)),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase7(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12, right = BinaryTreeNode(value = 13)),
        right = BinaryTreeNode(value = 18),
    )
)

private fun testCase8(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18, left = BinaryTreeNode(value = 17)),
    )
)

private fun testCase9(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 10,
    left = BinaryTreeNode(value = 6,
        left = BinaryTreeNode(value = 4),
        right = BinaryTreeNode(value = 8),
    ),
    right = BinaryTreeNode(14,
        left = BinaryTreeNode(value = 12),
        right = BinaryTreeNode(value = 18, right = BinaryTreeNode(value = 19)),
    )
)