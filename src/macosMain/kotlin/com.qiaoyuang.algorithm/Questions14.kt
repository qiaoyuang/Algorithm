package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 将长度为n的绳子剪成m段，求每段乘积相乘最大时的最大乘积
 */

fun main() {
	println("绳子长度为8时，最大乘积为：${maxProductAfterCutting1(8)}")
	println("绳子长度为8时，最大乘积为：${maxProductAfterCutting2(8)}")
}

// 动态规划
fun maxProductAfterCutting1(length: Int): Int = when {
	length < 2 -> throw IllegalArgumentException("绳子的长度必须大于 2")
	length == 2 -> 1
	length == 3 ->  2
	else -> IntArray(length + 1).let {
		for (i in 0..3)
			it[i] = i
		for (i in 4..length) {
			var max = 0
			val temp = i / 2
			for (j in 1..temp) {
				val product = it[j] * it[i - j]
				if (max < product)
					max = product
				it[i] = max
			}
		}
		it[length]
	}
}

// 贪心算法
fun maxProductAfterCutting2(length: Int): Int = when {
	length < 2 -> throw IllegalArgumentException("绳子的长度必须大于 2")
	length == 2 -> 1
	length == 3 ->  2
	else -> {
		var timesOf3 = length / 3
		if (length - timesOf3 * 3 == 1)
			timesOf3 -= 1
		val timesOf2 = (length - timesOf3 * 3) / 2
		(3.0f.pow(timesOf3.toFloat()) * 2.0f.pow(timesOf2.toFloat())).toInt()
	}
}