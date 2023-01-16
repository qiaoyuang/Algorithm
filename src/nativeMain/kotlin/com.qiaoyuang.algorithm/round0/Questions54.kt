package com.qiaoyuang.algorithm.round0

/**
 * 在二叉搜索树中寻找第k大的节点
 */

fun test54() {
	val a = BinaryTreeNode(5)
	val b = BinaryTreeNode(3)
	val c = BinaryTreeNode(7)
	val d = BinaryTreeNode(2)
	val e = BinaryTreeNode(4)
	val f = BinaryTreeNode(6)
	val g = BinaryTreeNode(8)
	a.left = b
	a.right = c
	b.left = d
	b.right = e
	c.left = f
	c.right = g
	println(a.kThNode(3))
}

fun <T> BinaryTreeNode<T>.kThNode(k: Int): T {
	val list = ArrayList<T>()
	fun postorderFind(node: BinaryTreeNode<T>) {
		node.left?.let { postorderFind(it) }
		list.add(node.value)
		node.right?.let { postorderFind(it) }
	}
	postorderFind(this)
	return list[list.size - k]
}