package com.qiaoyuang.algorithm.round0

/**
 * 将一颗二叉排序树转换成一个排序的双向链表,并返回较小一端的端点
 */

fun test36() {
	// 构造一个四层的排序二叉树
	val a = BinaryTreeNode(10)
	
	val b = BinaryTreeNode(6)
	val c = BinaryTreeNode(14)
	
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(8)
	val f = BinaryTreeNode(12)
	val g = BinaryTreeNode(16)
	
	val h = BinaryTreeNode(3)
	val i = BinaryTreeNode(5)
	val j = BinaryTreeNode(7)
	val k = BinaryTreeNode(9)
	val l = BinaryTreeNode(11)
	val m = BinaryTreeNode(13)
	val n = BinaryTreeNode(15)
	val o = BinaryTreeNode(17)
	
	a.left = b
	a.right = c
	b.left = d
	b.right = e
	c.left = f
	c.right = g
	d.left = h
	d.right = i
	e.left = j
	e.right = k
	f.left = l
	f.right = m
	g.left = n
	g.right = o
	
	var x = a.convert()
	while (x.right != null) {
		print("${x.value} ")
		x = x.right!!
	}
	print("${x.value} ")
	println()
	while (x.left != null) {
		print("${x.value} ")
		x = x.left!!
	}
	print("${x.value} ")
}

fun <T> BinaryTreeNode<T>.convert(): BinaryTreeNode<T> {
	fun BinaryTreeNode<T>.traverse(isBig: Boolean, father: BinaryTreeNode<T>? = null): BinaryTreeNode<T> {
		if (left == null && right == null) {
			if (isBig) {
				left = father
			} else {
				right = father
			}
			return this
		}
		left?.let {
			left = it.traverse(false, this)
			left!!.right = this
		}
		right?.let {
			right = it.traverse(true, this)
			right!!.left = this
		}
		if (isBig) {
			if (left != null) {
				var node = left
				while (node!!.left != null) {
					node = node.left
				}
				return node
			}
			return this
		} else {
			if (right != null) {
				var node = right
				while (node!!.right != null) {
					node = node.right
				}
				return node
			}
			return this
		}
	}
	left?.let {
		left = it.traverse(false, this)
		left!!.right = this
	}
	right?.let {
		right = it.traverse(true, this)
		right!!.left = this
	}
	var head = this
	while (head.left != null) {
		head = head.left!!
	}
	return head
}