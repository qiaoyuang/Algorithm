package com.qiaoyuang.algorithm.special

fun test65() {
    printlnResult(arrayOf("time", "me", "bell"))
}

/**
 * Questions 65: Minimum length of string array encoding
 */
private fun Array<String>.minimumLength(): Int {
    val trieTree = TrieTree()
    forEach {
        trieTree.insert(it.reversed())
    }
    return trieTree.lengthOfAllWords()
}

private fun printlnResult(strings: Array<String>) =
    println("The minimum length of string array ${strings.toList()} is ${strings.minimumLength()}")