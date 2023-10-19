package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Stack

fun test30() {
    val elementsList = listOf(8, 6, 5, 9, 3, 7, 0, 4, 0, 1, 2)
    val minStack = StackMinElement<Int>().apply {
        elementsList.forEach {
            push(it)
        }
    }
    println("Push elements: $elementsList, the least element is: ${minStack.min()}")
    while (!minStack.isEmpty) {
        print("Pop top: ${minStack.pop()}, ")
        try {
            println("the least element is: ${minStack.min()}")
        } catch (e: Exception) {
            println("the stack is empty")
        }
    }
}

/**
 * Questions 30: The stack with the `min` function
 */
private class StackMinElement<T : Comparable<T>> {

    private val elementsStack = Stack<T>()
    private val minElementsStack = Stack<T>()

    fun top(): T = elementsStack.top()

    fun push(element: T) {
        elementsStack.push(element)
        if (minElementsStack.isEmpty || minElementsStack.top() >= element)
            minElementsStack.push(element)
    }

    fun pop(): T {
        val element = elementsStack.pop()
        if (element == minElementsStack.top())
            minElementsStack.pop()
        return element
    }

    fun min(): T = minElementsStack.top()

    val isEmpty: Boolean
        get() = elementsStack.isEmpty
}