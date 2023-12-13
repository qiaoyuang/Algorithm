package com.qiaoyuang.algorithm.special

fun test58() {
    val calendar = MyCalendar()
    println("Add 0, 50: ${calendar.book(0, 50)}")
    println("Add 50, 55: ${calendar.book(50, 55)}")
    println("Add 35, 39: ${calendar.book(35, 39)}")
}

/**
 * Questions 58: Design a class MyCalendar, it could add periods of time,
 * if this time free, then adding success, otherwise fail
 */
private class MyCalendar {

    // We should use TreeMap in JVM environment, it's time complexity will be best
    private val calendarList = ArrayList<IntRange>()

    fun book(start: Int, end: Int): Boolean {
        val result = !calendarList.any { start in it || end in it }
        if (result)
            calendarList.add(start ..< end)
        return result
    }
}