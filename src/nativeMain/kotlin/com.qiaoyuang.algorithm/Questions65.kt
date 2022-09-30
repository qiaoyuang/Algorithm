package com.qiaoyuang.algorithm

fun test65() {
	println(6 myAdd 9)
	val array = IntArray(2)
	array[0] = 1
	array[1] = 2
	println("a=${array[0]}, b=${array[1]}")
	array.exchange1(0, 1)
	println("a=${array[0]}, b=${array[1]}")
	array.exchange2(0, 1)
	println("a=${array[0]}, b=${array[1]}")
}

/**
 * 不用加减乘除做加法
 */
infix fun Int.myAdd(n: Int): Int {
	var num1 = this
	var num2 = n
	var sum: Int
	var carry: Int
	do {
		sum = num1 xor num2
		carry = num1 and num2 shl 1
		num1 = sum
		num2 = carry
	} while(num2 != 0)
	return num1
}

/**
 * 相关问题：不使用新变量
 */

// 基于加减法
fun IntArray.exchange1(i: Int, j: Int) {
	this[i] += this[j]
	this[j] = this[i] - this[j]
	this[i] = this[i] - this[j]
}

// 基于位运算
fun IntArray.exchange2(i: Int, j: Int) {
	this[i] = this[i] xor this[j]
	this[j] = this[i] xor this[j]
	this[i] = this[i] xor this[j]
}