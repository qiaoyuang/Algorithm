package com.qiaoyuang.algorithm

import platform.posix.pow

/**
 * 从n到一个整数中1出现的次数
 */

fun main() {
	println("1出现的次数为：${numberOf1Between1AndN(101)}")
}

fun numberOf1Between1AndN(number: Int): Int {
	var divisor = number
	var b = 0
	while (divisor != 0) {
		divisor /= 10
		b++
	}
	divisor = number
	val numberArray = IntArray(b)
	for (i in 0 until b) {
		numberArray[i] = divisor % 10
		divisor /= 10
	}
	var count = 0
	
	fun front(i: Int): Int {
		var a = 1
		var index = 0
		for (j in i + 2 until numberArray.size) {
			index += numberArray[j] * pow(10.0, a.toDouble()).toInt()	
			a++ 
		}
		return index
	}
	
	for (i in b-1 downTo 0) {
		// 当某一数位上的数字是1和0的时候要特殊处理
		count += if (numberArray[i] == 1) {
			var value = 1
			for (j in 0 until i) {
				value += pow(10.0, j.toDouble()).toInt()
			}
			if (i + 1 >= b) {
				1 + number - pow(10.0, (numberArray.size - 1).toDouble()).toInt()
			} else {
				value + (front(i) + numberArray[i+1]) * pow(10.0, i.toDouble()).toInt()	
			}
		} else if (numberArray[i] == 0) {
			(front(i) + numberArray[i+1]) * pow(10.0, i.toDouble()).toInt()
		} else {
			if (i + 1 >= b) {
			    pow(10.0, i.toDouble()).toInt()
		    } else {
				(front(i) + numberArray[i+1] + 1) * pow(10.0, i.toDouble()).toInt()
		    }
		}
	}
	return count
}