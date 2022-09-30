package com.qiaoyuang.algorithm

/**
 * 输入一个二叉树的根结点，并将它转化为原二叉树的镜像
 */

fun main() {
	val a = BinaryTreeNode(8)
	val b = BinaryTreeNode(6)
	val c = BinaryTreeNode(10)
	val d = BinaryTreeNode(5)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(9)
	val g = BinaryTreeNode(11)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	a.inOrder()
	println("/***************分割线***************/")
	a.mirrorRecursively()
	a.inOrder()
}

fun <T> BinaryTreeNode<T>.mirrorRecursively() {
	val temp = mLeft
	mLeft = mRight
	mRight = temp
	mLeft?.mirrorRecursively()
	mRight?.mirrorRecursively()
}