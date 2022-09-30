package com.qiaoyuang.algorithm

/**
 * 快速排序 Kotlin 实现
 */

fun main() {
	val array = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array.quickSort()
	array.forEach { print("$it ") }
}

fun IntArray.quickSort() {
	quickSort(0, this.size - 1)
}

private fun IntArray.quickSort(low: Int, height: Int) {
	if (height <= low) return
	val mid = partition(low, height)
	quickSort(low, mid - 1)
	quickSort(mid + 1, height)
}

fun IntArray.partition(low: Int, height: Int): Int {
	var i = low
	var j = height + 1
	while (true) {
		while (this[++i] < this[low])
			if (i == height) break
		while (this[low] < this[--j])
			if (j == low) break
		if (i >= j) break
		exchange(i, j)
	}
	exchange(low, j)
	return j
}

fun IntArray.exchange(a: Int, b: Int) {
	val temp = this[a]
	this[a] = this[b]
	this[b] = temp
}