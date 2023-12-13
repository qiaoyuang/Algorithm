package com.qiaoyuang.algorithm.special

fun test63() {
    val statement = "the cattle was rattled by the battery"
    println("""Replace the words to tries in this statement: "$statement"""")
    val dictionary = listOf("cat", "bat", "rat")
    println("The dictionary is $dictionary")
    println("""We got: "${statement.replaceToTrie(dictionary)}"""")
}

/**
 * Questions 63: Replace words to tries in a English statement
 */
private fun String.replaceToTrie(dictionary: List<String>): String {
    require(isNotEmpty() && dictionary.isNotEmpty()) { "The parameters can't be empty" }
    val tireTree = TrieTree(dictionary.first())
    dictionary.forEach {
        tireTree.insert(it)
    }
    return buildString {
        val words = this@replaceToTrie.split(' ')
        words.forEachIndexed { i, str ->
            tireTree.findTrie(str)?.let { tire ->
                append(tire)
            } ?: kotlin.run {
                append(str)
            }
            if (i < words.lastIndex)
                append(' ')
        }
    }
}