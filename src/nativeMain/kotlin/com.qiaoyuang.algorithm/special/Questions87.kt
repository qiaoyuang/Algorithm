package com.qiaoyuang.algorithm.special

fun test87() {
    printlnResult("10203040")
    printlnResult("25502309")
}

/**
 * Questions 87: Find the all legal IP addresses that a number could be split
 */
private fun allIPAddresses(str: String): List<String> {
    require(str.length >= 4) { "The length of the string must greater or equal than 4" }
    val result = ArrayList<String>()
    backtrack(str, 0, 0, StringBuilder(), result)
    return result
}

private fun backtrack(
    str: String,
    count: Int,
    i: Int,
    builder: StringBuilder,
    result: ArrayList<String>,
) {
    if (i == str.length) {
        if (count == 4) {
            builder.deleteAt(builder.lastIndex)
            result.add(builder.toString())
            builder.append('.')
        }
        return
    }
    for (j in 1..3) {
        if (i + j > str.length)
            return
        val seg = str.substring(i, i + j)
        val isEndLoop = seg == "0"
        if (seg.toInt() > 255)
            return
        builder.append(seg)
        builder.append('.')
        backtrack(str, count + 1, i + j, builder, result)
        builder.deleteRange(builder.length - seg.length - 1, builder.length)
        if (isEndLoop)
            return
    }
}

private fun printlnResult(str: String) =
    println("The number $str could be split to ip addresses: ${allIPAddresses(str)}")