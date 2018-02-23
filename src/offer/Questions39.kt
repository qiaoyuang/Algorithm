package offer

//寻找数组中出现次数在数组长度一半以上的数字

fun main(args: Array<String>) {
	val arg0 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)
	val arg1 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4)
	val message = "超过一半的数字为："
	println("$message${moreThanHalfNum2(arg0)}")
	println("$message${moreThanHalfNum2(arg1)}")
	//println("$message${moreThanHalfNum1(arg0)}")
	//println("$message${moreThanHalfNum1(arg1)}")
}

//解法一，改变输入的数组，时间复杂度为O(n)
//fun moreThanHalfNum1(args: IntArray): Int 

//解法二，可以不修改输入数组，时间复杂度O(n)
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
		throw RuntimeException("没有符合要求的数字")
	}
}