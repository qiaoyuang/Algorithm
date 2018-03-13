package offer

//快速排序Kotlin实现

fun main(args: Array<String>) {
	val array = intArrayOf(5, 7, 2, 9, 3, 1, 4, 0, 8, 6)
	quickSort(array)
	array.forEach { print("$it ") }
}

fun quickSort(array: IntArray) {
	quickSort(array, 0, array.size - 1)
}

private fun quickSort(array: IntArray, low: Int, height: Int) {
	if (height <= low) return
	val mid = partition(array, low, height)
	quickSort(array, low, mid - 1)
	quickSort(array, mid + 1, height)
}

fun partition(array: IntArray, low: Int, height: Int): Int {
	fun exchange(a: Int, b: Int) {
		val temp = array[a]
		array[a] = array[b]
		array[b] = temp
	}
	var i = low
	var j = height + 1
	while (true) {
		while (array[++i] < array[low]) {
			if (i == height) break
		}
		while (array[low] < array[--j]) {
			if (j == low) break
		}
		if (i >= j) break
		exchange(i, j)
	}
	exchange(low, j)
	return j
}