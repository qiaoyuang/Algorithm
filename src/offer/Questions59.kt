package offer

import java.util.LinkedList

fun main(args: Array<String>) {
	val array = intArrayOf(2, 3, 4, 2, 6, 2, 5, 1)
	val result = array.maxInWindow()
	result.forEach { print("$it ") }
	println()
	val queue = MaxQueue<Int>()
	queue.push(2)
	queue.push(5)
	queue.push(8)
	queue.push(6)
	queue.printlnMax()
	queue.pop()
	queue.pop()
	queue.pop()
	queue.push(1)
	queue.printlnMax()
	queue.push(3)
	queue.push(9)
	queue.printlnMax()
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
@Suppress("UNCHECKED_CAST")
class MaxQueue<T : Comparable<T>>() {
	
	private var maxSize = 16
	private var array = Array<Comparable<T>?>(maxSize) { null }
	
	private var head = 0
	private var tail = 0
	
	private var size = 0
	
	private val queue by lazy { LinkedList<Int>() }
	
	fun isEmpty(): Boolean = size == 0
	
	fun push(t: T) {
		if (isEmpty()) {
			array[size++] = t
			queue.offer(head)
			return
		}
		if (tail + 1 > maxSize)
			if (size + 1 > maxSize) {
				expansion()
			} else resize()
		array[++tail] = t
		if (t > array[queue.peek()] as T)
			while (queue.peek() != null) 
				queue.poll()
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
		array = Array<Comparable<T>?>(maxSize) { null }
		for (i in 0 until oldArray.size)
			array[i] = oldArray[i]
	}
	
	fun pop(): T {
		if (isEmpty())
			throw RuntimeException("队列为空")
		if (head == queue.peek()) {
			queue.poll()
			queue.forEachIndexed { e, index ->
				val start = index + 1
				for (i in start until queue.size)
					if (array[e] as T <= array[i] as T)
						queue.poll()
			}
		}
		try {
			return array[head] as T
		} finally {
			array[head++] = null
		}
	}
	
	fun max(): T {
		if (isEmpty())
			throw RuntimeException("队列为空")
		return array[queue.peek()] as T
	}
	
}

fun MaxQueue<*>.printlnMax() {
	println("队列的最大值是：${max()}")
}