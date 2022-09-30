package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 将数字按顺序序列化后的第n位数字
 */

fun main() {
	val index = 1001
	println("位于第${index}位的数字是：${digitAtIndex(index)}")
}

fun digitAtIndex(n: Int): Int {
	require(n >= 0) { "输入必须大于等于0" }
	var index = n
	var count = 1
	var bit = 10
	if (index < bit * count) return n
	index -= count * bit
	bit *= 9
	while (true) {
		count++
		if (index <= bit * count) {
			val quotient = index / count
		    val remainder = index.rem(count)
			val number = 10.toFloat().pow((count - 1).toFloat()).toInt() + quotient
		    return number getBit2 remainder
		}
		index -= count * bit
		bit *= 10
	}
}

private infix fun Int.getBit2(value: Int): Int {
	var num = this
	var bit = 0
	while (num != 0) {
		num /= 10
		bit++
	}
	val a = bit - value
	num = this
	for (i in 1 until a) num /= 10
	return num.rem(10)
}