package offer

//数组中的逆序对

fun main(args: Array<String>) {
	val list = ArrayList<Int>()
	list.add(1)
	list.add(2)
	list.add(3)
	println(list)
	//list.filter { it == 1 }
	list[1] = 6
	println(list)
}

/*
 * 题目一：寻找一个字符串中第一个只出现一次的字符
 */
fun findNotRepeatingChar(str: String): Char {
	val map = LinkedHashMap<Char, Int>()
	for (i in 0 until str.length) {
		val c = str.get(i)
		if (map[c] == null) {
			map[c] = 1
		} else {
			map[c] = map[c]!! + 1
		}
	}
	map.forEach { c, i ->
		if (i == 0) return c
	}
	throw IllegalArgumentException("没有只出现一次的字符")
}

