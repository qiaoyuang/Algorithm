package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode
import com.qiaoyuang.algorithm.round0.Stack

fun test55() {
    printlnResult(binarySearchTreeTestCase())
}

/**
 * Questions 55: BST iterator
 */
class BSTIterator<T : Comparable<T>>(root: BinaryTreeNode<T>) {

    private var pointer: BinaryTreeNode<T>? = root
    private val stack = Stack<BinaryTreeNode<T>>()

    fun next(): T {
        while (pointer != null) {
            stack.push(pointer!!)
            pointer = pointer?.left
        }
        pointer = stack.pop()
        val value = pointer!!.value
        pointer = pointer?.right
        return value
    }

    fun hasNext(): Boolean = pointer != null || stack.isNotEmpty
}

class BSTIteratorBigger<T : Comparable<T>>(root: BinaryTreeNode<T>) {

    private var pointer: BinaryTreeNode<T>? = root
    private val stack = Stack<BinaryTreeNode<T>>()

    fun next(): T {
        while (pointer != null) {
            stack.push(pointer!!)
            pointer = pointer?.right
        }
        pointer = stack.pop()
        val value = pointer!!.value
        pointer = pointer?.left
        return value
    }

    fun hasNext(): Boolean = pointer != null || stack.isNotEmpty
}

private fun printlnResult(root: BinaryTreeNode<Int>) {
    print("Print this iterator: ")
    val iterator = BSTIterator(root)
    print(iterator.next())
    while (iterator.hasNext())
        print(", ${iterator.next()}")
}