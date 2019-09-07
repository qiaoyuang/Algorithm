package com.qiaoyuang.algorithm

import offer.LinkedList.Node

fun main() {
	val node1 = Node<String>()
	node1.set("a")
	val node2 = Node<String>()
	node2.set("b")
	node1.next = node2
	val node3 = Node<String>()
	node3.set("c")
	node2.next = node3
	val node4 = Node<String>()
	node4.set("d")
	node3.next = node4
	val node5 = Node<String>()
	node5.set("e")
	node4.next = node5
	val node6 = Node<String>()
	node6.set("f")
	node5.next = node6
	
	println("倒数第3个节点为${node1.findKthToTail(3)}")
	println("倒数第6个节点为${node1.findKthToTail(6)}")
	println()
	println("链表的中间节点为：${node1.findMidNode()}")
}

/**
 * 链表的倒数第K个节点
 */
fun <T> Node<T>.findKthToTail(k: Int): T {
	if (k <= 0)
		throw IllegalArgumentException("输入的数字必须大于0")
	var priorCount = 1
	var laterCount = 1
	var prior = this
	var later = this
	while (prior.next != null) {
		prior = prior.next
		priorCount++
		if (priorCount > k) {
			later = later.next
			laterCount++
		}
	}
	if (priorCount - laterCount != k - 1)
		throw IllegalArgumentException("输入的数字k不能大于链表总长")
	return later.get()
}

/*
 * 相关题目：求链表的中间节点
 */
fun <T> Node<T>.findMidNode(): T {
	var prior: Node<T>? = this
	var later = this
	while (prior != null && prior!!.next != null) {
		prior = prior.next
		prior = prior.next
		later = later.next
	}
	return later.get()
}