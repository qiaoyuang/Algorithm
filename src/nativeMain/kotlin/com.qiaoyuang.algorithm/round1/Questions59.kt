package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Queue
import com.qiaoyuang.algorithm.round0.Stack

fun test59() {
    printlnResult1(intArrayOf(2, 3, 4, 2, 6, 2, 5, 1), 3)
    printlnResult1(intArrayOf(1, 3, 4, 7, 9, 1, 9, 8), 2)
    printlnResult1(intArrayOf(2, 2, 2, 2, 3, 6, 2, 5, 1), 3)
    printlnResult2(intArrayOf(2, 3, 4, 2, 6, 2, 5, 1))
}

/**
 * Questions 59-1: Given an IntArray and a number, the number present the size of a slide window,
 * find all the largest values in these slide window.
 */
private fun IntArray.findAllLargestNumbers(n: Int): IntArray {
    require(n in 1..size) { "Illegal parameters" }
    if (n == 1)
        return this
    val result = IntArray(size - n + 1)
    val queue = Queue<Int>()
    for (i in 0..< n) this[i].let {
        queue.enqueue(it)
        if (it > queue.last)
            queue.dequeue()
    }

    result[0] = queue.last
    for (i in 1..result.lastIndex) {
        while (n == queue.size || queue.first > queue.last)
            queue.dequeue()

        val newElement = this[i + n - 1]
        queue.enqueue(newElement)

        while (newElement > queue.last)
            queue.dequeue()

        result[i] = queue.last
    }
    return result
}

private fun printlnResult1(array: IntArray, n: Int) =
    println("The IntArray is ${array.toList()}, the size of window is $n, the all max values are: ${array.findAllLargestNumbers(n).toList()}")

/**
 * Questions 59-2: Implementing a queue that contain a max() function could find the max value, and the time complexities of function max, pop, push are O(1)
 */
private class MaxStack<T : Comparable<T>> {

    private val maxStack = Stack<T>()
    private val elementStack = Stack<T>()

    fun push(t: T) {
        elementStack.push(t)
        if (maxStack.isEmpty || maxStack.top() <= t)
            maxStack.push(t)
    }

    fun max(): T = maxStack.top()

    fun pop(): T {
        val t = elementStack.pop()
        if (t == maxStack.top())
            maxStack.pop()
        return t
    }

    val isEmpty
        get() = elementStack.isEmpty

    val size
        get() = elementStack.size

    val top: T
        get() = elementStack.top()
}

private fun printlnResult2(numbers: IntArray) {
    println("Pushing the numbers: ${numbers.toList()} to our Stack")
    val stack = MaxStack<Int>()
    numbers.forEach {
        stack.push(it)
        println("Push $it, top: ${stack.top}, max: ${stack.max()}")
    }
    while (stack.size > 1) {
        val pop = stack.pop()
        println("Pop $pop, top: ${stack.top}, max: ${stack.max()}")
    }
}
