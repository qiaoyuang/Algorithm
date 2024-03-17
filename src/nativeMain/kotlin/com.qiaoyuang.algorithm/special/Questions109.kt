package com.qiaoyuang.algorithm.special

fun test109() {
    printlnResult("0202", arrayOf("0102", "0201"))
}

/**
 * Questions 109: The count of steps of opening a lock with password
 */
private fun openSteps(password: String, deadLocks: Array<String>): Int {
    val deadLocksSet = deadLocks.toHashSet()
    val init = "0000"
    if (deadLocksSet.contains(init) || deadLocksSet.contains(password))
        return -1

    val visited = HashSet<String>()
    var queue1 = ArrayDeque<String>()
    var queue2 = ArrayDeque<String>()
    var steps = 0
    queue1.add(init)
    visited.add(init)

    while (queue1.isNotEmpty()) {
        val current = queue1.removeFirst()
        if (current == password)
            return steps
        getNextSteps(current).forEach {
            if (!deadLocksSet.contains(it) && !visited.contains(it)) {
                queue2.add(it)
                visited.add(it)
            }
        }
        if (queue1.isEmpty()) {
            steps++
            val temp = queue2
            queue2 = queue1
            queue1 = temp
        }
    }

    return steps
}

private fun getNextSteps(password: String): List<String> = buildList {
    val chars = password.toCharArray()
    for (i in chars.indices) {
        val thisChar = chars[i]

        val currentMinus1 = thisChar.digitToInt() - 1
        val currentPlus1 = thisChar.digitToInt() + 1

        chars[i] = if (currentMinus1 == -1) '9' else currentMinus1.digitToChar()
        add(chars.concatToString())

        chars[i] = if (currentPlus1 == 10) '0' else currentPlus1.digitToChar()
        add(chars.concatToString())

        chars[i] = thisChar
    }
}

private fun printlnResult(password: String, deadLocks: Array<String>) =
    println("Given a password $password, and a dead locks list ${deadLocks.toList()}, we at least need ${openSteps(password, deadLocks)} steps to open it")