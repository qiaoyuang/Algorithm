package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Stack

fun test6() {
    val node0 = SingleDirectionNode('a')
    var current = node0
    repeat(10) {
        val next = SingleDirectionNode((98 + it).toChar())
        current.next = next
        current = next
    }
    println("Input: abcdefghijk")
    node0.printLinkedListReverse1()
    println()
    println("Input: abcdefghijk")
    node0.printLinkedListReverse2()
    println()
    val node1 = SingleDirectionNode('A')
    println("Input: A")
    node1.printLinkedListReverse1()
    println()
    println("Input: A")
    node1.printLinkedListReverse2()
    println()
}

/**
 * Question6: Print linked list in reverse.
 */

private fun SingleDirectionNode<Char>.printLinkedListReverse1() {
    next?.printLinkedListReverse1()
    print(element)
}

private fun SingleDirectionNode<Char>.printLinkedListReverse2() {
    val stack = Stack<Char>()
    var current: SingleDirectionNode<Char>? = this
    while (current != null) {
        stack.push(current.element)
        current = current.next
    }
    while (!stack.isEmpty) {
        print(stack.pop())
    }
}