package com.qiaoyuang.algorithm.special

fun test63_2() {
    val sentence = "the cattle was rattled by the battery"
    println("""Replace the words to tries in this statement: "$sentence"""")
    val dictionary = listOf("cat", "bat", "rat")
    println("The dictionary is $dictionary")
    println("""We got: "${replaceWords(dictionary, sentence)}"""")
}

/**
 * Questions 63: Replace words to tries in a English statement
 */
private fun replaceWords(dictionary: List<String>, sentence: String): String {
    val trie = Trie()
    dictionary.forEach {
        trie.insert(it)
    }
    val words = sentence.split(' ')
    return buildString {
        words.forEach {
            append(trie.findPrefix(it) ?: it)
            append(' ')
        }
        deleteAt(lastIndex)
    }
}