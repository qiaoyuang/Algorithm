package com.qiaoyuang.algorithm.special

fun test66() {
    printlnResult("happy" to 3, trie = "hap")
    printlnResult("happy" to 3, "happen" to 2, trie = "hap")
}

/**
 * Questions 66:
 */

private class MapSum {

    private val head = TrieNodeWithValue(' ')

    fun insert(word: String, value: Int) {
        var pointer = head
        word.forEach { c ->
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null) {
                var insertIndex = 0
                for (i in pointer.next.indices)
                    if (pointer.next[i] == null) {
                        insertIndex = i
                        break
                    }
                val newNode = TrieNodeWithValue(c)
                pointer.next[insertIndex] = newNode
                pointer = newNode
            } else
                pointer = nextPointer
        }
        pointer.next[0] = TrieNodeWithValue(' ', value)
    }

    fun sum(trie: String): Int {
        var pointer = head
        trie.forEach { c ->
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null)
                return 0
            else
                pointer = nextPointer
        }
        return dfs(pointer)
    }

    fun dfs(head: TrieNodeWithValue): Int =
        head.next[0]?.value ?: head.next.asSequence().filterNotNull().sumOf { dfs(it) }
}

private class TrieNodeWithValue(
    val character: Char,
    val value: Int? = null,
) {

    var next = Array<TrieNodeWithValue?>(8) { null }
        private set
}

private fun printlnResult(vararg wordWithValue: Pair<String, Int>, trie: String) {
    val map = MapSum()
    wordWithValue.forEach {  (word, value) ->
        map.insert(word, value)
    }
    println("The sum of ${wordWithValue.toList()} is ${map.sum(trie)}")
}