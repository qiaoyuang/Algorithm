package com.qiaoyuang.algorithm

/**
 * 判断一个树是否是另一个树的子树
 */

fun main() {
	// 构造父树
	val father = BinaryTreeNode(8)
	val b = BinaryTreeNode(8)
	val c = BinaryTreeNode(7)
	val d = BinaryTreeNode(9)
	val e = BinaryTreeNode(2)
	val f = BinaryTreeNode(4)
	val g = BinaryTreeNode(7)
	father.mLeft = b
	father.mRight = c
	b.mLeft = d
	b.mRight = e
	e.mLeft = f
	e.mRight = g
	// 构造子树
	val son = BinaryTreeNode(8)
	val h = BinaryTreeNode(9)
	val i = BinaryTreeNode(2)
	val j = BinaryTreeNode(4)
	val k = BinaryTreeNode(7)
	son.mLeft = h
	son.mRight = i
	i.mLeft = j
	i.mRight = k
	println(hasSubtree(father, son))
}

fun <T> hasSubtree(father: BinaryTreeNode<T>, son: BinaryTreeNode<T>): Boolean {
	// 判断一个树的及其子树是否是另一个树的父树
	fun hasSubtreeSon(father: BinaryTreeNode<T>, son: BinaryTreeNode<T>): Boolean {
		var boo = false
		if (father.mValue == son.mValue) {
			if (father.mLeft != null && son.mLeft != null) {
				boo = hasSubtreeSon(father.mLeft!!, son.mLeft!!)
			} else if (son.mLeft == null) {
				boo = true
			}
			if (boo) {
				if (father.mRight != null && son.mRight != null) {
				    boo = hasSubtreeSon(father.mRight!!, son.mRight!!)
			    } else if (son.mRight == null) {
				    boo = true
			    }
			}
		}
		return boo
	}
	var boo = hasSubtreeSon(father, son)
	if (boo) {
		return boo
	} else if (father.mLeft != null) {
		boo = hasSubtree(father.mLeft!!, son)
	}
	if (boo) {
		return boo
	}
	if (father.mRight != null) {
		boo = hasSubtree(father.mRight!!, son)
	}
	return boo
}