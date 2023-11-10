package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test25() {
    printlnResult(
        head1 = SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 2, next = SingleDirectionNode(element = 3))),
        head2 = SingleDirectionNode(element = 5, next = SingleDirectionNode(element = 3, next = SingleDirectionNode(element = 1))),
    )
    printlnResult(
        head1 = SingleDirectionNode(element = 9, next = SingleDirectionNode(element = 8, next = SingleDirectionNode(element = 4))),
        head2 = SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 8)),
    )
}

/**
 * Questions 25: The addition of two linked lists
 */
private operator fun SingleDirectionNode<Int>.plus(target: SingleDirectionNode<Int>): SingleDirectionNode<Int> {
    var head1: SingleDirectionNode<Int>? = reverse()
    var head2: SingleDirectionNode<Int>? = target.reverse()
    var pointer: SingleDirectionNode<Int>? = null
    var extra = 0
    val range = 0..9
    while (head1 != null || head2 != null || extra != 0) {
        if (head1 != null)
            require(head1.element in range) { "The parameters are illegal" }
        if (head2 != null)
            require(head2.element in range) { "The parameters are illegal" }
        var sum = (head1?.element ?: 0) + (head2?.element ?: 0) + extra
        if (sum > 9) {
            extra = sum / 10
            sum %= 10
        } else {
            extra = 0
        }
        val temp = SingleDirectionNode(sum)
        temp.next = pointer
        pointer = temp
        head1 = head1?.next
        head2 = head2?.next
    }
    return pointer!!
}

private fun printlnResult(head1: SingleDirectionNode<Int>, head2: SingleDirectionNode<Int>) {
    print("The linked list: ")
    printlnLinkedList(head1)
    print("add the linked list: ")
    printlnLinkedList(head2)
    print("The result is: ")
    printlnLinkedList(head1 + head2)
}