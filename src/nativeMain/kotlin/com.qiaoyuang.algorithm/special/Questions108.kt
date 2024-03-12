package com.qiaoyuang.algorithm.special

fun test108() {
    printlnResult(
        beginWord = "hit",
        endWord = "cog",
        words = listOf("hot", "dot", "dog", "log", "log", "cog")
    )
}

/**
 * Questions 108: Words evolution
 */
private fun evolutionSingleBFS(beginWord: String, endWord: String, words: List<String>): Int {
    var queue1 = ArrayDeque<String>()
    var queue2 = ArrayDeque<String>()
    val noVisited = HashSet(words)
    var length = 1
    queue1.add(beginWord)
    while (queue1.isNotEmpty()) {
        val word = queue1.removeFirst()
        if (word == endWord)
            return length
        val neighbors = getNeighbors(word)
        neighbors.forEach {
            if (noVisited.contains(it)) {
                queue2.add(it)
                noVisited.remove(it)
            }
        }
        if (queue1.isEmpty()) {
            length++
            val temp = queue1
            queue1 = queue2
            queue2 = temp
        }
    }
    return 0
}

private fun getNeighbors(word: String): List<String> = buildList {
    val chars = word.toCharArray()
    chars.forEachIndexed { i, old ->
        for (ch in 'a'..'z')
            if (old != ch) {
                chars[i] = ch
                add(chars.concatToString())
            }
        chars[i] = old
    }
}

private fun evolutionDoubleBFS(beginWord: String, endWord: String, words: List<String>): Int {
    val noVisited = HashSet(words)
    if (noVisited.contains(endWord))
        noVisited.remove(endWord)
    else
        return 0
    var set1 = HashSet<String>()
    set1.add(beginWord)
    var set2 = HashSet<String>()
    set2.add(endWord)
    var length = 2
    while (set1.isNotEmpty() && set2.isNotEmpty()) {
        if (set1.isEmpty()) {
            val temp = set2
            set2 = set1
            set1 = temp
        }
        val set3 = HashSet<String>()
        set1.forEach { word ->
            getNeighbors(word).forEach { neighbor ->
                if (set2.contains(neighbor))
                    return length
                if (noVisited.contains(neighbor)) {
                    set3.add(neighbor)
                    noVisited.remove(neighbor)
                }
            }
        }
        set1 = set3
        length++
    }
    return 0
}

private fun printlnResult(beginWord: String, endWord: String, words: List<String>) =
    println("The $beginWord changes to $endWord in $words need: (${evolutionSingleBFS(beginWord, endWord, words)}, ${evolutionDoubleBFS(beginWord, endWord, words)})")