package com.qiaoyuang.algorithm

/**
 * 判断一组数字是否是栈的弹出序列
 */

fun main() {
	val enter = intArrayOf(1,2,3,4,5)
	val out1 = intArrayOf(4,5,3,2,1)
	val out2 = intArrayOf(4,3,5,1,2)
	println(judgment(enter, out1))
	println(judgment(enter, out2))
}

fun judgment(enter: IntArray, out: IntArray): Boolean {
	if (enter.size != out.size) return false
	val stack = Stack<Int>()
	var j = 0
	for (i in out.indices) {
		while (j < enter.size) {
			if (stack.size == 0) {
				stack.push(enter[j])
				j++
			}
			if (stack.first == out[i]) {
				stack.pop()
				break
			} else {
				stack.push(enter[j])
				j++
			}
		}
		if (j >= enter.size) {
			while (stack.size != 0) {
				if (stack.first == out[i]) {
				    stack.pop()
				    break
			    } else {
				    return false
			    }
		    }
		}
	}
	return true
}