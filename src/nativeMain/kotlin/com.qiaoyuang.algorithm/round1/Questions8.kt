package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNodeWithFather

fun test8() {
    val a = BinaryTreeNodeWithFather('a')
    val b = BinaryTreeNodeWithFather('b', a)
    val c = BinaryTreeNodeWithFather('c', a)
    val d = BinaryTreeNodeWithFather('d', b)
    val e = BinaryTreeNodeWithFather('e', b)
    val f = BinaryTreeNodeWithFather('f', c)
    val g = BinaryTreeNodeWithFather('g', c)
    val h = BinaryTreeNodeWithFather('h', e)
    val i = BinaryTreeNodeWithFather('i', e)
    a.left = b
    a.right = c
    b.left = d
    b.right = e
    c.left = f
    c.right = g
    e.left = h
    e.right = i
    fun printlnNext(node: BinaryTreeNodeWithFather<Char>) =
        println("The element \"${node.value}\"'s next element in in-order is ${node.findInOrderNextElement()?.toString() ?: "null"}")
    printlnNext(a)
    printlnNext(b)
    printlnNext(c)
    printlnNext(d)
    printlnNext(e)
    printlnNext(f)
    printlnNext(g)
    printlnNext(h)
    printlnNext(i)
}

/**
 * Questions 8: Give you a binary node, find the node's next node in binary's in-order.
 * The binary node has 3 points, left(point to left sub-node), right(point to right sub-node), father(point to father node)
 */
private fun BinaryTreeNodeWithFather<Char>.findInOrderNextElement(): Char? = father?.let {
    right?.findFarLeftNode() ?: when {
        it.left === this -> father!!.value
        it.right === this -> father!!.findFatherThatLeftTree()
        else -> throw IllegalArgumentException("This is a exceptional binary tree")
    }
} ?: right?.findFarLeftNode()

private fun BinaryTreeNodeWithFather<Char>.findFarLeftNode(): Char = let {
    var current = it
    while (current.left != null) {
        current = current.left!!
    }
    current.value
}

private fun BinaryTreeNodeWithFather<Char>.findFatherThatLeftTree(): Char? {
    var current: BinaryTreeNodeWithFather<Char>? = this
    while (current != null) {
        if (current === current.father?.left)
            return current.father!!.value
        current = current.father
    }
    return null
}
