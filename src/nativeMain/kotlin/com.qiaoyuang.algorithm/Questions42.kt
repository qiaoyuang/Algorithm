package com.qiaoyuang.algorithm

/**
 * 连续子数组的最大和
 */
fun main() {
	val array = intArrayOf(1, -2, 3, 10, -4, 7, 2, -5)
	println("连续子数组的最大和为：${findGreatestSumOfSubArray(array)}")
}

fun findGreatestSumOfSubArray(array: IntArray): Int {
	var sum = 0
	var maxSum = 0
	array.forEach {
		val newSum = sum + it
		if (newSum < 0) {
			sum = 0
		} else {
			if (newSum > sum) maxSum = newSum
			sum = newSum
		}
	}
	return maxSum
}