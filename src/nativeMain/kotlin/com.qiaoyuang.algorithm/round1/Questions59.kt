package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Stack

fun test59() {
    printlnResult1(intArrayOf(2, 3, 4, 2, 6, 2, 5, 1), 3)
    printlnResult1(intArrayOf(1, 3, 4, 7, 9, 1, 9, 8), 2)
}

/**
 * Questions 59-1: Given an IntArray and a number, the number present the size of a slide window,
 * find all the largest values in these slide window.
 */
private fun IntArray.findAllLargestNumbers(n: Int): IntArray {
    require(n in 1..size) { "Illegal parameters" }
    val result = IntArray(size - n + 1)
    val queue = Window<Int>()
    for (i in 0..< n)
        queue.enqueue(this[i])
    for (i in 0.. result.lastIndex) {
        result[i] = queue.max()
        if (i + n >= size)
            break
        queue.dequeue()
        queue.enqueue(this[i + n])
    }
    return result
}

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
}

private class Window<T : Comparable<T>> {

    private val stack1 = MaxStack<T>()
    private val stack2 = MaxStack<T>()

    fun enqueue(t: T) {
        stack1.push(t)
    }

    fun dequeue(): T {
        if (!stack2.isEmpty)
            return stack2.pop()
        while (stack1.size > 1) {
            stack2.push(stack1.pop())
        }
        return stack1.pop()
    }

    fun max(): T = when {
        stack1.isEmpty && stack2.isEmpty -> throw IllegalStateException("This windows doesn't contain any element")
        !stack1.isEmpty && stack2.isEmpty -> stack1.max()
        stack1.isEmpty && !stack2.isEmpty -> stack2.max()
        else -> if (stack1.max() > stack2.max()) stack1.max() else stack2.max()
    }
}

private fun printlnResult1(array: IntArray, n: Int) =
    println("The IntArray is ${array.toList()}, the size of window is $n, the all max values are: ${array.findAllLargestNumbers(n).toList()}")

/**
 * Questions 59-2: Implementing a queue that contain a max() function could find the max value, and the time complexities of function max, pop, push are O(1)
 * Answer: Refer to implementation of Questions 59-1
 */
