package com.qiaoyuang.algorithm

import offer.LinkedList.Node

/**
 * 约瑟夫环问题
 */

fun main() {
	println(lastRemaining1(5, 3))
	println(lastRemaining2(5, 3))
}

// 循环链表模拟法
fun lastRemaining1(n: Int, m: Int): Int {
	lateinit var start: Node<Int>
	lateinit var end: Node<Int>
	lateinit var pointer: Node<Int>
	for (i in 0 until n) {
		val node = Node<Int>()
		node.set(i)
		if (i == 0) {
			start = node
			pointer = node
		} else {
			pointer.next = node
			pointer = node
		}
		if (i == n - 1) end = node
	}
	end.next = start
	start = start.next
	pointer = end.next
	var count = n
	while (count != 1) {
		for (i in 1 until m) {
			start = start.next
			pointer = pointer.next
			end = end.next
		}
		pointer.next = null
		end.next = start
		pointer = start
		start = start.next
		count--
	}
	return pointer.get()
}

// 数学公式法
fun lastRemaining2(n: Int, m: Int): Int {
	if (n < 1 || m < 1)
		throw IllegalArgumentException("n 和 m 必须大于 1")
	var last = 0
	for(i in 2..n)
		last = (last + m) % i
	return last
}