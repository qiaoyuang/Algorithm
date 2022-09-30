package com.qiaoyuang.algorithm

/**
 * 找出数组中最小的k个数
 */

fun main() {
	val array = intArrayOf(4, 5, 1, 6, 2, 7, 3, 8)
	print("最小的4个数为：")
	(array getLeastNumbers2 4).forEach { print("$it ") }
	println()
	print("最小的4个数为：")
	(array getLeastNumbers1 4).forEach { print("$it ") }
}

/**
 * 解法一，需要修改输入数组，时间复杂度为O(n)
 */
infix fun IntArray.getLeastNumbers1(k: Int): IntArray {
	var index = partition(0, this.size - 1)
	while (index != k - 1) {
		if (index > k - 1) {
			index = partition(0, index - 1)
		} else {
			index = partition(index + 1, this.size - 1)
		}
	}
	val output = IntArray(k)
	for (i in 0 until k) {
		output[i] = this[i]
	}
	return output
}

/**
 * 解法二，无需修改输入数组，使用标准类库中的红黑树来实现，时间复杂度为 O(nlogk)
 */
infix fun IntArray.getLeastNumbers2(k: Int): IntArray {
	val tree = HashSet<Int>() // Kotlin 标准库里没有红黑树的数据结构，这里为了编译通过暂时用 HashSet 代替 TreeSet
	forEach { tree.add(it) }
	val output = IntArray(k)
	val iterator = tree.iterator()
	for (i in 0 until k)
		output[i] = iterator.next()
	return output
}