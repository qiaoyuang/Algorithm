package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test24() {
    printlnResult(linkedList())
    printlnResult(SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 2)))
}

/**
 * Questions 24: Reverse a linked list
 */
fun <T> SingleDirectionNode<T>.reverse(): SingleDirectionNode<T> {
    if (next == null)
        return this
    var pointer1 = this
    var pointer2 = next!!
    pointer1.next = null
    while (pointer2.next != null) {
        val temp = pointer2.next
        pointer2.next = pointer1
        pointer1 = pointer2
        pointer2 = temp!!
    }
    pointer2.next = pointer1
    return pointer2
}

private fun linkedList(): SingleDirectionNode<Int> {
    val root = SingleDirectionNode(1)
    var pointer: SingleDirectionNode<Int>? = root
    repeat(9) {
        pointer?.next = SingleDirectionNode(it + 2)
        pointer = pointer?.next
    }
    return root
}

private fun printlnResult(head: SingleDirectionNode<Int>) {
    println("The linked list is:")
    printlnLinkedList(head)
    println("Reverse the linked list:")
    printlnLinkedList(head.reverse())
    println("-----------------------------------")
}