package com.qiaoyuang.algorithm.special

fun test62_2() {
    val trieTree = Trie()
    val boy = "boy"
    trieTree.insert(boy)
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
class Trie {

    val head = TrieNode2()

    fun insert(str: String) {
        var p = head
        str.forEach {
            p = p.next[it.code - 'a'.code] ?: TrieNode2().also { node ->
                p.next[it.code - 'a'.code] = node
            }
        }
        p.isWord = true
    }

    fun search(str: String): Boolean {
        var p = head
        str.forEach {
            p = p.next[it.code - 'a'.code] ?: return false
        }
        return p.isWord
    }

    fun startWith(str: String): Boolean {
        var p = head
        str.forEach {
            p = p.next[it.code - 'a'.code] ?: return false
        }
        return true
    }

    fun findPrefix(str: String): String? {
        val builder = StringBuilder()
        var p = head
        for (c in str)
            p = p.next[c.code - 'a'.code]?.apply { builder.append(c) } ?: break
        return builder.takeIf { it.isNotEmpty() }?.toString()
    }
}

class TrieNode2 {

    val next = Array<TrieNode2?>(26) { null }

    var isWord = false
}