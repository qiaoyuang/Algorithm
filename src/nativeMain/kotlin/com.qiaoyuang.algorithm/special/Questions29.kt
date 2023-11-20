package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode

fun test29() {
    val node1 = SingleDirectionNode(element = 1)
    node1.next = node1
    printlnResult(node1, 2)
    val node2 = SingleDirectionNode(element = 2)
    node2.next = node2
    printlnResult(node2, 1)
    printlnResult(linkedList(), 8)
}

/**
 * Questions 29: Insert a node to a sorted circle linked list
 */
private infix fun <T : Comparable<T>> SingleDirectionNode<T>.insert(value: T): SingleDirectionNode<T> {
    var pointer = this
    do {
        if (pointer.element <= value && pointer.next!!.element > value)
            break
        else
            pointer = pointer.next!!
    } while (pointer.next !== this)
    val newNode = SingleDirectionNode(value, pointer.next)
    pointer.next = newNode
    return if (value <= element) newNode else this
}

private fun printlnResult(node: SingleDirectionNode<Int>, num: Int) {
    print("Insert the $num to linked list: ")
    printlnCircleLinkedList(node)
    print("We got: ")
    printlnCircleLinkedList(node insert num)
}

private fun <T> printlnCircleLinkedList(node: SingleDirectionNode<T>?) {
    if (node == null) {
        println("empty")
        return
    }
    var _node = node
    do {
        print(_node!!.element)
        _node = _node.next
        if (_node !== node)
            print(", ")
    } while (_node !== node)
    println(';')
}

private fun linkedList(): SingleDirectionNode<Int> {
    val head = SingleDirectionNode(element = 1)
    head.next =
        SingleDirectionNode(element = 2, next =
        SingleDirectionNode(element = 3, next =
        SingleDirectionNode(element = 4, next =
        SingleDirectionNode(element = 5, next =
        SingleDirectionNode(element = 6, next =
        SingleDirectionNode(element = 7, next =
        SingleDirectionNode(element = 9, next =
        SingleDirectionNode(element = 10, next =
        SingleDirectionNode(element = 11, next =
        SingleDirectionNode(element = 12, head))))))))))
    return head
}
