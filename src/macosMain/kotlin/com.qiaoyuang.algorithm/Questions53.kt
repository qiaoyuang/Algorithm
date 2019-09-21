package com.qiaoyuang.algorithm

fun main() {
	val array1 = intArrayOf(1, 2, 3, 3, 3, 4, 5, 6)
	val array2 = intArrayOf(1, 2, 3, 4, 5, 6, 6, 6)
	val array3 = intArrayOf(1, 1, 1, 2, 3, 4, 5, 6)
	println("数字3出现的次数为：${getNumberOfK(array1, 3)}")
	println("数字6出现的次数为：${getNumberOfK(array2, 6)}")
	println("数字1出现的次数为：${getNumberOfK(array3, 1)}")
	println()
	
	val array4 = intArrayOf(0, 1, 2, 3, 4, 6, 7, 8)
	val array5 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
	println("缺少的数字为：${getMissingNumber(array4)}")
	println("缺少的数字为：${getMissingNumber(array5)}")
	println()
	
	val array6 = intArrayOf(-3, -1, 1, 3, 5)
	println("下标和值相等的数字为：${getNumberSameAsIndex(array6)}")
}

/**
 * 题目一：寻找一个排序数组中某一个数字出现的次数
 */
fun getNumberOfK(array: IntArray, k: Int): Int =
    getLastK(array, k, 0, array.size - 1) - getFirstK(array, k, 0, array.size - 1) + 1

private fun getFirstK(array: IntArray, k: Int, first: Int, last: Int): Int {
	val mod = (first + last) / 2
	if (k > array[mod]) {
		return getFirstK(array, k, mod, last)
	} else if (k < array[mod]) {
		return getFirstK(array, k, first, mod)
	} else if (mod - 1 < 0 || array[mod-1] != k) {
		return mod
	} else {
		return getFirstK(array, k, first, mod)
	}
}

private fun getLastK(array: IntArray, k: Int, first: Int, last: Int): Int {
	val mod = (first + last) / 2
	if (mod == first) {
		return last
	}
	if (k > array[mod]) {
		return getLastK(array, k, mod, last)
	} else if (k < array[mod]) {
		return getLastK(array, k, first, mod)
	} else if (mod + 1 >= array.size || array[mod+1] != k) {
		return mod
	} else {
		return getLastK(array, k, mod, last)
	}
}

/**
 * 题目二：在一个递增排序的数组中找出缺失的数字
 */
fun getMissingNumber(array: IntArray): Int = binarySearch(array, 0, array.size - 1)

private fun binarySearch(array: IntArray, first: Int, last: Int): Int {
	val mod = (first + last) / 2
	return when {
		mod == array[mod] -> binarySearch(array, mod, last)
		mod == 0 || mod - 1 == array[mod - 1] -> mod
		else -> binarySearch(array, first, mod)
	}
}

/**
 * 题目三：在一个递增排序切没有元素重复的数组中找出下标和值相等的数字
 */
fun getNumberSameAsIndex(array: IntArray): Int {
	var first = 0
	var last = array.size - 1
	var mod = (first + last) / 2
	while (array[mod] != mod) {
		if (array[mod] > mod) {
			last = mod
		} else {
			first = mod
		}
		mod = (first + last) / 2
	}
	return mod
}