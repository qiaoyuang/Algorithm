package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 数组中的逆序对
 */
fun main() {
	val array = intArrayOf(7, 5, 6, 4)
	println("数组中的逆序对共有：${inversePairs1(array)}对")
	println("数组中的逆序对共有：${inversePairs2(array)}对")
}

//自顶向下的归并
fun inversePairs1(array: IntArray): Int {
	if (array.isEmpty()) return 0
	val substitute = IntArray(array.size)
	val aux = IntArray(array.size)
	for (i in array.indices) {
		substitute[i] = array[i]
		aux[i] = array[i]
	}
	return sort(substitute, aux, 0, array.size - 1)
}

private fun sort(a: IntArray, aux: IntArray, lo: Int, hi: Int): Int {
	if (hi <= lo) return 0
	val mid = lo + (hi - lo) / 2
	val myCount = sort(a, aux, lo, mid) + sort(a, aux, mid + 1, hi)
	return merge(a, aux, lo ,mid, hi, myCount)
}

//自底向上的归并
fun inversePairs2(array: IntArray): Int {
	val substitute = IntArray(array.size)
	val aux = IntArray(array.size)
	for (i in array.indices) {
		substitute[i] = array[i]
		aux[i] = array[i]
	}
	var sz = 1
	var count = 0
	while (sz < array.size) {
		var lo = 0
		while (lo < array.size - sz) {
			count = merge(substitute, aux, lo, lo + sz - 1, min(lo + (sz shl 1) - 1, array.size - 1), count)
			lo += sz shl 1
		}
		sz += sz
	}
	return count
}

private fun merge(a: IntArray, aux: IntArray, lo: Int, mid: Int, hi: Int, count: Int): Int {
	var i = lo
	var j = mid + 1
	var myCount = count
	for (k in lo..hi)
		aux[k] = a[k]
	for (k in lo..hi)
		when {
			i > mid -> a[k] = aux[j++]
			j > hi ->a[k] = aux[i++]
			aux[j] < aux[i] -> {
				a[k] = aux[j++]
				myCount += mid + 1 - i
			}
			else -> a[k] = aux[i++]
		}
	return myCount
}