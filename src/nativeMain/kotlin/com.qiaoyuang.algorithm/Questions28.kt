package com.qiaoyuang.algorithm

fun main() {
	val a = BinaryTreeNode(8)
	val b = BinaryTreeNode(6)
	val c = BinaryTreeNode(6)
	val d = BinaryTreeNode(5)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(7)
	val g = BinaryTreeNode(5)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.isSymmetrical())
	c.mValue = 9
	println(a.isSymmetrical())
	val h = BinaryTreeNode(7)
	val i = BinaryTreeNode(7)
	val j = BinaryTreeNode(7)
	val k = BinaryTreeNode(7)
	val l = BinaryTreeNode(7)
	val m = BinaryTreeNode(7)
	h.mLeft = i
	h.mRight = j
	i.mLeft = k
	i.mRight = l
	j.mLeft = m
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
	    mLeft?.let { boo = it.preOrderJudgment() }
		mRight?.let { boo = it.preOrderJudgment() }
	}
	return boo
}

private fun <T> BinaryTreeNode<T>.judgment() = (mLeft == null && mRight == null) || (mLeft != null && mRight != null)

fun <T> BinaryTreeNode<T>.preOrderBack(): String {
	var str = mValue.toString()
	str += mLeft?.preOrderBack()
	str += mRight?.preOrderBack()
	return str
}

fun <T> BinaryTreeNode<T>._preOrderBack(): String {
	var str = mValue.toString()
	str += mRight?._preOrderBack()
	str += mLeft?._preOrderBack()
	return str
}