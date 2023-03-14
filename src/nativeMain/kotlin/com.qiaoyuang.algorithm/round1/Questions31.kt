package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Stack

fun test31() {
    val stack = intArrayOf(1, 2, 3, 4, 5)
    printlnResult(stack, intArrayOf(4, 5, 3, 2, 1))
    printlnResult(stack, intArrayOf(4, 3, 5, 1, 2))
    printlnResult(stack, intArrayOf(4, 5, 3, 2, 1))
    printlnResult(stack, intArrayOf(3, 4, 5, 2, 1))
    printlnResult(stack, intArrayOf(2, 3, 4, 5, 1))
    printlnResult(stack, intArrayOf(4, 3, 1, 2, 5))
}

/**
 * Give a stack entering sequence, judge a sequence whether is a stack exiting sequence
 */
private fun judgeArrayIsStackSequence(stack: IntArray, sequence: IntArray): Boolean {
    if (sequence.size > stack.size)
        return false
    var stackPoint = 0
    var sequencePoint = 0
    val realStack = Stack<Int>()
    while (sequencePoint < sequence.size) {
        if (!realStack.isEmpty) {
            if (realStack.top() == sequence[sequencePoint]) {
                realStack.pop()
                sequencePoint++
            } else if (stackPoint < stack.size)
                realStack.push(stack[stackPoint++])
            else
                return false
        } else {
            if (stack[stackPoint] == sequence[stackPoint]) {
                stackPoint++
                sequencePoint++
            } else if (stackPoint < stack.size)
                realStack.push(stack[stackPoint++])
            else
                return false
        }
    }
    return true
}

private fun printlnResult(stack: IntArray, sequence: IntArray) =
    println("A stack entering sequence is: ${stack.toList()}, whether the ${sequence.toList()} is it's stack exiting sequence: ${judgeArrayIsStackSequence(stack, sequence)}")