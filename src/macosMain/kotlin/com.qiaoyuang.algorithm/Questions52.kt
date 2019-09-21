package com.qiaoyuang.algorithm

/**
 * 两个链表的第一个公共节点
 */

fun main() {
	val a = Node(1)
	val b = Node(2)
	val c = Node(3)
	val d = Node(4)
	val e = Node(5)
	val f = Node(6)
	val g = Node(7)
	
	a.next = b
	b.next = c
	c.next = f
	f.next = g
	d.next = e
	e.next = f
	
	println("公共节点为：${findFirstCommonNode(a, d).t}")
}

fun <T> findFirstCommonNode(listNode1: Node<T>, listNode2: Node<T>): Node<T> {
	var node1: Node<T>? = listNode1
	var node2: Node<T>? = listNode2
	
	fun length(listNode: Node<T>?): Int {
		var node: Node<T>? = listNode
		var length = 1
		while (node?.next != null) {
		    node = node.next
		    length++
	    }
		return length
	}
	
	val length1 = length(node1)
	val length2 = length(node2)
	
	if (length1 > length2) {
		for (i in 1..length1 - length2) {
			node1 = node1?.next
	    }
	} else if (length1 < length2) {
		for (i in 1..length2 - length1) {
			node2 = node2?.next
	    }
	}
	
	while (node1 != null) {
		if (node1 === node2) {
			return node1
		}
		node1 = node1.next
		node2 = node2?.next
	}
	throw IllegalArgumentException("两个链表没有共同节点")
}