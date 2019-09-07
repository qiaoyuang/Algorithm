package com.qiaoyuang.algorithm

/**
 * 判断一个后序遍历序列是否是排序二叉树
 */

fun main() {
	val a = intArrayOf(5, 7, 6, 8, 11, 10, 8)
	println(verifyOfBST(a))
}

fun verifyOfBST(args: IntArray): Boolean {
	var small = 0
	var big = 0
	var boo = true
	var mark = true
	args.forEach {
		if (it < args[args.size - 1]) {
			if (!mark) return false
			small++
		} else if (it > args[args.size - 1]) {
			if (mark) mark = false
			big++
		}
	}
	if (small != 0) {
		val left = IntArray(small)
		for (i in 1..small) {
			left[i-1] = args[i-1]
		}
		boo = verifyOfBST(left)
	}
	if (!boo) return false
	if (big != 0) {
		val right = IntArray(big)
		for (i in small until small + big) {
			right[i - small] = args[i]
		}
		boo = verifyOfBST(right)
	}
	return boo
}