package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test21() {
    printlnResult(publicLinkedList(), 1)
    printlnResult2(publicLinkedList(), 1)
    println("-----------------------------------")
    printlnResult(publicLinkedList(), 3)
    printlnResult2(publicLinkedList(), 3)
    println("-----------------------------------")
    printlnResult(publicLinkedList(), 5)
    printlnResult2(publicLinkedList(), 5)
    println("-----------------------------------")
    printlnResult(publicLinkedList(), 10)
    printlnResult2(publicLinkedList(), 9)
}

/**
 * Questions 21: Delete kth node from the last in a linked list, the length of the linked list is n,
 * 1 <= k <= n, only allow to iterate the linked list once.
 */
private infix fun <T> SingleDirectionNode<T>.deleteFromLast(k: Int): SingleDirectionNode<T>? {
    val n = delete(k)
    require(k <= n) { "The k must equals or less than the count of linked list" }
    return if (n == k) next else this
}

private fun <T> SingleDirectionNode<T>.delete(k: Int): Int =
    next?.delete(k)?.let {
        if (it - 1 == k)
            next = next?.next
        it + 1
    } ?: 1

private infix fun <T> SingleDirectionNode<T>.deleteFromLast2(k: Int): SingleDirectionNode<T>? {
    var pointer1: SingleDirectionNode<T>? = this
    repeat(k) {
        pointer1 = (pointer1 ?: throw IllegalArgumentException("The k must equals or less than the count of linked list")).next
    }
    var pointer2 = this
    var previousPointer2 = pointer2
    while (pointer1?.next != null) {
        pointer1 = pointer1?.next!!
        previousPointer2 = pointer2
        pointer2 = pointer2.next!!
    }
    return if (pointer2 === this) {
        pointer2.next
    } else {
        previousPointer2.next = pointer2.next
        this
    }
}

private fun <T> printlnResult(node: SingleDirectionNode<T>, k: Int) {
    println("The linked list is:")
    printlnLinkedList(node)
    println("Delete the ${k}th node from the last, we got:")
    printlnLinkedList(node deleteFromLast k)
}

private fun <T> printlnResult2(node: SingleDirectionNode<T>, k: Int) {
    println("The linked list is:")
    printlnLinkedList(node)
    println("Delete the ${k}th node from the last, we got:")
    printlnLinkedList(node deleteFromLast2 k)
}

fun publicLinkedList(): SingleDirectionNode<Int> {
    val root = SingleDirectionNode(1)
    var pointer: SingleDirectionNode<Int>? = root
    repeat(9) {
        pointer?.next = SingleDirectionNode(it + 2)
        pointer = pointer?.next
    }
    return root
}