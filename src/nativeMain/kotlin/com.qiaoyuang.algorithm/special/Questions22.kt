package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode

fun test22() {
    printlnResult(linkedList())
}

/**
 * Questions 22: Linked List Cycle II, LeetCode 22
 */
private fun <T> SingleDirectionNode<T>.firstOfCircle(): SingleDirectionNode<T> {
    var pointer1 = next!!
    var pointer2 = next!!.next!!
    while (pointer1 !== pointer2) {
        pointer1 = pointer1.next!!
        pointer2 = pointer2.next!!.next!!
    }
    pointer1 = this
    while (pointer1 !== pointer2) {
        pointer1 = pointer1.next!!
        pointer2 = pointer2.next!!
    }
    return pointer1
}

private fun linkedList(): SingleDirectionNode<Int> {
    val root = SingleDirectionNode(1)
    var pointer: SingleDirectionNode<Int>? = root
    var pointer5: SingleDirectionNode<Int>? = null
    repeat(9) {
        pointer?.next = SingleDirectionNode(it + 2)
        pointer = pointer?.next
        if (it == 3)
            pointer5 = pointer
    }
    pointer?.next = pointer5
    return root
}

private fun printlnResult(head: SingleDirectionNode<Int>) =
    println("The first node of circle is ${head.firstOfCircle().element}")