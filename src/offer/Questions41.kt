package offer

import java.util.PriorityQueue

//数据流中的中位数

fun main(args: Array<String>) {
	val str = "数据流中的中位数是："
	val container = MedianContainer()
	container.offer(0)
	println("$str${container.getMedian()}")
	container.offer(8)
	println("$str${container.getMedian()}")
	container.offer(5)
	println("$str${container.getMedian()}")
	container.offer(9)
	println("$str${container.getMedian()}")
	container.offer(2)
	println("$str${container.getMedian()}")
	container.offer(4)
	println("$str${container.getMedian()}")
	container.offer(7)
	println("$str${container.getMedian()}")
	container.offer(1)
	println("$str${container.getMedian()}")
	container.offer(3)
	println("$str${container.getMedian()}")
	container.offer(6)
	println("$str${container.getMedian()}")
}

class MedianContainer() {
	
	private val maxQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }//存放最小一半的数
	private val minQueue = PriorityQueue<Int>()//存放最大一半的数
	
	fun offer(e: Int) {
		if (maxQueue.size == 0) {
			maxQueue.offer(e)
			return
		}
		minQueue.offer(e)
		reSize()
	}
	
	private fun reSize() {
		while (minQueue.size != 0 && minQueue.peek() < maxQueue.peek()!!) {
			maxQueue.offer(minQueue.poll())
		}
		while (minQueue.size - maxQueue.size > 0)
            maxQueue.offer(minQueue.poll()!!)
		while (maxQueue.size - minQueue.size > 1)
            minQueue.offer(maxQueue.poll()!!)
	}
	
	fun getMedian(): Int =
			if (maxQueue.size == minQueue.size) {
				maxQueue.peek()!! + minQueue.peek() shr 1
			} else {
				maxQueue.peek()!!
			}
	
	fun PriorityQueue<Int>.print() {
		for (e in this) {
			print("$e,")
		}
		println()
	}
	
}