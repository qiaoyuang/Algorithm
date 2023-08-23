package com.qiaoyuang.algorithm.round0

/**
 * 找出一个数组中出现次数超过数组长度一般的数字
 */

fun test39() {
	try {
		val arg0 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)
	    val arg1 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4)
	    val message = "超过数组长度一半的数为："
		println("$message${arg0.moreThanHalfNum2()}")
		println("$message${arg1.moreThanHalfNum2()}")
		println("$message${arg0.moreThanHalfNum1()}")
		println("$message${arg1.moreThanHalfNum1()}")
	} catch (e: RuntimeException) {
		e.printStackTrace()
	}
}

/**
 * 解法一，需要修改输入数组，时间复杂度为O(n)
 * 此方法较为受限，首先必须明确知道数组中一定有数量超过长度一半的数字。
 * 如果没有也不能发现这种情况，且会返回一个错误的值，即数组排序后的中位数，
 * 因此总体来说，解法二更为优秀。
 */
fun IntArray.moreThanHalfNum1(): Int {
	val mid = size shr 1
	var start = 0
	var end = lastIndex
	var index = partition(start, end)
	while (index != mid) {
		if (index > mid)
			end = index - 1
		else
			start = index + 1
		index = partition(start, end)
	}
	return this[mid]
}

//解法二，无需修改输入数组，时间复杂度为O(n)
fun IntArray.moreThanHalfNum2(): Int {
	var index = 0
	var number = this[index]
	var count = 0
	this.forEach {
		if (it == number) {
			count++
		} else {
			--count
			if (count == 0) {
				number = this[++index]
				count = 1
			}
		}
	}
	require(count > 1) { "数组中没有长度超过一般的数字" }
	return number
}