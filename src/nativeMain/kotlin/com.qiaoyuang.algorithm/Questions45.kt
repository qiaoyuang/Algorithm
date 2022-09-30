package com.qiaoyuang.algorithm

/**
 * 把数组排成最小的数
 */

fun main() {
	val array = intArrayOf(3, 32, 321)
	println("最小的数字为：${printMinNumber(array)}")
}

fun printMinNumber(array: IntArray): String {
	array.newQuickSort(0, array.size - 1)
	val builder = StringBuilder(array[0].toString())
	for (i in 1 until array.size) {
		builder.append(array[i])
	}
	return builder.toString()
}

private fun IntArray.newQuickSort(low: Int, height: Int) {
	if (height <= low) return
	val mid = newPartition(low, height)
	newQuickSort(low, mid - 1)
	newQuickSort(mid + 1, height)
}

private fun IntArray.newPartition(low: Int, height: Int): Int {
	fun exchange(a: Int, b: Int) {
		val temp = this[a]
		this[a] = this[b]
		this[b] = temp
	}
	var i = low
	var j = height + 1
	while (true) {
		while (this[++i] compare this[low] < 0) {
			if (i == height) break
		}
		while (this[low] compare this[--j] < 0) {
			if (j == low) break
		}
		if (i >= j) break
		exchange(i, j)
	}
	exchange(low, j)
	return j
}

private infix fun Int.compare(value: Int): Int {
	var a = this
	var b = value
	var bitA = 0
	while (a != 0) {
		a /= 10
		bitA++
	}
	var bitB = 0
	while (b != 0) {
		b /= 10
		bitB++
	}
	
	infix fun Int.getBit(bit: Int): Int {
		var num = this
		for (i in 1 until bit) num /= 10
		return num.rem(10)
    }
	
	when {
		bitA == bitB -> {
			while (bitA != 0) {
				a = this getBit bitA
				b = value getBit bitA
				if (a > b) return 1
				else if (a < b) return -1
				else bitA--
			}
		}
		bitA > bitB -> {
			var bitBB = bitB
			while (bitB != 0) {
				a = this getBit bitB
				b = value getBit bitB
				if (a > b) return 1
				else if (a < b) return -1
				else bitB--
			}
			bitA -= bitB
			while (bitA != 0) {
				a = this getBit bitA
				b = value getBit bitBB
				if (a > b) return 1
				else if (a < b) return -1
				else {
					bitA--
					bitBB--
				}
			}
		}
		bitA < bitB -> {
			var bitAA = bitA
			while (bitA != 0) {
				a = this getBit bitA
				b = value getBit bitA
				if (a > b) return 1
				else if (a < b) return -1
				else bitA--
			}
			bitB -= bitA
			while (bitB != 0) {
				a = this getBit bitAA
				b = value getBit bitB
				if (a > b) return 1
				else if (a < b) return -1
				else {
					bitB--
					bitAA--
				}
			}
		}
	}
	return 0
}