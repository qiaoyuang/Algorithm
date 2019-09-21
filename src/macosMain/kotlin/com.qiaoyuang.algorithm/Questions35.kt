package com.qiaoyuang.algorithm

/**
 * 复制复杂链表
 */

fun main() {
	val node4 = ComplexNode("E")
	val node3 = ComplexNode("D", node4)
	val node2 = ComplexNode("C", node3)
	val node1 = ComplexNode("B", node2, node4)
	val node0 = ComplexNode("A", node1, node2)
	node3.sibling = node1
	var first: ComplexNode<String>? = node0
	while (first != null) {
		println("next:${first.t}")
		if (first.sibling != null) println("sibling:${first.sibling!!.t}")
		first = first.next
	}
}

fun <T> copy(first: ComplexNode<T>): ComplexNode<T> {
	var pointer: ComplexNode<T>? = first
	while (pointer != null) {
		val copy = ComplexNode(pointer.t, pointer.next)
		pointer.next = copy
		pointer = copy.next
	}
	pointer = first
	while (pointer != null) {
		pointer.next!!.sibling = pointer
				.sibling!!.next
		pointer = pointer.next!!
				.next!!
	}
	val copyFirst = first.next
	var nativePointer = first
	var copyPointer = copyFirst
	while (copyPointer!!.next != null) {
		nativePointer.next = copyPointer.next
		nativePointer = nativePointer.next!!
		copyPointer.next = nativePointer.next
		copyPointer = copyPointer.next
	}
	return copyFirst!!
}

data class ComplexNode<T>(var t: T,
						  var next: ComplexNode<T>? = null,
						  var sibling: ComplexNode<T>? = null)