package com.qiaoyuang.algorithm.round0

/**
 * 输入一个二叉树的根结点，并将它转化为原二叉树的镜像
 */

fun test27() {
	val a = BinaryTreeNode(8)
	val b = BinaryTreeNode(6)
	val c = BinaryTreeNode(10)
	val d = BinaryTreeNode(5)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(9)
	val g = BinaryTreeNode(11)
	a.left = b
	a.right = c
	b.left = d
	b.right = e
	c.left = f
	c.right = g
	a.inOrder()
	println("/***************分割线***************/")
	a.mirrorRecursively()
	a.inOrder()
}

fun <T> BinaryTreeNode<T>.mirrorRecursively() {
	val temp = left
	left = right
	right = temp
	left?.mirrorRecursively()
	right?.mirrorRecursively()
}