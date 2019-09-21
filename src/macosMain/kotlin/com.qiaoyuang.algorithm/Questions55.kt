package com.qiaoyuang.algorithm

import kotlin.math.abs
import kotlin.math.max

fun main() {
	val a = BinaryTreeNode(1)
	val b = BinaryTreeNode(2)
	val c = BinaryTreeNode(3)
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(5)
	val f = BinaryTreeNode(6)
	val g = BinaryTreeNode(7)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mRight = f
	e.mLeft = g
	println("二叉树的高度为：${a.treeDepth()}")
	println()
	println(a.isBalanced1())
	println(a.isBalanced2())
	c.mRight = null
	println()
	println(a.isBalanced1())
	println(a.isBalanced2())
}

// 题目一：二叉树的深度
fun <T> BinaryTreeNode<T>.treeDepth(): Int {
	var left = 1
	left += mLeft?.treeDepth() ?: 0
	var right = 1
	right += mRight?.treeDepth() ?: 0
	return max(right, left)
}

// 题目二：判断一棵二叉树是否是平衡二叉树
fun <T> BinaryTreeNode<T>.isBalanced1(): Boolean {
	val left = mLeft?.treeDepth() ?: 0
	val right = mRight?.treeDepth() ?: 0
	if (abs(left - right) > 1)
		return false
	return mLeft?.isBalanced1() ?: true && mRight?.isBalanced1() ?: true
}

fun <T> BinaryTreeNode<T>.isBalanced2(): Boolean = this.isBalancedCore(intArrayOf(0))

private fun <T> BinaryTreeNode<T>.isBalancedCore(depth: IntArray): Boolean {
	val left = intArrayOf(0)
	val right = intArrayOf(0)
	if (mLeft?.isBalancedCore(left) != false && mRight?.isBalancedCore(right) != false) {
		if (abs(left[0] - right[0]) <= 1) {
			depth[0] = 1 + if (left[0] > right[0])
				left[0]
			else
				right[0]
			return true
		} else 
			return false
	}
	return false
}