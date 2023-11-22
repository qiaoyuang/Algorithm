package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test35() {
    printlnResult(arrayOf("23:50", "23:59", "00:00"))
    printlnResult(arrayOf("20:50", "23:59", "21:38", "19:23", "18:47", "22:16"))
}

/**
 * Questions 35: Give a group of time, find the smallest time difference
 */
private fun Array<String>.smallestDifference(): Int {
    require(size > 1) { "The size of time array can't less than 2" }
    val timeArray = BooleanArray(1440)
    forEach {
        val timeIndex = it.timeIndex
        if (timeArray[timeIndex])
            return 0
        timeArray[timeIndex] = true
    }
    var start = 0
    while (!timeArray[start])
        start++
    val first = start
    var end = start + 1
    var last = end
    var diff = Int.MAX_VALUE
    while (end < timeArray.size) {
        while (end < timeArray.size && !timeArray[end])
            end++
        if (end < timeArray.size) {
            val newDiff = end - start
            if (newDiff < diff)
                diff = newDiff
            last = end
            start = end++
        }
    }
    return min(diff, first + timeArray.size - last)
}

private val String.timeIndex: Int
    get() = substring(0, 2).toInt() * 60 + substring(3, 5).toInt()

private fun printlnResult(times: Array<String>) =
    println("The smallest time difference in ${times.toList()} is ${times.smallestDifference()}")