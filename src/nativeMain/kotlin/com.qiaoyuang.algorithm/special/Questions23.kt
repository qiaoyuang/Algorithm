package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode

fun test23() {
    val (head1, head2) = linkedLists()
    printlnResult(head1, head2)
}

/**
 * Questions 23: Find the first public node of two linked lists
 */
private fun <T> findFirstPublicNode(
    head1: SingleDirectionNode<T>,
    head2: SingleDirectionNode<T>,
): SingleDirectionNode<T> {
    var k1 = 1
    var pointer1 = head1
    while (pointer1.next != null) {
        pointer1 = pointer1.next!!
        k1++
    }

    var k2 = 1
    var pointer2 = head2
    while (pointer2.next != null) {
        pointer2 = pointer2.next!!
        k2++
    }

    pointer1 = head1
    pointer2 = head2

    when {
        k1 > k2 -> repeat(k1 - k2) {
            pointer1 = pointer1.next!!
        }
        k1 < k2 -> repeat(k2 - k1) {
            pointer2 = pointer2.next!!
        }
    }

    while (pointer1 !== pointer2) {
        pointer1 = pointer1.next!!
        pointer2 = pointer2.next!!
    }

    return pointer1
}

private fun linkedLists(): Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>> {
    val public = SingleDirectionNode(
        element = 4,
        next = SingleDirectionNode(
            element = 5,
            next = SingleDirectionNode(element = 6),
            ),
        )
    val head1 = SingleDirectionNode(
        element = 1,
        next = SingleDirectionNode(
            element = 2,
            next = SingleDirectionNode(
                element = 3,
                next = public)
            )
        )
    val head2 = SingleDirectionNode(
        element = 7,
        next = SingleDirectionNode(
            element = 8,
            next = public,
        )
    )
    return head1 to head2
}

private fun printlnResult(head1: SingleDirectionNode<Int>, head2: SingleDirectionNode<Int>) =
    println("The first public node is ${findFirstPublicNode(head1, head2).element}")