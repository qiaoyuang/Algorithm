package com.qiaoyuang.algorithm.special

fun test65_2() {
    printlnResult(arrayOf("time", "me", "bell"))
}

private fun minimumLengthEncoding(words: Array<String>): Int {
    val root = TrieNode2()
    var p = root
    words.forEach { word ->
        for (i in word.indices.reversed()) {
            val node = p.next[word[i] - 'a'] ?: TrieNode2().also {
                p.next[word[i] - 'a'] = it
            }
            p = node
        }
    }
    return depth(root, 0)
}

private fun depth(p: TrieNode2, d: Int): Int {
    var length = 0
    var isAllNull = true
    p.next.forEach {
        if (it != null) {
            isAllNull = false
            length += depth(it, d + 1)
        }
    }
    return if (isAllNull) d else length
}

private fun printlnResult(strings: Array<String>) =
    println("The minimum length of string array ${strings.toList()} is ${minimumLengthEncoding(strings)}")