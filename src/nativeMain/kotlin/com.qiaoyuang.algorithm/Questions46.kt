package com.qiaoyuang.algorithm

/**
 * 将数字翻译成字符串
 */

fun main() {
	val num = 12258
	println("${num}有：${getTranslationCount(num)}种翻译方法")
}

fun getTranslationCount(number: Int): Int {
	require(number >= 0) { "数字必须是非负数" }
	return getTranslationCount(number.toString())
}

private fun getTranslationCount(str: String): Int {
	if (str.length <= 1) return 1
	var count = 0
	count += getTranslationCount(str.substring(0, str.length - 1))
	if (str.length >= 2) {
		val num = str.substring(str.length - 2, str.length).toInt()
	    if (num <= 25)
		    count += getTranslationCount(str.substring(0, str.length - 2))
	}
	return count
}