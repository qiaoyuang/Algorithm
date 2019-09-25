package com.qiaoyuang.algorithm

fun main() {
	val array = intArrayOf(2, 3, 4, 2, 6, 2, 5, 1)
	val result = array.maxInWindow()
	result.forEach { print("$it ") }
	println()
	val queue = MaxQueue<Int>()
	queue.enqueue(2)
	queue.enqueue(5)
	queue.enqueue(8)
	queue.enqueue(6)
	queue.printlnMax()
	queue.dequeue()
	queue.dequeue()
	queue.dequeue()
	queue.enqueue(1)
	queue.printlnMax()
	queue.enqueue(3)
	queue.enqueue(9)
	queue.printlnMax()
}

/**
 * 题目一：在一个长度不定的数组中找出相邻三个数中的最大值
 */
fun IntArray.maxInWindow(): IntArray {
	require(size >= 3) { "输出的数组长度必须大于等于3" }
	val queue = LinkedList<Int>()
	val result = IntArray(size - 2)
	for (i in 0 until size) {
		if (!queue.isEmpty && queue.last > this[i])
			while (queue.size != 0)
				queue.dequeue()
		queue.enqueue(this[i])
		if (queue.size > 3) {
			while (true) {
			    if (queue.size > 3) {
				    queue.dequeue()
			    } else if (queue.size == 3) {
				    if (queue[2] < queue[1]) {
			            queue.dequeue()
		            } else if (queue[2] < queue[1]) {
					    queue.dequeue()
					    queue.dequeue()
				    } else break
			    } else if (queue.size == 2) {
				    if (queue[1] < queue[0]) {
			            queue.dequeue()
				    } else break
			    } else if (queue.size == 1) break
		    }
		}
		if (i >= 2)
			result[i - 2] = queue.last
	}
	return result
}

/**
 * 题目二：定义一个入队和出队以及查询最大值，时间复杂度都是O(1)的队列
 */
@Suppress("UNCHECKED_CAST")
class MaxQueue<T : Comparable<T>> : AbstractQueue<T> {
	
	private var maxSize = 16
	private var array = Array<Comparable<T>?>(maxSize) { null }
	
	private var head = 0
	private var tail = 0
	
	private val queue = LinkedList<Int>()

	override val isEmpty: Boolean
		get() = size == 0

	override val first: T
		get() = array[head] as T

	override val last: T
		get() = array[tail] as T

	override var size: Int = 0

	override fun enqueue(t: T) {
		if (isEmpty) {
			array[size++] = t
			queue.offer(head)
			return
		}
		if (tail + 1 > maxSize)
			if (size + 1 > maxSize) {
				expansion()
			} else resize()
		array[++tail] = t
		if (t > array[queue.first] as T)
			while (true)
				try {
					queue.pop()
				} catch (e: IllegalStateException) {
					e.printStackTrace()
					break
				}
		queue.offer(tail)
		size++
	}
	
	private fun resize() {
		var j = 0
		for (i in head until tail) {
			array[j++] = array[head]
			array[head++] = null
		}
		head = 0
		tail = j
	}
	
	private fun expansion() {
		maxSize = maxSize shl 1
		val oldArray = array
		array = Array(maxSize) { null }
		for (i in oldArray.indices)
			array[i] = oldArray[i]
	}
	
	override fun dequeue(): T {
		check(!isEmpty) { "队列为空" }
		if (head == queue.first) {
			queue.pop()
			queue.forEachIndexed { e, index ->
				val start = index + 1
				for (i in start until queue.size)
					if (array[e] as T <= array[i] as T)
						queue.pop()
			}
		}
		try {
			return array[head] as T
		} finally {
			array[head++] = null
		}
	}
	
	fun max(): T {
		check(!isEmpty) { "队列为空" }
		return array[queue.first] as T
	}
	
}

fun MaxQueue<*>.printlnMax() {
	println("队列的最大值是：${max()}")
}