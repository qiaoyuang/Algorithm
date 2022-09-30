package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 礼物的最大价值
 */

fun main() {
	val matrix = arrayOf(
			intArrayOf(1, 10, 3, 8),
			intArrayOf(12, 2, 9, 6),
			intArrayOf(5, 7, 4, 11),
			intArrayOf(3, 7, 16, 5))
	println("礼物的最大值是：${getMaxValue(matrix)}")
}

// 基于循环的动态规划，还有一种方法是使用广度优先遍历
fun getMaxValue(matrix: Array<IntArray>): Int {
	val rows = matrix.size
	val cols = matrix[0].size
	val maxValues = IntArray(cols)
	for (i in 0 until rows) {
		for (j in 0 until cols) {
			var left = 0
			var up = 0
			if (i > 0) up = maxValues[j]
			if (j > 0) left = maxValues[j - 1]
			maxValues[j] = max(left, up) + matrix[i][j]
		}
	}
	return maxValues[cols - 1]
}