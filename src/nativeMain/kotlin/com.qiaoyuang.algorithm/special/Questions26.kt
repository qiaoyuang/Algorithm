package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack
import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test26() {
    printlnResult(publicLinkedList())
    printlnResult(SingleDirectionNode(element = 1))
    printlnResult(SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 2)))
    printlnResult(SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 2, next = SingleDirectionNode(element = 3))))
    printlnResult(SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 2, next = SingleDirectionNode(element = 3, next = SingleDirectionNode(element = 4)))))
}

/**
 * Questions 26: Reorder List, LeetCode 143
 */
private fun <T> SingleDirectionNode<T>.rearrange(): SingleDirectionNode<T> {
    var pointer = this
    val stack = Stack<SingleDirectionNode<T>>()
    while (pointer.next != null) {
        stack.push(pointer)
        pointer = pointer.next!!
    }
    stack.push(pointer)
    pointer = this
    repeat(stack.size / 2) {
        val nextPointer = pointer.next!!
        pointer.next = stack.pop()
        pointer.next?.next = nextPointer
        pointer = nextPointer
    }
    pointer.next = null
    return this
}

private fun printlnResult(head: SingleDirectionNode<Int>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    print("Rearrange it: ")
    printlnLinkedList(head.rearrange())
}