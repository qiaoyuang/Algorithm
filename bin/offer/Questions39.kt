package offer

//找出一个数组中出现次数超过数组长度一般的数字

fun main(args: Array<String>) {
	val arg0 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)
	val arg1 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4)
	val message = "超过数组长度一半的数为："
	println("$message${moreThanHalfNum2(arg0)}")
	println("$message${moreThanHalfNum2(arg1)}")
	//println("$message${moreThanHalfNum1(arg0)}")
	//println("$message${moreThanHalfNum1(arg1)}")
}

//解法一，需要修改输入数组，时间复杂度为O(n)
//fun moreThanHalfNum1(args: IntArray): Int 

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
		throw RuntimeException("û�з���Ҫ�������")
	}
}