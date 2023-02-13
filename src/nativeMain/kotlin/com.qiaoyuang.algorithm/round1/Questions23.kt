package com.qiaoyuang.algorithm.round1

fun test23() {
    val node6 = SingleDirectionNode(6)
    val node5 = SingleDirectionNode(5, node6)
    val node4 = SingleDirectionNode(4, node5)
    val node3 = SingleDirectionNode(3, node4)
    val node2 = SingleDirectionNode(2, node3)
    val node1 = SingleDirectionNode(1, node2)
    node6.next = node3
    println("The entry node is: ${node1.findCircleEntryNodeInLinkedList().element}")
}

/**
 * Questions23: Find the circle's entry node in a linked list
 */
private fun <T : Comparable<T>> SingleDirectionNode<T>.findCircleEntryNodeInLinkedList(): SingleDirectionNode<T> {
    if (next == null)
        throw IllegalArgumentException("The linked list doesn't have circle")
    var firstPtr = next!!
    var secondPtr = next!!.next
    while (firstPtr !== secondPtr) {
        firstPtr = firstPtr.next!!
        secondPtr = secondPtr?.next?.next
        if (secondPtr == null)
            throw IllegalArgumentException("The linked list doesn't have circle")
    }
    var circleNodeCount = 1
    secondPtr = secondPtr.next!!
    while (secondPtr !== firstPtr) {
        secondPtr = secondPtr!!.next
        circleNodeCount++
    }
    firstPtr = this
    secondPtr = this
    repeat(circleNodeCount) {
        secondPtr = secondPtr!!.next
    }
    while (firstPtr !== secondPtr) {
        firstPtr = firstPtr.next!!
        secondPtr = secondPtr!!.next!!
    }
    return firstPtr
}