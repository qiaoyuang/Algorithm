package com.qiaoyuang.algorithm

import kotlin.math.*

/**
 * 将字符串转化为整数
 */

fun main() {
	val str1 = "123456"
	println(strToInt(str1))
	val str2 = "+123456"
	println(strToInt(str2))
	val str3 = "-123456"
	println(strToInt(str3))
	val str4 = "&123456"
	println(strToInt(str4))
	val str5 = "123&456"
	println(strToInt(str5))
}

fun strToInt(str: String): Int {
	var result = 0
	var symbol = false
	for (i in str.indices) {
		val a = str[i]
		val b = a.toInt()
		if (b < 48 || b > 57) {
			if (i == 0) {
				symbol = when (a) {
					'+' -> false
					'-' -> true
					else -> throw IllegalArgumentException("输入的字符串中含有除数字外的其它字符")
				}
			} else throw IllegalArgumentException("输入的字符串中含有除数字外的其它字符")
		} else {
			result += (b - 48) * (10.toFloat().pow((str.length - i - 1).toFloat())).toInt()
		}
	}
	if (symbol) result -= 2 * result
	return result
}