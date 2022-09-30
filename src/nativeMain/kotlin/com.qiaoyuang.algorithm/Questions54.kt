package com.qiaoyuang.algorithm

/**
 * 在二叉搜索树中寻找第k大的节点
 */

fun main() {
	val a = BinaryTreeNode(5)
	val b = BinaryTreeNode(3)
	val c = BinaryTreeNode(7)
	val d = BinaryTreeNode(2)
	val e = BinaryTreeNode(4)
	val f = BinaryTreeNode(6)
	val g = BinaryTreeNode(8)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.kThNode(3))
}

fun <T> BinaryTreeNode<T>.kThNode(k: Int): T {
	val list = ArrayList<T>()
	fun postorderFind(node: BinaryTreeNode<T>) {
		node.mLeft?.let { postorderFind(it) }
		list.add(node.mValue)
		node.mRight?.let { postorderFind(it) }
	}
	postorderFind(this)
	return list[list.size - k]
}