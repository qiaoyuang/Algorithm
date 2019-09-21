package com.qiaoyuang.algorithm

fun main() {
	val array = intArrayOf(1, 2, 4, 7, 11, 15)
	print("和为15的两个数为：")
	findNumbersWithSum(array, 15).forEach { print("$it ") }
	println()
	println()
	val list1 = findContinuousSequence(15)
	while (!list1.isEmpty) {
		val value = list1.pop()
		print("和为15的序列为：")
		value.forEach { print("$it ") }
		println()
	}
	println()
	val list2 = findContinuousSequence(19)
	while (!list2.isEmpty) {
		val value = list2.pop()
		print("和为19的序列为：")
		value.forEach { print("$it ") }
		println()
	}
}

/**
 * 题目一：在一个已排序的数组中输出任意一组和为s的两个数字。
 */
fun findNumbersWithSum(array: IntArray, s: Int): IntArray {
	var start = 0
	var end = array.size - 1
	val result = IntArray(2)
	while (start < end) {
		if (array[start] + array[end] < s) {
			start++
		} else if (array[start] + array[end] > s) {
			end--
		} else {
			result[0] = array[start]
			result[1] = array[end]
			break
		}
	}
	return result
}

/**
 * 题目二：输入一个数字s，求所有和为s的正整数序列。
 */
fun findContinuousSequence(s: Int): LinkedList<IntArray> {
	var small = 1
	var big = 2
	val list = LinkedList<IntArray>()
	val mid = (1 + s) / 2
	while (small < mid) {
		var sum = 0
		for (i in small..big) {
		    sum += i
	    }
	    if (sum > s) {
		    small++
	    } else if (sum < s) {
		    big++
	    } else {
		    val array = IntArray(big - small + 1) { it + small }
		    list.push(array)
			small++
	    }
	}
	return list
}