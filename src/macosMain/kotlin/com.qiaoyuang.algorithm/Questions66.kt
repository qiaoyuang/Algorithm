package com.qiaoyuang.algorithm

/**
 * 构建乘积数组，不能用除法
 */

fun main() {
	val a = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
	multiply(a).forEach { print("$it ") }
}

fun multiply(a: IntArray): IntArray {
	val c = IntArray(a.size) {
		var value = 1
		for (i in 0 until it)
			value *= a[i]
		value
	}
	val d = IntArray(a.size) {
		var value = 1
		for (i in it + 1 until a.size)
			value *= a[i]
		value
	}
	return IntArray(a.size) { c[it] * d[it] }
}