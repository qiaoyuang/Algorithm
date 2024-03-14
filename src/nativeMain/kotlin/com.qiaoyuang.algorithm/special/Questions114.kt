package com.qiaoyuang.algorithm.special

fun test114() {
    printlnResult("ac", "ab", "bc", "zc", "zb")
}

/**
 * Questions 114: Given a related sequences of English lowercase letters,
 * please find the possible sequence of the lowercase letters.
 */
private fun findLettersOrder(prerequisites: Array<out String>): String {
    when (prerequisites.size) {
        0 -> return ""
        1 -> return prerequisites.first()
    }

    val graph = HashMap<Char, MutableList<Char>>()
    val inDegrees = HashMap<Char, Int>()

    var pointer1 = 0
    var pointer2 = 1
    while (pointer2 < prerequisites.size) {
        val pre1 = prerequisites[pointer1].first()
        val latter1 = prerequisites[pointer1].last()
        val pre2 = prerequisites[pointer2].first()
        val latter2 = prerequisites[pointer2].last()
        if (pre1 == pre2) {
            graph[latter1]?.add(latter2) ?: run { graph[latter1] = mutableListOf(latter2) }
            if (!inDegrees.contains(latter1))
                inDegrees[latter1] = 0
            inDegrees[latter2] = (inDegrees[latter2] ?: 0) + 1
        } else {
            graph[pre1]?.add(pre2) ?: run { graph[pre1] = mutableListOf(pre2) }
            if (!inDegrees.contains(pre1))
                inDegrees[pre1] = 0
            inDegrees[pre2] = (inDegrees[pre2] ?: 0) + 1
        }
        pointer1++
        pointer2++
    }

    val queue = ArrayDeque<Char>()
    inDegrees.forEach { (letter, inDegree) ->
        if (inDegree == 0)
            queue.add(letter)
    }
    val order = StringBuilder()
    while (queue.isNotEmpty()) {
        val letter = queue.removeFirst()
        graph[letter]?.run {
            forEach {
                inDegrees[it] = inDegrees[it]!! - 1
                if (inDegrees[it] == 0)
                    queue.add(it)
            }
            graph.remove(letter)
        }
        order.append(letter)
    }
    return if (graph.isEmpty()) order.toString() else ""
}

private fun printlnResult(vararg prerequisites: String) =
    println("The possible letters sequence is ${findLettersOrder(prerequisites).toList()}")