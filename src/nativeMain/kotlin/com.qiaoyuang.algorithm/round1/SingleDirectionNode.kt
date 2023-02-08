package com.qiaoyuang.algorithm.round1

data class SingleDirectionNode<T>(
    val element: T,
    var next: SingleDirectionNode<T>? = null,
)

fun <T> printlnLinkedList(node: SingleDirectionNode<T>?) {
    if (node == null) {
        println("empty")
        return
    }
    var _node = node
    while (_node != null) {
        print(_node.element)
        _node = _node.next
        if (_node != null)
            print(", ")
    }
    println(';')
}