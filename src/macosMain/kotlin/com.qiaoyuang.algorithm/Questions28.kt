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
	if (preorderJudgment()) {
	    if (preorderBack() == _preorderBack()) {
		    return true
	    }
	}
	return false
}

fun <T> BinaryTreeNode<T>.preorderJudgment(): Boolean {
	var boo = judgment()
	if (boo) {
	    mLeft?.let { boo = it.preorderJudgment() }
		mRight?.let { boo = it.preorderJudgment() }
	}
	return boo
}

private fun <T> BinaryTreeNode<T>.judgment() = (mLeft == null && mRight == null) || (mLeft != null && mRight != null)

fun <T> BinaryTreeNode<T>.preorderBack(): String {
	var str = mValue.toString()
	str += mLeft?.preorderBack()
	str += mRight?.preorderBack()
	return str
}

fun <T> BinaryTreeNode<T>._preorderBack(): String {
	var str = mValue.toString()
	str += mRight?._preorderBack()
	str += mLeft?._preorderBack()
	return str
}