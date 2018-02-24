package offer

//从n到一个整数中1出现的次数

fun main(args: Array<String>) {
	println("1出现的次数为：${numberOf1Between1AndN(211)}")
}

fun numberOf1Between1AndN(number: Int): Int {
	var divisor = number
	var b = 0
	while (divisor != 0) {
		divisor /= 10
		b++
	}
	divisor = number
	val numberArray = IntArray(b)
	for (i in 0 until b) {
		numberArray[i] = divisor % 10
		divisor /= 10
	}
	var count = 0
	for (i in b-1 downTo 0) {
		//当某一数位上的数字是1和0的时候要特殊处理
		count += if (i + 1 >= b) {
			1 * Math.pow(10.0, i.toDouble()).toInt()
		} else {
			numberArray[i+1] * Math.pow(10.0, i.toDouble()).toInt()
		}
				/*if (numberArray[i] == 1) {
			var value = 1
			for (j in 0 until i) {
				value += numberArray[j] * Math.pow(10.0, j.toDouble()).toInt()
			}
			value
		} else if (numberArray[i] == 0) {
			0
		} else {
			if (i + 1 >= b) {
			    1 * Math.pow(10.0, i.toDouble()).toInt()
		    } else {
			    numberArray[i+1] * Math.pow(10.0, i.toDouble()).toInt()
		    }
		}*/
		
	}
	return count
}