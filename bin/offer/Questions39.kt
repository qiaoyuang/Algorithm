package offer

//找出一个数组中出现次数超过数组长度一般的数字

fun main(args: Array<String>) {
	try {
		val arg0 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)
	    val arg1 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4)
	    val message = "超过数组长度一半的数为："
	    println("$message${moreThanHalfNum2(arg0)}")
	    println("$message${moreThanHalfNum2(arg1)}")
		println("$message${moreThanHalfNum1(arg0)}")
	    println("$message${moreThanHalfNum1(arg1)}")
	} catch (e: RuntimeException) {
		e.printStackTrace()
	}
}

/*
 *解法一，需要修改输入数组，时间复杂度为O(n)
 *此方法较为受限，首先必须明确知道数组中一定有数量超过长度一半的数字。
 *如果没有也不能发现这种情况，且会返回一个错误的值，即数组排序后的中位数，
 *因此总体来说，解法二更为优秀。
 */
fun moreThanHalfNum1(args: IntArray): Int {
	val mid = args.size / 2
	var index = partition(args, 0, args.size - 1)
	while (index != mid) {
		if (index > mid) {
			index = partition(args, 0, index - 1)
		} else {
			index = partition(args, index + 1, args.size - 1)
		}
	}
	return args[mid]
}

//解法二，无需修改输入数组，时间复杂度为O(n)
fun moreThanHalfNum2(args: IntArray): Int {
	var index = 0
	var number = args[index]
	var count = 0
	args.forEach {
		if (it == number) {
			count++
		} else {
			--count
			if (count == 0) {
				number = args[++index]
				count = 1
			}
		}
	}
	if (count > 1) {
		return number
	} else {
		throw RuntimeException("数组中没有长度超过一般的数字")
	}
}