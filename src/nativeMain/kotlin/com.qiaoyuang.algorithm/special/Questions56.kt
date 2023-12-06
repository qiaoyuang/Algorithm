package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test56() {
    val testTree1 = binarySearchTreeTestCase()
    printlnResult(testTree1, 13)
    printlnResult(testTree1, 8)
    val testTree2 = binarySearchTreeTestCase2()
    printlnResult(testTree2, 12)
    printlnResult(testTree2, 22)
}

/**
 * Questions 56: Judge if two nodes that the sum of twos equals k in a binary search tree
 */
private infix fun BinaryTreeNode<Int>.isSumEquals(k: Int): Boolean {
    var pointer = this
    while (k < pointer.value)
         pointer.left?.let {
             pointer = it
         } ?: kotlin.run {
             return false
         }
    val startIterator = BSTIterator(pointer)
    var start = startIterator.next()
    val endIterator = BSTIteratorBigger(pointer)
    var end = endIterator.next()
    while (start < end) {
        val sum = start + end
        when {
            sum > k -> {
                if (endIterator.hasNext())
                    end = endIterator.next()
                else
                    return false
            }
            sum < k -> {
                if (startIterator.hasNext())
                    start = startIterator.next()
                else
                    return false
            }
            else -> return true
        }
    }
    return false
}

fun binarySearchTreeTestCase2() =
    BinaryTreeNode(
        value = 8,
        left = BinaryTreeNode(
            value = 6,
            left = BinaryTreeNode(value = 5),
            right = BinaryTreeNode(value = 7),
        ),
        right = BinaryTreeNode(
            value = 10,
            left = BinaryTreeNode(value = 9),
            right = BinaryTreeNode(value = 11),
        )
    )

private fun printlnResult(root: BinaryTreeNode<Int>, k: Int) =
    println("The binary search tree ${root.inOrderList()}(inorder), are there two nodes that the sum of them equals $k: ${root isSumEquals k}")