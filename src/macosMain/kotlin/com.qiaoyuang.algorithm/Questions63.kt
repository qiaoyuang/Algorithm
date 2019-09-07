package com.qiaoyuang.algorithm

/**
 * 股票的最大利润，即数组中找到最大数和最小数的差
 */

fun main() {
	val array = intArrayOf(9, 11, 8, 5, 7, 12, 16, 14)
	println(maxDiff(array))
}

fun maxDiff(array: IntArray): Int {
	var min = array[0]
	var max = array[0]
	array.forEach {
		if (it < min) min = it
		if (it > max) max = it
	}
	return max - min
}