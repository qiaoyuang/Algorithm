package com.qiaoyuang.algorithm

/**
 * 希尔排序 Kotlin 实现
 */

fun testShell() {
	val array = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array.shellSort()
	array.forEach { print("$it ") }
}

fun IntArray.shellSort() {
	var h = 1
	val boundary = size / 3
	while (h < boundary) h = 3 * h + 1
	while (h >= 1) {
		for (i in h until size) {
			var j = i
			while (j >= h && this[j] < this[j - h]) {
				exchange(j, j - h)
				j -= h
			}
		}
		h /= 3
	}
}