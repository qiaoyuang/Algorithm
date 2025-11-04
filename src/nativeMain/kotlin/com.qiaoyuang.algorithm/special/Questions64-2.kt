package com.qiaoyuang.algorithm.special

fun test64_2() {
    val dict = listOf("happy", "new", "year")
    val dictionary = MagicDictionary2()
    dictionary.buildDict(dict)
    val now = "now"
    println("Modify a char in $now, can we find a word in dictionary $dict: ${dictionary.search(now)}")
    val new = "new"
    println("Modify a char in $new, can we find a word in dictionary $dict: ${dictionary.search(new)}")
    val tear = "tear"
    println("Modify a char in $tear, can we find a word in dictionary $dict: ${dictionary.search(tear)}")
    val happi = "happi"
    println("Modify a char in $happi, can we find a word in dictionary $dict: ${dictionary.search(happi)}")
}

private class MagicDictionary2 {

    private val root = TrieNode2()

    fun buildDict(words: List<String>) {
        words.forEach { word ->
            var p = root
            word.forEach { c ->
                p = p.next[c - 'a'] ?: TrieNode2().also {
                    p.next[c - 'a'] = it
                }
            }
            p.isWord = true
        }
    }

    fun search(word: String): Boolean = search(word, 0, root, false)

    private fun search(
        word: String, index: Int,
        trie: TrieNode2, isChanged: Boolean,
    ): Boolean {
        if (index == word.length)
            return isChanged && trie.isWord
        trie.next.forEachIndexed { i, c ->
            if (c != null) {
                val changed = word[index] - 'a' != i
                if (!(isChanged && changed) && search(word, index + 1, c, changed || isChanged))
                    return true
            }
        }
        return false
    }
}