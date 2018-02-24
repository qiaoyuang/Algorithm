package offer

fun main(args: Array<String>) {
	val array1 = intArrayOf(1, 2, 3, 3, 3, 4, 5, 6)
	val array2 = intArrayOf(1, 2, 3, 4, 5, 6, 6, 6)
	println("数字3出现的次数为：${getNumberOfK(array1, 3)}")
	println("数字6出现的次数为：${getNumberOfK(array2, 3)}")
}

fun getNumberOfK(array: IntArray, k: Int): Int =
    getLastK(array, k, 0, array.size - 1) - getFirstK(array, k, 0, array.size - 1) + 1

private fun getFirstK(array: IntArray, k: Int, first: Int, last: Int): Int {
	val mod = (first + last) / 2
	if (k > array[mod]) {
		println("1")
		return getFirstK(array, k, mod, last)
	} else if (k < array[mod]) {
		println("2")
		return getFirstK(array, k, first, mod)
	} else if (mod - 1 < 0 || array[mod-1] != k) {
		println("3")
		return mod
	} else {
		println("4")
		return getFirstK(array, k, first, mod)
	}
}

private fun getLastK(array: IntArray, k: Int, first: Int, last: Int): Int {
	val mod = (first + last) / 2
	if (k > array[mod]) {
		return getLastK(array, k, mod, last)
	} else if (k < array[mod]) {
		return getLastK(array, k, first, mod)
	} else if (mod + 1 >= array.size || array[mod+1] != k) {
		return mod
	} else {
		return getLastK(array, k, mod, last)
	}
}