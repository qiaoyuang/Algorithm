package com.qiaoyuang.algorithm

/**
 * 给定一颗二叉树及其中一个节点，找出其中序遍历序列的下一个节点
 */

data class BinaryTreeNodeWithFather<T>(var mValues: T,
									   var mFather: BinaryTreeNodeWithFather<T>? = null,
									   var mLeft: BinaryTreeNodeWithFather<T>? = null,
									   var mRight: BinaryTreeNodeWithFather<T>? = null)

fun main() {
	val a = BinaryTreeNodeWithFather('a')
	val b = BinaryTreeNodeWithFather('b', a)
	val c = BinaryTreeNodeWithFather('c', a)
	val d = BinaryTreeNodeWithFather('d', b)
	val e = BinaryTreeNodeWithFather('e', b)
	val f = BinaryTreeNodeWithFather('f', c)
	val g = BinaryTreeNodeWithFather('g', c)
	val h = BinaryTreeNodeWithFather('h', e)
	val i = BinaryTreeNodeWithFather('i', e)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	e.mLeft = h
	e.mRight = i
	val str = "空"
	println("a:${getNext(a) ?: str}")
	println("b:${getNext(b) ?: str}")
	println("c:${getNext(c) ?: str}")
	println("d:${getNext(d) ?: str}")
	println("e:${getNext(e) ?: str}")
	println("f:${getNext(f) ?: str}")
	println("g:${getNext(g) ?: str}")
	println("h:${getNext(h) ?: str}")
	println("i:${getNext(i) ?: str}")
}

fun <T> getNext(node: BinaryTreeNodeWithFather<T>): T? {
	if (node.mRight == null) {
		if (node.mFather != null) {
			if (node.mFather!!.mLeft === node) {
				return node.mFather?.mValues
			} else {
				var nNode = node
				while (nNode.mFather!!.mFather != null) {
					if (nNode.mFather!!.mFather!!.mLeft === nNode.mFather) {
						return nNode.mFather!!.mFather!!.mValues
					}
					nNode = nNode.mFather!!
				}
				return null
			}
		} else {
			return null
		}
	} else {
		var right = node.mRight
		while (right!!.mLeft != null) {
			right = right.mLeft
		}
		return right.mValues
	}
}