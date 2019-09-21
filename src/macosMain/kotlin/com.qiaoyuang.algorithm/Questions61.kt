package com.qiaoyuang.algorithm

/**
 * 判断任意张扑克牌是不是顺子，A，2与3连接后也是顺子，大小王用0表示
 */

fun main() {
	val array1 = intArrayOf(5, 6, 3, 2, 1, 8, 0, 0)
	println(isContinuous(array1))
	val array2 = intArrayOf(5, 6, 3, 2, 1, 8, 0, 0, 0)
	println(isContinuous(array2))
	val array3 = intArrayOf(5, 6, 3, 2, 1, 8, 7, 4)
	println(isContinuous(array3))
	val array4 = intArrayOf(5, 6, 3, 2, 1, 8, 3, 4, 6)
	println(isContinuous(array4))
}

fun isContinuous(array: IntArray): Boolean {
	if (array.size > 15) return false
	array.quickSort()
	var kingCount = 0
	for (i in 0 until array.size - 1) {
		if (kingCount > 2) return false
		if (array[i] == 0) {
			kingCount++
			continue
		}
		if (array[i] == array[i + 1]) return false
		if (array[i] + 2 == array[i + 1]) {
			if (kingCount > 0) {
				kingCount--
			} else return false
		}
		if (array[i] + 3 == array[i + 1]) {
			if (kingCount > 1) {
				kingCount -= 2
			} else return false
		}
	}
	return true
}