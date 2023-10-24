package com.qiaoyuang.algorithm.round0

/**
 * 堆排序 Kotlin 实现
 */

fun testHeapSort() {
	val array = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array.heapSort()
	array.forEach { print("$it ") }
}

fun IntArray.heapSort() {
	var n = size
	val aux = IntArray(size + 1) {
		if (it == 0) 0 else this[it - 1]
	}
	for (k in n shr 1 downTo 1)
		aux.sink(k, n)	
	while (n > 1) {
		aux.exchange(1, n--)
		aux.sink(1, n)
	}
	for (i in indices)
		this[i] = aux[i+1]
}

fun IntArray.sink(K: Int, N: Int) {
	var k = K
	while (2 * k <= N) {
		var j = 2 * k
		if (j < N && this[j] < this[j + 1])
			j++
		if (this[k] > this[j])
			break
        exchange(k, j)
	    k = j
	}
}