package com.qiaoyuang.algorithm.round1

fun test22() {
    val head = SingleDirectionNode(0u)
    var current = head
    repeat(9) {
        val next = SingleDirectionNode(it.toUInt() + 1u)
        current.next = next
        current = next
    }
    printlnResult1(8u, head)
    printlnResult1(3u, head)
    printlnResult1(1u, head)
    printlnResult1(0u, head)
    printlnResult1(15u, head)
    printlnResult2(head)
    val head1 = SingleDirectionNode(0u)
    current = head1
    repeat(8) {
        val next = SingleDirectionNode(it.toUInt() + 1u)
        current.next = next
        current = next
    }
    printlnResult2(head1)
}

/**
 * Questions22-1: Find the reciprocal k node in a Linked List, the reciprocal starts from 1
 */
private infix fun <T : Comparable<T>> SingleDirectionNode<T>.findReciprocalNodeInLinkedList(k: UInt): SingleDirectionNode<T> {
    if (k == 0u)
        throw IllegalArgumentException("The k must greater than 0")
    val (node, _) = findTheReciprocalAndIndex(k)
    return node ?: throw IllegalArgumentException("The k greater than count of the Linked List")
}

private infix fun <T : Comparable<T>> SingleDirectionNode<T>.findTheReciprocalAndIndex(k: UInt): Pair<SingleDirectionNode<T>?, UInt> {
    val pair = next?.findTheReciprocalAndIndex(k) ?: return (if (k == 1u) this else null) to 1u
    val (node, index) = pair
    val myIndex = index + 1u
    return when {
        myIndex == k -> this to k
        node != null -> pair
        else -> null to myIndex
    }
}

private fun printlnResult1(k: UInt, head: SingleDirectionNode<UInt>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    try {
        println("The reciprocal No.$k node is: ${(head findReciprocalNodeInLinkedList k).element}")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * Questions22-2: Return the Linked List's middle node,
 * if the count of the Linked List is odd number, return the middle, else return the anyone of the two middle nodes
 */
private fun <T> SingleDirectionNode<T>.findTheMiddleNode(): SingleDirectionNode<T> {
    var middle = this
    var end = this
    while (end.next != null) {
        end = end.next!!.next ?: break
        middle = middle.next!!
    }
    return middle
}

private fun printlnResult2(head: SingleDirectionNode<UInt>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    println("The middle node is: ${head.findTheMiddleNode().element}")
}