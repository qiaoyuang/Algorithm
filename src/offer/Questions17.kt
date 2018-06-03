package offer

import java.math.BigInteger
import kotlin.math.*

//打印n位数(注意大数问题)

fun main(args: Array<String>) {
	printlToMaxOfNDigits1(3)
	printlToMaxOfNDigits2(3)
	printlToMaxOfNDigits3(3)
}

//使用Java大数字类
fun printlToMaxOfNDigits1(n: Int) {
	if (n <= 0) throw IllegalArgumentException("输入的数字必须大于0")
	var max = BigInteger("0")
	val nine = BigInteger("9")
	val ten = BigInteger("10")
	for (i in 0 until n) max += nine * ten.pow(i)
	var index = BigInteger("0")
	while (index <= max) {
		println(index)
		index++
	}
}

//使用数组方式
fun printlToMaxOfNDigits2(n: Int) {
	val array = IntArray(n) { 0 }
	//逆向打印数组
	fun printArray() {
		var pos = array.size -1
		while (pos > 0) {
			if (array[pos] == 0) {
				pos--
			} else break
		}
		for (i in pos downTo 0)
			print(array[i])
		println()
	}
	//递归计算
	fun recursive(index: Int) {
		for (i in 0..9) {
			array[index] = i
			if (index == 0) printArray()
			if (index > 0) recursive(index - 1)
		}
		array[index] = 0
	}
	recursive(array.size - 1)
}

//使用字符串方式（原理和使用数组是一样的）
fun printlToMaxOfNDigits3(n: Int) {
	val builder = StringBuilder()
	for (i in 1..n) builder.append("0")
	//反向打印字符串
	fun StringBuilder.print() {
		val newBuilder = StringBuilder("")
		for (i in this.length - 1 downTo 0)
			newBuilder.append(this.get(i))
		var pos = 0
		val str = newBuilder.toString()
		while (pos < str.length - 1) {
			if (str.get(pos) == '0')
				pos++
			else break
		}
		println(str.substring(pos, str.length))
	}
	//递归计算
	fun recursive(index: Int) {
		for (i in 0..9) {
			builder.replace(index, index + 1, i.toString())
			if (index == 0) builder.print()
			if (index > 0) recursive(index - 1)
		}
		builder.replace(index, index + 1, 0.toString())
	}
	recursive(builder.length - 1)
}