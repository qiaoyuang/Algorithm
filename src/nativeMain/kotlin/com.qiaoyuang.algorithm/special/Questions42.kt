package com.qiaoyuang.algorithm.special

fun test42() {
    printlnResult(0, 100, 1900, 2800, 3000, 3025, 6200, 9600, 10000, 13000, 18000)
}

/**
 * Questions 42: Implement a class RecentCounter, we use it to count the number of ping during the past 3000ms,
 * the parameter of function ping is ping time.
 */
private class RecentCounter {

    private val timeQueue = ArrayDeque<Int>()

    infix fun ping(time: Int): Int {
        timeQueue.addFirst(time)
        while (time - timeQueue.last() > 3000)
            timeQueue.removeLast()
        return timeQueue.size
    }
}

private fun printlnResult(vararg time: Int) {
    println("We request at these time ${time.toList()}, we can get the count of request:")
    val counter = RecentCounter()
    time.forEach {
        println(counter ping it)
    }
}