package com.qiaoyuang.algorithm.special

fun test28() {
    printlnResult(linkedListWithSub())
}

/**
 * Questions 28: Flat a linked list that with sub-linked list
 */
private data class NodeWithSub<T>(
    var element: T? = null,
    var front: NodeWithSub<T>? = null,
    var next: NodeWithSub<T>? = null,
    var sub: NodeWithSub<T>? = null,
) {

    fun flat(): NodeWithSub<T> {
        realFlat(this)
        return this
    }

    private fun realFlat(head: NodeWithSub<T>): NodeWithSub<T> {
        var pointer = head
        while (pointer.next != null) {
            pointer.sub?.let {
                val subEnd = realFlat(it)
                val originNext = pointer.next!!
                pointer.next = it
                it.front = pointer
                subEnd.next = originNext
                originNext.front = subEnd
                pointer = originNext
            } ?: kotlin.run {
                pointer = pointer.next!!
            }
        }
        return pointer
    }

    override fun toString(): String = buildString {
        var pointer = this@NodeWithSub
        while (pointer.next != null) {
            append(pointer.element)
            append(", ")
            pointer = pointer.next!!
        }
        append(pointer.element)
        append(';')
    }
}

private fun printlnResult(head: NodeWithSub<Int>) {
    print("Flatted this linked list, we can get: ")
    println(head.flat())
}

private fun linkedListWithSub(): NodeWithSub<Int> {
    val node1 = NodeWithSub(1)
    val node2 = NodeWithSub(2)
    val node3 = NodeWithSub(3)
    val node4 = NodeWithSub(4)
    val node5 = NodeWithSub(5)
    val node6 = NodeWithSub(6)
    val node7 = NodeWithSub(7)
    val node8 = NodeWithSub(8)
    val node9 = NodeWithSub(9)
    val node10 = NodeWithSub(10)
    val node11 = NodeWithSub(11)
    val node12 = NodeWithSub(12)

    node1.next = node2
    node2.front = node1
    node2.next = node3
    node3.front = node2
    node3.next = node4
    node4.front = node3

    node5.next = node6
    node6.front = node5
    node6.next = node7
    node7.front = node6

    node8.next = node9
    node9.front = node8

    node10.next = node11
    node11.front = node10
    node11.next = node12
    node12.front = node11

    node2.sub = node5
    node3.sub = node10
    node6.sub = node8

    return node1
}