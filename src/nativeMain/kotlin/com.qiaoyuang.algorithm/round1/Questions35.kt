package com.qiaoyuang.algorithm.round1

fun test35() {
    printlnResult(testCast())
}

private data class SingleComplexNode<T>(
    val element: T,
    var next: SingleComplexNode<T>? = null,
    var sibling: SingleComplexNode<T>? = null,
) {
    infix fun isReplica(replica: SingleComplexNode<T>): Boolean {
        var pointer: SingleComplexNode<T>? = this
        var _pointer: SingleComplexNode<T>? = replica
        while (pointer != null || _pointer != null) {
            if (pointer?.element != _pointer?.element || pointer?.sibling?.element != _pointer?.sibling?.element) {
                return false
            }
            pointer = pointer?.next
            _pointer = _pointer?.next
        }
        return true
    }
}

private fun <T> copyComplexLinkedList(root: SingleComplexNode<T>): SingleComplexNode<T> {
    var pointer = root
    val newHead = SingleComplexNode(root.element)
    var _pointer = newHead
    val map = buildMap {
        this[pointer] = _pointer
        while (pointer.next != null) {
            val next = pointer.next!!
            val _next = SingleComplexNode(next.element)
            _pointer.next = _next
            _pointer = _next
            pointer = pointer.next!!
            this[pointer] = _pointer
        }
    }
    pointer = root
    _pointer = map[root]!!
    while (pointer.next != null) {
        _pointer.sibling = map[pointer.sibling]
        pointer = pointer.next!!
        _pointer = _pointer.next!!
    }
    _pointer.sibling = map[pointer.sibling]
    return newHead
}

private fun printlnResult(root: SingleComplexNode<Char>) {
    println("The origin linked list is:")
    var pointer: SingleComplexNode<Char>? = root
    while (pointer != null) {
        print(pointer.element)
        print(", ")
        pointer = pointer.next
    }
    println("\nThe copied origin linked list is:")
    val newRoot = copyComplexLinkedList(root)
    pointer = newRoot
    while (pointer != null) {
        print(pointer.element)
        print(", ")
        pointer = pointer.next
    }
    println("\n Are they same: ${root isReplica newRoot}")
}

private fun testCast(): SingleComplexNode<Char> {
    val a = SingleComplexNode('A')
    val b = SingleComplexNode('B')
    val c = SingleComplexNode('C')
    val d = SingleComplexNode('D')
    val e = SingleComplexNode('E')
    a.next = b
    a.sibling = c
    b.next = c
    b.sibling = e
    c.next = d
    d.next = e
    return a
}