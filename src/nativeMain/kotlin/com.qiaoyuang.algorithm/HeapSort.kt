package com.qiaoyuang.algorithm

/**
 * 堆排序 Kotlin 实现
 */

fun main() {
	val array = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array.heapSort()
	array.forEach { print("$it ") }
}

fun IntArray.heapSort() {
	var n = size
	val aux = IntArray(size + 1)
	for (i in 0 until size)
		aux[i+1] = this[i]
	for (k in n shr 1 downTo 1)
		aux.sink(k, n)	
	while (n > 1) {
		aux.exchange(1, n--)
		aux.sink(1, n)
	}
	for (i in 0 until size)
		this[i] = aux[i+1]
}

fun IntArray.sink(K: Int, N: Int) {
	var k = K
	while (2 * k <= N) {
		var j = 2 * k
		if (j < N && this[j] < this[j+1]) j++
		if (this[k] > this[j]) break
        exchange(k, j)
	    k = j
	}
}