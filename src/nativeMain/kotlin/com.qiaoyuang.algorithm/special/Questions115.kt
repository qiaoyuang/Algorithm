package com.qiaoyuang.algorithm.special

fun test115() {
    printlnResult(
        intArrayOf(4, 1, 5, 2, 6, 3),
        arrayOf(intArrayOf(5, 2, 6, 3), intArrayOf(4, 1, 5, 2))
    )
    printlnResult(
        intArrayOf(1, 2, 3),
        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3))
    )
}

/**
 * Questions 115: Judge if the array org is the only one sequence of Array<IntArray> sequences
 */
private fun isOnly1Seq(org: IntArray, sequences: Array<IntArray>): Boolean {
    val graph = IntArray(org.size + 1)
    val set = org.toHashSet()
    sequences.forEach { seq ->
        if (seq.size < 2)
            return@forEach
        var pointer1 = 0
        var pointer2 = 1
        while (pointer2 < seq.size) {
            if (graph[seq[pointer1]] == 0) {
                if (set.contains(seq[pointer2]))
                    set.remove(seq[pointer2])
                graph[seq[pointer1]] = seq[pointer2]
            } else if (graph[seq[pointer1]] != seq[pointer2])
                return false
            pointer1++
            pointer2++
        }
    }

    if (set.size != 1)
        return false
    var pointer = set.first()
    repeat(org.size) { i ->
        if (pointer != org[i])
            return false
        pointer = graph[pointer]
    }
    return true
}

private fun printlnResult(org: IntArray, sequences: Array<IntArray>) =
    println("Is ${org.toList()} the only one sequence: ${isOnly1Seq(org, sequences)}")