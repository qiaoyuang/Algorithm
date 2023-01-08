package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Queue
import com.qiaoyuang.algorithm.round0.Stack

fun test9() {
    val stack = TwoQueuesStack<Int>()
    val queue = TwoStacksQueue<Int>()
    repeat(10) {
        stack.push(it)
        queue.enqueue(it)
    }
    println("Stack input: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]")
    repeat(3) {
        stack.pop()
    }
    repeat(3) {
        stack.push(7 + it)
    }
    print("Stack output: ")
    while (!stack.isEmpty)
        print(stack.pop())
    println()
    println("Queue input: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]")
    print("Queue output: ")
    while (!queue.isEmpty)
        print(queue.dequeue())
    println()
}

/**
 * Questions9-1: Use two queues to implement a stack.
 */

private class TwoQueuesStack<T> {

    private val queue1 = Queue<T>()
    private val queue2 = Queue<T>()

    fun push(t: T) {
        val queue = if (queue2.isEmpty) queue1 else queue2
        queue.enqueue(t)
    }

    fun pop(): T {
        val (queue, emptyQueue) = when {
            !queue1.isEmpty && queue2.isEmpty -> queue1 to queue2
            !queue2.isEmpty && queue1.isEmpty -> queue2 to queue1
            queue1.isEmpty && queue2.isEmpty -> throw IllegalStateException("The stack is empty")
            else -> throw IllegalStateException("Stack state exception")
        }

        while (queue.size != 1)
            emptyQueue.enqueue(queue.dequeue())

        return queue.dequeue()
    }

    val isEmpty: Boolean
        get() = queue1.isEmpty && queue2.isEmpty
}

/**
 * Questions9-1: Use two stacks to implement a queue.
 */

private class TwoStacksQueue<T> {

    private val stack1 = Stack<T>()
    private val stack2 = Stack<T>()

    fun enqueue(t: T) {
        while (!stack2.isEmpty)
            stack1.push(stack2.pop())
        stack1.push(t)
    }

    fun dequeue(): T = when {
        !stack2.isEmpty -> stack2.pop()
        stack1.isEmpty -> throw IllegalStateException("The queue is empty")
        else -> {
            while (stack1.size != 1)
                stack2.push(stack1.pop())
            stack1.pop()
        }
    }

    val isEmpty: Boolean
        get() = stack1.isEmpty && stack2.isEmpty
}