package offer

//最大优先队列，暂时没有实现数组扩容
@Suppress("UNCHECKED_CAST")
class MaxPriorityQueue<T : Comparable<T>> {
	
	private val maxSize = 16
	
	private var pq = Array<Comparable<T>?>(maxSize) { null }
	var size = 0
	    private set
	
	fun isEmpty(): Boolean = size == 0
	
	fun offer(e: T) {
		pq[++size] = e
		swim(size)
	}
	
	private fun swim(i: Int) {
		var k = i
		while (k > 1 && (pq[k/2] as T) < pq[k] as T) {
			exch(k/2, k)
			k = k / 2
		}
	}
	
	private fun exch(i: Int, j: Int) {
		val t = pq[i]
		pq[i] = pq[j]
		pq[j] = t
	}
	
	fun peek(): T? =
			if (size == 0) null
	        else pq[1] as T
	
	fun poll(): T? {
		if (size == 0) return null
		val min = pq[1]
		exch(1, size--)
		pq[size + 1] = null
		sink(1)
		return min as T
	}
	
	private fun sink(i: Int) {
		var k = i
		while (2*k <= size) {
			var j = 2 * k
			if (j < size && (pq[j] as T) < pq[j+1] as T) j++
			if ((pq[k] as T) > pq[j] as T) break
			exch(k, j)
			k = j
		}
	}
	
	fun print() {
		for (i in 1 until pq.size)
			if (i != pq.size - 1) print("${pq[i]},")
		    else print("${pq[i]}\n")
	}
	
}