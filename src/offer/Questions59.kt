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
			queue.addFirst(this[i])
		} else if (queue.last() > this[i]) {
			queue.addFirst(this[i])
		} else {
			while (queue.size != 0)
				queue.removeLast()
			queue.addFirst(this[i])
		}
		if (queue.size > 3) {
			while (true) {
			    if (queue.size > 3) {
				    queue.removeLast()
			    } else if (queue.size == 3) {
				    if (queue.get(2) < queue.get(1)) {
			            queue.removeLast()
		            } else if (queue.get(2) < queue.get(0)) {
					    queue.removeLast()
					    queue.removeLast()
				    } else break
			    } else if (queue.size == 2) {
				    if (queue.get(1) < queue.get(0)) {
			            queue.removeLast()
				    } else break
			    } else if (queue.size == 1) break
		    }
		}
		if (i >= 2)
			result[i - 2] = queue.last
	}
	return result
}

/*
 * 题目二：定义一个入队和出队以及查询最大值，时间复杂度都是O(1)的队列
 */
class Queue<T : Comparable<T>>() {
	
	private var head: Node<T>? = null
	private var tail: Node<T>? = null
	
	var size = 0
	
	fun isEmpty(): Boolean = size == 0
	
	fun enqueue(t: T) {
		val node = Node<T>(t)
		if (size == 0) {
			head = node
			tail = node
		} else {
			node.next = head
			head!!.front = node
			head = node
		}
		size++
	}
	
	fun dequeue(): T {
		if (size == 0) {
			throw RuntimeException("队列为空")
		} else if (size == 1) {
			try {
				return head!!.value
			} finally {
				head == null
				tail == null
				size--
			}
		} else {
			val node = tail
			val front = tail!!.front
			front!!.next = null
			tail!!.front = null
			tail = front
			return node!!.value
		}
	}
	
	fun max(): T {
		
	}
	
	data class Node<T>(val value: T, var front: Node<T>? = null, var next: Node<T>? = null)
	
}