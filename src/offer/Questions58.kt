package offer

fun main(args: Array<String>) {
	val str1 = "I am a student."
	println("翻转后得到：${str1.reverseSentence()}")
	println()
	val str2 = "abcdefg"
	println("输入：$str2，左旋转2位后得到：${str2.leftRoate(2)}")
}

/*
 *题目一：翻转字符串单词顺序
 */
fun String.reverseSentence(): String {
	val array = this.split(" ")
	val builder = StringBuilder("")
	for (i in array.size downTo 0) {
		builder.append(array[0])
	}
	return builder.toString()
}

/*
 *题目二：左旋转字符串
 */
fun String.leftRoate(n: Int): String =
		this.substring(n, this.length) + this.substring(0, n)