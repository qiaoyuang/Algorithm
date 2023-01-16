package com.qiaoyuang.algorithm.round0

fun test28() {
	val a = BinaryTreeNode(8)
	val b = BinaryTreeNode(6)
	val c = BinaryTreeNode(6)
	val d = BinaryTreeNode(5)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(7)
	val g = BinaryTreeNode(5)
	a.left = b
	a.right = c
	b.left = d
	b.right = e
	c.left = f
	c.right = g
	println(a.isSymmetrical())
	c.value = 9
	println(a.isSymmetrical())
	val h = BinaryTreeNode(7)
	val i = BinaryTreeNode(7)
	val j = BinaryTreeNode(7)
	val k = BinaryTreeNode(7)
	val l = BinaryTreeNode(7)
	val m = BinaryTreeNode(7)
	h.left = i
	h.right = j
	i.left = k
	i.right = l
	j.left = m
	println(h.isSymmetrical())
}

fun <T> BinaryTreeNode<T>.isSymmetrical(): Boolean {
	if (preOrderJudgment()) {
	    if (preOrderBack() == _preOrderBack()) {
		    return true
	    }
	}
	return false
}

fun <T> BinaryTreeNode<T>.preOrderJudgment(): Boolean {
	var boo = judgment()
	if (boo) {
	    left?.let { boo = it.preOrderJudgment() }
		right?.let { boo = it.preOrderJudgment() }
	}
	return boo
}

private fun <T> BinaryTreeNode<T>.judgment() = (left == null && right == null) || (left != null && right != null)

fun <T> BinaryTreeNode<T>.preOrderBack(): String {
	var str = value.toString()
	str += left?.preOrderBack()
	str += right?.preOrderBack()
	return str
}

fun <T> BinaryTreeNode<T>._preOrderBack(): String {
	var str = value.toString()
	str += right?._preOrderBack()
	str += left?._preOrderBack()
	return str
}