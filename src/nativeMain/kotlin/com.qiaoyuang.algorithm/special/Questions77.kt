package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test77() {
    val head = SingleDirectionNode(element = 3, next = SingleDirectionNode(element = 5, next = SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 4, next = SingleDirectionNode(element = 2, next = SingleDirectionNode(element = 6))))))
    printlnResult(head)
}

/**
 * Questions 77: Input a head node of a linked list, please sort this linked list
 */
private fun SingleDirectionNode<Int>.sort(): SingleDirectionNode<Int> {
    if (next == null)
        return this
    val head1 = this
    val head2 = split()
    return merge(head1.sort(), head2.sort())
}

private fun SingleDirectionNode<Int>.split(): SingleDirectionNode<Int> {
    var pointer1: SingleDirectionNode<Int>? = this
    var pointer2: SingleDirectionNode<Int>? = this
    while (true) {
        val nextPointer2 = pointer2?.next?.next
        if (nextPointer2 != null) {
            pointer1 = pointer1!!.next
            pointer2 = nextPointer2
        } else
            break
    }
    val result = pointer1!!.next!!
    pointer1.next = null
    return result
}

fun <T : Comparable<T>> merge(head1: SingleDirectionNode<T>, head2: SingleDirectionNode<T>): SingleDirectionNode<T> {
    var pointer1: SingleDirectionNode<T>? = head1
    var pointer2: SingleDirectionNode<T>? = head2
    val head = if (head1.element < head2.element) {
        pointer1 = pointer1!!.next
        head1
    } else {
        pointer2 = pointer2!!.next
        head2
    }
    var pointer = head
    while (pointer1 != null || pointer2 != null) {
        when {
            pointer1 != null && pointer2 == null -> {
                pointer.next = pointer1
                break
            }
            pointer1 == null && pointer2 != null -> {
                pointer.next = pointer2
                break
            }
            pointer1 != null && pointer2 != null -> {
                pointer.next = if (pointer1.element < pointer2.element) {
                    val temp = pointer1
                    pointer1 = pointer1.next
                    temp
                } else {
                    val temp = pointer2
                    pointer2 = pointer2.next
                    temp
                }
                pointer = pointer.next!!
            }
        }
    }
    return head
}

private fun printlnResult(head: SingleDirectionNode<Int>) {
    print("Input lined list: ")
    printlnLinkedList(head)
    print("Sort it, we can get: ")
    printlnLinkedList(head.sort())
}