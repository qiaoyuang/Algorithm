package com.qiaoyuang.algorithm.special

fun test64() {
    val dict = listOf("happy", "new", "year")
    val dictionary = MagicDictionary(dict)
    val now = "now"
    println("Modify a char in $now, can we find a word in dictionary $dict: ${dictionary.search(now)}")
    val new = "new"
    println("Modify a char in $new, can we find a word in dictionary $dict: ${dictionary.search(new)}")
    val tear = "tear"
    println("Modify a char in $tear, can we find a word in dictionary $dict: ${dictionary.search(tear)}")
    val happi = "happi"
    println("Modify a char in $happi, can we find a word in dictionary $dict: ${dictionary.search(happi)}")
}

private class MagicDictionary(words: List<String>) {

    private val trieTree = TrieTree()

    init {
        words.forEach {
            trieTree.insert(it)
        }
    }

    fun search(word: String): Boolean = trieTree.searchWith1Char(word)
}