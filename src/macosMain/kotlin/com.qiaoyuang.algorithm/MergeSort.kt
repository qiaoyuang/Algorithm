package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 归并排序
 */

fun main() {
	val array1 = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array1.mergeSort1()
	array1.forEach { print("$it ") }
	println()
	val array2 = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	array2.mergeSort2()
	array2.forEach { print("$it ") }
}

// 自顶向下的归并排序
fun IntArray.mergeSort1() {
	val aux = IntArray(size)
	mergeSort(aux, 0, size - 1)
}

private fun IntArray.mergeSort(aux:IntArray, lo: Int, hi: Int) {
	if (hi <= lo) return
	val mid = lo + ((hi - lo) shr 1)
	mergeSort(aux, lo, mid)
	mergeSort(aux, mid + 1, hi)
	merge(aux, lo, mid, hi)
}

// 自底向上的归并排序
fun IntArray.mergeSort2() {
	val aux = IntArray(size)
	var sz = 1
	while (sz < size) {
		var lo = 0
		while (lo < size - sz) {
			merge(aux, lo, lo + sz - 1, min(lo + sz + sz - 1, size - 1))
			lo += sz shl 1
		}
		sz = sz shl 1
	}
}

fun IntArray.merge(aux:IntArray, lo: Int, mid: Int, hi: Int) {
	var i = lo
	var j = mid + 1
	for (k in lo..hi)
		aux[k] = this[k]
	for (k in lo..hi)
		when {
			i > mid -> this[k] = aux[j++]
			j > hi -> this[k] = aux[i++]
			aux[j] < aux[i] -> this[k] = aux[j++]
			else -> this[k] = aux[i++]
		}
}