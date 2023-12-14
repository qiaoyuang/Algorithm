package com.qiaoyuang.algorithm.special

fun test62() {
    val boy = "boy"
    val trieTree = TrieTree(boy)
    val boss = "boss"
    val cowboy = "cowboy"
    trieTree.insert(boss)
    trieTree.insert(cowboy)
    println("Is this trie tree contain $boy: ${trieTree.search(boy)}")
    println("Is this trie tree contain $boss: ${trieTree.search(boss)}")
    println("Is this trie tree contain $cowboy: ${trieTree.search(cowboy)}")
    val bos = "bos"
    println("Is this trie tree contain $bos: ${trieTree.search(bos)}")
    println("Is this trie tree start with $bos: ${trieTree.startWith(bos)}")
    val cow = "cow"
    println("Is this trie tree start with $cow: ${trieTree.startWith(cow)}")
}

/**
 * Questions 62: Design a trie tree
 */
class TrieTree(word: String) {

    private val head = TrieNode(' ')

    init {
        require(word.isNotEmpty()) { "The word can't be empty" }
        var pre = head
        word.forEach {
            val node = TrieNode(it)
            pre.next[0] = node
            pre = node
        }
    }

    fun insert(word: String) {
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
                val newNode = TrieNode(c)
                pointer.next[insertIndex] = newNode
                pointer = newNode
            } else
                pointer = nextPointer
        }
    }

    fun search(word: String): Boolean {
        var pointer = head
        word.forEach { c ->
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null)
                return false
            else
                pointer = nextPointer
        }
        return pointer.next.all { it == null }
    }

    fun searchWith1Char(word: String): Boolean {
        var pointer = head
        var index = 0
        var isFinish = true
        while (index < word.length) {
            val c = word[index++]
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null) {
                isFinish = false
                break
            } else
                pointer = nextPointer
        }

        if (isFinish) return false

        return pointer.next.filterNotNull().any { newHead ->
            var newPointer = newHead
            var newIndex = index
            while (newIndex < word.length) {
                val c = word[newIndex++]
                val nextPointer = newPointer.next.find { node -> node?.character == c }
                if (nextPointer == null)
                    return@any false
                else
                    newPointer = nextPointer
            }
            newPointer.next.all { node -> node == null }
        }
    }

    fun startWith(prefix: String): Boolean {
        var pointer = head
        prefix.forEach { c ->
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null)
                return false
            else
                pointer = nextPointer
        }
        return true
    }

    fun findTrie(str: String): String? {
        var pointer = head
        str.forEachIndexed { i, c ->
            val nextPointer = pointer.next.find { it?.character == c }
            if (nextPointer == null) {
                return if (pointer.next.all { it == null })
                    str.substring(0, i)
                else
                    null
            } else
                pointer = nextPointer
        }
        return null
    }
}

private class TrieNode(val character: Char) {

    var next = Array<TrieNode?>(8) { null }
        private set
}