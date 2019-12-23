package com.qiaoyuang.algorithm

fun main() {
	val str1 = "abacdeff"
	println(findNotRepeatingChar(str1))
	val str2 = "We are Students."
	val str3 = "aeiou"
	println(deleteChar(str2, str3))
	val str4 = "google"
	println(deleteRepeatChar(str4))
	val str5 = "silent"
	val str6 = "listen"
	val str7 = "evil"
	val str8 = "live"
	println(isAnagram(str5, str6))
	println(isAnagram(str7, str8))
}

/**
 * 题目一：寻找一个字符串中第一个只出现一次的字符
 */
fun findNotRepeatingChar(str: String): Char {
	val map = LinkedHashMap<Char, Int>()
	for (i in str.indices) {
		val c = str[i]
		val v = map[c]
		map[c] = if (v == null) 1 else v + 1
	}
	var result: Char? = null
	var isFound = true
	map.forEach {
		val (c, i) = it
		if (i == 1 && isFound) {
			result = c
			isFound = false
		}
	}
	return result!!
}

/**
 * 相关题目：输入两个字符串，从第一个字符串中删除所有第二个字符串中出现过的字符
 */
fun deleteChar(str1: String, str2: String): String {
	val list = ArrayList<Char>()
	for (i in str2.indices) {
		val c = str2[i]
		if (c !in list)
			list.add(c)
	}
	val builder = StringBuilder(str1)
	var i = 0
	while (i < builder.length) {
		val c = builder[i]
		if (c in list) {
			builder.deleteCharAt(i)
		} else i++
	}
	return builder.toString()
}

/**
 * 相关题目：删除一个字符串中的所有重复字符
 */
fun deleteRepeatChar(str: String): String {
	val list = ArrayList<Char>()
	val builder = StringBuilder(str)
	var i = 0
	while (i < builder.length) {
		val c = builder[i]
		if (c in list) {
			builder.deleteCharAt(i)
		} else {
			list.add(c)
			i++
		}
	}
	return builder.toString()
}

/**
 * 相关题目：判断两个单词是否为变位词
 */
fun isAnagram(str1: String, str2: String): Boolean {
	if (str1.length != str2.length) return false
	fun create(str: String): HashMap<Char, Int> {
		val map = HashMap<Char, Int>()
	    for (i in str.indices) {
		    val c = str2[i]
			if (map[c] == null) {
			    map[c] = 1
		    } else {
			    map[c] = map[c]!! + 1
		    }
	    }
		return map
	}
	val map1 = create(str1)
	val map2 = create(str2)
	return map1 == map2
}

/**
 * 题目二：字符流中第一个只出现一次的字符
 */