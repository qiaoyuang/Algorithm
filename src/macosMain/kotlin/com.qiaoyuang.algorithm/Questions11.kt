package com.qiaoyuang.algorithm

/**
 * 找出旋转数组中最小的数
 */

fun main() {
	val arg0 = intArrayOf(3, 4, 5, 1, 2)
	val arg1 = intArrayOf(1, 0, 1, 1, 1)
	val arg2 = intArrayOf(1, 1, 1, 0, 1)
	val arg3 = intArrayOf(1, 1, 1, 1, 1)
	val message = "最小的数字为："
	println("$message${min(arg0)}")
	println("$message${min(arg1)}")
	println("$message${min(arg2)}")
	println("$message${min(arg3)}")
}

fun min(args: IntArray): Int {
	var index1 = 0
	var index2 = args.size - 1
	while (index2 - index1 != 1) {
		var indexMid = (index1 + index2) / 2
		when {
			args[indexMid] >= args[index1] && args[indexMid] != args[index2] -> index1 = indexMid
			args[indexMid] <= args[index2] && args[indexMid] != args[index1] -> index2 = indexMid
			args[indexMid] == args[index1] && args[indexMid] == args[index2] -> {
				while (indexMid < index2) {
					if (args[indexMid] < args[index2]) {
						return args[indexMid]
					}
					indexMid++
				}
				while (indexMid > index1) {
					if (args[indexMid] < args[index1]) {
						return args[indexMid]
					}
					indexMid--
				}
				return args[indexMid]
			}
		}
	}
	return args[index2]
}
