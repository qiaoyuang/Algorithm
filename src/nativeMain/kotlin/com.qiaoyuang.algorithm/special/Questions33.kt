package com.qiaoyuang.algorithm.special

fun test33() {
    printlnResult(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}

/**
 * Questions 33: Group Anagrams, LeetCode 49
 */
private fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()
    strings.forEach {
        val array = it.toCharArray()
        array.sort()
        val key = array.concatToString()
        (map[key] ?: ArrayList<String>().also { list ->
            map[key] = list
        }).add(it)
    }
    return map.values.toList()
}

private fun printlnResult(strings: Array<String>) =
    println("Group ${strings.toList()}, we got: ${groupAnagrams(strings)}")