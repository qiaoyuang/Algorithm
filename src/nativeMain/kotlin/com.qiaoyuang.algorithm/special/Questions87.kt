package com.qiaoyuang.algorithm.special

fun test87() {
    printlnResult("10203040")
    printlnResult("25502309")
}

/**
 * Questions 87: Find the all legal IP addresses that a number could be split
 */
private fun String.allIPAddresses(): List<String> {
    require(length >= 4) { "The length of the string must greater or equal than 4" }
    return buildList {
        backTrack(this@allIPAddresses, mutableListOf(), 0, 1)
    }
}

private fun MutableList<String>.backTrack(str: String, ip: MutableList<String>, i: Int, j: Int) {
    if (ip.size == 4) {
        if (j > str.length)
            add(ip.toIPAddress())
    } else if (j > str.length) {
        return
    } else {
        val section = str.substring(i, j)
        if (section.isLegal()) {
            ip.add(section)
            backTrack(str, ip, j, j + 1)
            ip.removeLast()
        }
        backTrack(str, ip, i, j + 1)
    }
}

private fun String.isLegal(): Boolean = length == 1 || (first() != '0' && toInt() <= 255)

private fun List<String>.toIPAddress(): String = foldIndexed(StringBuilder()) { index, acc, section ->
    acc.append(section)
    if (index == lastIndex)
        acc
    else
        acc.append('.')
}.toString()

private fun printlnResult(str: String) =
    println("The number $str could be split to ip addresses: ${str.allIPAddresses()}")