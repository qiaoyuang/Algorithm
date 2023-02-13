package com.qiaoyuang.algorithm.round1

fun test24() {
    printlnResult1(produceIntegerLinkedList(9))
    printlnResult1(produceIntegerLinkedList(0))
    printlnResult2(produceIntegerLinkedList(9))
    printlnResult2(produceIntegerLinkedList(0))
}


/**
 * Questions24: Reverse the linked List, use loop and recursion two ways to implementation
 */


// Loop
private fun <T> SingleDirectionNode<T>.reverseLinedList(): SingleDirectionNode<T> {
    var pointer = this
    var next = pointer.next
    pointer.next = null
    while (next != null) {
        val temp = next.next
        next.next = pointer
        pointer = next
        next = temp
    }
    return pointer
}

// Recursion
private fun <T> SingleDirectionNode<T>.reverseLinedListRecursion(): SingleDirectionNode<T> =
    reverseLinedListRecursion(null, this)

private fun <T> reverseLinedListRecursion(pre: SingleDirectionNode<T>?, current: SingleDirectionNode<T>?): SingleDirectionNode<T> {
    val next = current?.next
    current?.next = pre
    return if (next == null && current != null)
        current
    else
        reverseLinedListRecursion(current, next)
}

private fun <T> printlnResult1(head: SingleDirectionNode<T>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    print("Use loop, be reversed linked list is: ")
    printlnLinkedList(head.reverseLinedList())
}

private fun <T> printlnResult2(head: SingleDirectionNode<T>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    print("Use recursion, be reversed linked list is: ")
    printlnLinkedList(head.reverseLinedListRecursion())
}

private fun produceIntegerLinkedList(count: Int): SingleDirectionNode<Int> {
    val head = SingleDirectionNode(0)
    var current = head
    repeat(count) {
        val node = SingleDirectionNode(it + 1)
        current.next = node
        current = node
    }
    return head
}