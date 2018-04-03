package offer

//求n个骰子的和的所有可能值出现的概率

fun main(args: Array<String>) {
	printProbability1(6)
	printProbability2(6)
}

const val MAX_VALUE = 6

//基于递归
fun printProbability1(number: Int) {
	val array = IntArray(number) { 1 }
	val sumArray = IntArray(MAX_VALUE * number - number + 1)
	fun sum(): Int {
		var sum = 0
		array.forEach { sum += it }
		return sum
	}
	fun printProbability(index: Int) {
		if (index >= number) return
		while (array[index] < MAX_VALUE) {
			if (index != 0) array[index]++
			val sum = sum()
		    sumArray[sum - MAX_VALUE]++
		    printProbability(index + 1)
			if (index == 0) array[index]++
		}
	}
	printProbability(0)
	var sum = 0
	sumArray.forEach {
		sum += it
	}
	for (i in 0 until sumArray.size)
		println("和为：${i + MAX_VALUE}，概率为：${sumArray[i]} / $sum")
}

//基于循环
fun printProbability2(number: Int) {
	
}