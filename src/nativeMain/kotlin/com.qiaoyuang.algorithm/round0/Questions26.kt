package com.qiaoyuang.algorithm.round0

/**
 * 判断一个树是否是另一个树的子树
 */

fun test26() {
	// 构造父树
	val father = BinaryTreeNode(8)
	val b = BinaryTreeNode(8)
	val c = BinaryTreeNode(7)
	val d = BinaryTreeNode(9)
	val e = BinaryTreeNode(2)
	val f = BinaryTreeNode(4)
	val g = BinaryTreeNode(7)
	father.left = b
	father.right = c
	b.left = d
	b.right = e
	e.left = f
	e.right = g
	// 构造子树
	val son = BinaryTreeNode(8)
	val h = BinaryTreeNode(9)
	val i = BinaryTreeNode(2)
	val j = BinaryTreeNode(4)
	val k = BinaryTreeNode(7)
	son.left = h
	son.right = i
	i.left = j
	i.right = k
	println(hasSubtree(father, son))
}

fun <T> hasSubtree(father: BinaryTreeNode<T>, son: BinaryTreeNode<T>): Boolean {
	// 判断一个树的及其子树是否是另一个树的父树
	fun hasSubtreeSon(father: BinaryTreeNode<T>, son: BinaryTreeNode<T>): Boolean {
		var boo = false
		if (father.value == son.value) {
			if (father.left != null && son.left != null) {
				boo = hasSubtreeSon(father.left!!, son.left!!)
			} else if (son.left == null) {
				boo = true
			}
			if (boo) {
				if (father.right != null && son.right != null) {
				    boo = hasSubtreeSon(father.right!!, son.right!!)
			    } else if (son.right == null) {
				    boo = true
			    }
			}
		}
		return boo
	}
	var boo = hasSubtreeSon(father, son)
	if (boo) {
		return boo
	} else if (father.left != null) {
		boo = hasSubtree(father.left!!, son)
	}
	if (boo) {
		return boo
	}
	if (father.right != null) {
		boo = hasSubtree(father.right!!, son)
	}
	return boo
}