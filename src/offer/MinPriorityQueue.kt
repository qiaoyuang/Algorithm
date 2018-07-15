package offer

//最大优先队列，暂时没有实现数组扩容

class MaxPriorityQueue {
	
	private val pq = IntArray(16)
	var size = 0
	    private set
	
	fun isEmpty(): Boolean = size == 0
	
	fun offer(e: Int) {
		pq[++size] = e
		swim(size)
	}
	
	private fun swim(i: Int) {
		var k = i
		while (k > 1 && pq[k/2] < pq[k]) {
			exch(k/2, k)
			k = k / 2
		}
	}
	
	private fun exch(i: Int, j: Int) {
		val t = pq[i]
		pq[i] = pq[j]
		pq[j] = t
	}
	
	fun peek(): Int? =
			if (size == 0) null
	        else pq[1]
	
	fun poll(): Int {
		val min = pq[1]
		exch(1, size--)
		pq[size + 1] = 0
		sink(1)
		return min
	}
	
	private fun sink(i: Int) {
		var k = i
		while (2*k <= size) {
			var j = 2 * k
			if (j < size && pq[j] < pq[j+1]) j++
			if (pq[k] > pq[j]) break
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