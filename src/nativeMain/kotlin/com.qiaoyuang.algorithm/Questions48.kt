package com.qiaoyuang.algorithm

/**
 * 一个只包含小写字母的字符串的最大非重复子字符串的长度
 */

fun main() {
	val str = "arabcacfr"
	println("字符串：$str，最大子字符串的长度是：${longestSubstringWithoutDuplication(str)}")
}

fun longestSubstringWithoutDuplication(str: String): Int {
	// 检查字符是否合法
	fun Char.isLegal(): Boolean = toInt() in 97..122
	// 获取字符在数组中的位置
	fun Char.getPosition(): Int = toInt() - 97
	// 计算逻辑
	val array = IntArray(26) { 0 }
	var curLength = 0
	var maxLength = 0
	for (i in str.indices) {
		val c = str[i]
		require(c.isLegal()) { "输入的字符串包含不合法字符" }
		val position = c.getPosition()
		if (array[position] == 0) {
			curLength++
		} else {
			curLength = 1
			for (j in array.indices)
			    array[j] = 0
		}
		array[position]++
		if (curLength > maxLength) maxLength = curLength
	}
	return maxLength
}