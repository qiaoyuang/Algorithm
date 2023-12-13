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
private class TrieTree(word: String) {

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
}

private class TrieNode(val character: Char) {

    var next = Array<TrieNode?>(8) { null }
        private set
}