package offer

import java.util.LinkedList

fun main(args: Array<String>) {
	val array = intArrayOf(2, 3, 4, 2, 6, 2, 5, 1)
	val result = array.maxInWindow()
	result.forEach { print("$it ") }
	println()
}

/*
 * 题目一：在一个长度不定的数组中找出相邻三个数中的最大值
 */
fun IntArray.maxInWindow(): IntArray {
	if (size < 3)
		throw IllegalArgumentException("输出的数组长度必须大于3")
	val queue = LinkedList<Int>()
	val result = IntArray(size - 2)
	for (i in 0 until size) {
		if (queue.size == 0) {
			queue.addFirst(i)
		} else if (this[queue.last()] > this[i]) {
			queue.addFirst(i)
		} else {
			while (queue.size != 0)
				queue.removeLast()
			queue.addFirst(i)
		}
		while (queue.size > 3)
			queue.removeLast()
		if (i >= 2) {
			result[i - 2] = this[queue.last]
		}
	}
	return result
}