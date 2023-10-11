package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.Stack

fun test52() {
    val (header1, header2) = testData1()
    printlnResult(header1, header2)
}

private fun <T> findFirstPublicNode(header1: SingleDirectionNode<T>, header2: SingleDirectionNode<T>): SingleDirectionNode<T> {
    val findNode1 = FindNode(header1)
    findNode1.enterStack()
    val findNode2 = FindNode(header2)
    findNode2.enterStack()
    var node1 = findNode1.pop()
    var node2 = findNode2.pop()
    if (node1 !== node2)
        throw IllegalArgumentException("These two linked list don't have public node")
    var publicNode = node1
    while (node1 === node2) {
        publicNode = node1
        node1 = findNode1.pop()
        node2 = findNode2.pop()
    }
    return publicNode
}

private class FindNode<T>(private val header: SingleDirectionNode<T>) {

    private val stack = Stack<SingleDirectionNode<T>>()

    fun enterStack() {
        var pointer: SingleDirectionNode<T>? = header
        while (pointer != null) {
            stack.push(pointer)
            pointer = pointer.next
        }
    }

    fun pop(): SingleDirectionNode<T> = stack.pop()
}

private fun testData1(): Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>> {
    val header1 = SingleDirectionNode(1)
    val header2 = SingleDirectionNode(4)

    var pointer1 = header1
    pointer1.next = SingleDirectionNode(2)
    pointer1 = pointer1.next!!
    pointer1.next = SingleDirectionNode(3)
    pointer1 = pointer1.next!!
    val firstPublicNode = SingleDirectionNode(6)
    pointer1.next = firstPublicNode
    pointer1 = pointer1.next!!
    pointer1.next = SingleDirectionNode(7)

    var pointer2 = header2
    pointer2.next = SingleDirectionNode(5)
    pointer2 = pointer2.next!!
    pointer2.next = firstPublicNode
    return header1 to header2
}

private fun <T> printlnResult(header1: SingleDirectionNode<T>, header2: SingleDirectionNode<T>) {
    println("The two linked list:")
    printlnLinkedList(header1)
    printlnLinkedList(header2)
    println("The first public node is: ${findFirstPublicNode(header1, header2).element}")
}
