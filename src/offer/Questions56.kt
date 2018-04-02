package offer

import kotlin.math.*

import kotlin.collections.ArrayList

fun main(args: Array<String>) {
	val array1 = intArrayOf(2, 4, 3, 6, 3, 2, 5, 5)
	val array2 = intArrayOf(1, 3, 9, 6, 6, 8, 1, 3, 8, 0)
	findNumAppearOnce(array1).forEach { print("$it ") }
	println()
	findNumAppearOnce(array2).forEach { print("$it ") }
	println()
	val array3 = intArrayOf(6, 7, 6, 8, 8, 7, 5, 7, 8, 6)
	println(findNumberAppearingOnce(array3))
}

/*
 * 题目一：数组中有两个数字只出现了一次，另外每个数字都出现了两次，求这两个数字
 */
fun findNumAppearOnce(array: IntArray): IntArray {
	if (array.size % 2 != 0)
		throw IllegalArgumentException("输入的数组的长度必须是偶数")
	var temp = array[0]
	for (i in 1 until array.size)
		temp = temp xor array[i]
	var index = 0
	while (temp % 2 != 1) {
		index++
		temp = temp shr 1
	}
	val left = ArrayList<Int>()
	val right = ArrayList<Int>()
	array.forEach {
		val a = it shr index
		val b = a % 2
		if (b == 0) left.add(it)
		else right.add(it)
	}
	val result = IntArray(2)
	result[0] = if (left.size == 1) {
		left[0]
	} else {
		var tempLeft = left[0]
		for (i in 1 until left.size)
		    tempLeft = tempLeft xor left[i]
		tempLeft
	}
	result[1] = if (right.size == 1) {
		right[0]
	} else {
		var tempRight = right[0]
	    for (i in 1 until right.size)
		    tempRight = tempRight xor right[i]
		tempRight
	}
	return result
}

/*
 * 题目二：一个数组中只有一个数出现了1次，其它数都出现了3次，找出出现1次的数
 */
fun findNumberAppearingOnce(array: IntArray): Int {
	val sum = IntArray(32)
	var bitMusk = 1
	var result = 0
	for (i in 0..31) {
		array.forEach { sum[i] += it and bitMusk }
		if (sum[i] % 3 != 0)
			result += 2.toFloat().pow(i.toFloat()).toInt()
		bitMusk = bitMusk shl 1
	}
	return result
}