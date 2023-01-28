package com.qiaoyuang.algorithm.round0

/**
 * 给定一颗二叉树及其中一个节点，找出其中序遍历序列的下一个节点
 */

data class BinaryTreeNodeWithFather<T>(
    var value: T,
    var father: BinaryTreeNodeWithFather<T>? = null,
    var left: BinaryTreeNodeWithFather<T>? = null,
    var right: BinaryTreeNodeWithFather<T>? = null,
)

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
	if (node.right == null) {
		if (node.father != null) {
			if (node.father!!.left === node) {
				return node.father?.value
			} else {
				var nNode = node
				while (nNode.father!!.father != null) {
					if (nNode.father!!.father!!.left === nNode.father) {
						return nNode.father!!.father!!.value
					}
					nNode = nNode.father!!
				}
				return null
			}
		} else {
			return null
		}
	} else {
		var right = node.right
		while (right!!.left != null) {
			right = right.left
		}
		return right.value
	}
}