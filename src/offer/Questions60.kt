package offer

import kotlin.math.*

//求n个骰子的和的所有可能值出现的概率

fun main(args: Array<String>) {
	val start1Time = System.currentTimeMillis()
	printProbability1(6)
	val end1Time = System.currentTimeMillis()
	println("递归的执行时间为：${end1Time - start1Time}ms")
	println()
	val start2Time = System.currentTimeMillis()
	printProbability2(6)
	val end2Time = System.currentTimeMillis()
	println("递归的执行时间为：${end2Time - start2Time}ms")
}

const val MAX_VALUE = 6

//基于递归
fun printProbability1(number: Int) {
	if (number < 1) return
	val array = IntArray(number) { 1 }
	val sumArray = IntArray(MAX_VALUE * number - number + 1)
	fun sum(): Int {
		var sum = 0
		array.forEach { sum += it }
		return sum
	}
	fun printProbability(index: Int) {
		if (index >= number) {
			val sum = sum()
		    sumArray[sum - number]++
			return
		}
		while (array[index] <= MAX_VALUE) {
		    printProbability(index + 1)
			array[index]++
		}
		array[index] = 1
	}
	printProbability(0)
	var sum = 0
	sumArray.forEach { sum += it }
	for (i in 0 until sumArray.size)
		println("和为：${i + number}，概率为：${sumArray[i]}/$sum")
}

//基于循环
fun printProbability2(number: Int) {
	if (number < 1) return
	val length = MAX_VALUE * number + 1
	val probabilities = Array<IntArray>(2) { IntArray(length) }
	var flag = 0
	for (i in 1..MAX_VALUE)
		probabilities[flag][i] = 1
	for (k in 2..number) {
		for (i in 0 until k)
			probabilities[1 - flag][i] = 0
		for (i in k until length) {
			probabilities[1 - flag][i] = 0
			var j = 1
			while (j <= i && j <= MAX_VALUE) {
				probabilities[1 - flag][i] += probabilities[flag][i - j]
				j++
			}
		}
		flag = 1 - flag
	}
	val total = MAX_VALUE.toFloat().pow(number.toFloat()).toInt()
	for (i in number until length)
		println("和为：$i，概率为：${probabilities[flag][i]}/$total")
}
