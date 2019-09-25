package com.qiaoyuang.algorithm

fun main() {
	val node1 = Node("a")
	val node2 = Node("b")
	node1.next = node2
	val node3 = Node("c")
	node2.next = node3
	val node4 = Node("d")
	node3.next = node4
	val node5 = Node("e")
	node4.next = node5
	val node6 = Node("f")
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
	require(k > 0) { "输入的数字必须大于 0" }
	var priorCount = 1
	var laterCount = 1
	var prior: Node<T>? = this
	var later: Node<T>? = this
	while (prior?.next != null) {
		prior = prior.next
		priorCount++
		if (priorCount > k) {
			later = later?.next
			laterCount++
		}
	}
	require(priorCount - laterCount != k - 1) { "输入的数字k不能大于链表总长" }
	return later!!.t!!
}

/*
 * 相关题目：求链表的中间节点
 */
fun <T> Node<T>.findMidNode(): T {
	var prior: Node<T>? = this
	var later: Node<T>? = this
	while (prior?.next != null) {
		prior = prior.next
		prior = prior?.next
		later = later?.next
	}
	return later!!.t!!
}