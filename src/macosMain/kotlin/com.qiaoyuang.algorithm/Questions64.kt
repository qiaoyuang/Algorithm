package com.qiaoyuang.algorithm

/**
 * 求1+2+...+n，不能用乘除法，以及循环和判断语句
 */

fun main() {
	println(add1(8))
	println(add2(8))
	println(add3(8))
}

// 解法一：使用构造函数
var sum = 0
var value = 0

class Add {
	init {
		value++
		sum += value
	}
}

fun add1(n: Int): Int {
	Array(n) { Add() }
	return sum
}

// 解法二：使用库函数 repeat()
fun add2(n: Int): Int {
	var sum = 0
	var value = 0
	repeat(n) {
		value++
		sum += value
	}
	return sum
}

// 解法三：使用 Kotlin 数组初始化
fun add3(n: Int): Int {
	var sum = 0
	var value = 0
	val adds = IntArray(n) {
		value++
		sum += value
		sum
	}
	return adds[n - 1]
}