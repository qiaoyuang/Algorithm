package com.qiaoyuang.algorithm

/**
 * 优先队列
 */

@Suppress("UNCHECKED_CAST")
class PriorityQueue<T : Comparable<T>>(comparator: Comparator<T>? = null) {
	
	private var maxSize = 16
	
	private var pq = Array<Comparable<T>?>(maxSize) { null }

	var size = 0
	    private set

	inline val isEmpty: Boolean
		get() = size == 0

	private val moreVal: T.(T) -> Boolean
	private val lessVal: T.(T) -> Boolean

	init {
		val (m, l) = if (comparator == null)
			arrayOf<T.(T) -> Boolean>(
				{ compareTo(it) > 0 },
				{ compareTo(it) < 0 })
		else arrayOf<T.(T) -> Boolean>(
				{ comparator.compare(this, it) > 0 },
				{ comparator.compare(this, it) < 0 })
		moreVal = m
		lessVal = l
	}

	private infix fun T.more(t: T): Boolean = moreVal(t)
	private infix fun T.less(t: T): Boolean = lessVal(t)

	fun enqueue(t: T) {
		if (size + 1 > maxSize)
			expansion()
		pq[++size] = t
		swim(size)
	}
	
	private fun expansion() {
		maxSize = maxSize shl 1
		val oldPq = pq
		pq = Array(maxSize) { null }
		for (i in oldPq.indices)
			pq[i] = oldPq[i]
	}
	
	private fun swim(i: Int) {
		var k = i
		while (k > 1 && (pq[k shr 1] as T) less pq[k] as T) {
			exchange(k shr 1, k)
			k /= 2
		}
	}
	
	private fun exchange(i: Int, j: Int) {
		val t = pq[i]
		pq[i] = pq[j]
		pq[j] = t
	}

	val peek: T
	    get() = if (isEmpty) throw IllegalStateException("队列为空") else pq[1] as T
	
	fun dequeue(): T {
		require(!isEmpty) { "队列为空" }
		val min = pq[1]
		exchange(1, size--)
		pq[size + 1] = null
		sink(1)
		return min as T
	}
	
	private fun sink(i: Int) {
		var k = i
		while (2 * k <= size) {
			var j = 2 * k
			if (j < size && (pq[j] as T) less pq[j + 1] as T) j++
			if ((pq[k] as T) more pq[j] as T) break
			exchange(k, j)
			k = j
		}
	}
	
	fun print() {
		for (i in 1 until pq.size)
			if (i != pq.size - 1) print("${pq[i]},")
		    else print("${pq[i]}\n")
	}
	
}