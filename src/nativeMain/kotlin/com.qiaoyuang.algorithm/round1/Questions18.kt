package com.qiaoyuang.algorithm.round1

fun test18() {
    printlnResult1(5, noRepeatList())
    printlnResult2(noRepeatList())
    printlnResult1(8, justOneNode())
    printlnResult2(justOneNode())
    printlnResult1(0, allNodeSame())
    printlnResult2(allNodeSame())
    printlnResult1(1, someNodesSame())
    printlnResult2(someNodesSame())
    printlnResult1(4, moreNodesSame())
    printlnResult2(moreNodesSame())
}

/**
 * Questions 18-1: Delete a linked list's node and time complexity must be O(1)(That not include the time about search the node)
 */
private infix fun <T : Comparable<T>> SingleDirectionNode<T>.deleteNode(target: T): SingleDirectionNode<T>? {
    var current: SingleDirectionNode<T>? = this
    while (current?.next != null) {
        if (current.next!!.element == target)
            current.next = current.next!!.next
        else
            current = current.next
    }
    return if (element == target) next else this
}

private fun printlnResult1(num: Int, head: SingleDirectionNode<Int>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    print("After deleted $num: ")
    printlnLinkedList(head deleteNode num)
}

/**
 * Questions 18-2: Delete all repeated nodes in a linked list
 */
private fun <T : Comparable<T>> SingleDirectionNode<T>.deleteRepeatedNodes(): SingleDirectionNode<T>? {
    var head: SingleDirectionNode<T>? = this
    var outer: SingleDirectionNode<T>? = this
    var preOuter: SingleDirectionNode<T>? = null

    while (outer != null) {
        var isHasRepeated = false
        var pointed = outer.next
        var prePointed = outer
        while (pointed != null) {
            if (pointed.element == outer.element) {
                prePointed?.next = pointed.next
                isHasRepeated = true
            } else
                prePointed = pointed
            pointed = pointed.next
        }

        when {
            !isHasRepeated -> preOuter = outer
            preOuter == null -> head = outer.next
            else -> preOuter.next = outer.next
        }

        outer = outer.next
    }
    return head
}

private fun printlnResult2(head: SingleDirectionNode<Int>) {
    print("The linked list is: ")
    printlnLinkedList(head)
    print("After deleted repeated nodes: ")
    printlnLinkedList(head.deleteRepeatedNodes())
}

/**
 * Test cases
 */
private fun noRepeatList(): SingleDirectionNode<Int> {
    val node = SingleDirectionNode(0)
    var temp = node
    repeat(10) {
        val newNode = SingleDirectionNode(it + 1)
        temp.next = newNode
        temp = newNode
    }
    return node
}

private fun justOneNode(): SingleDirectionNode<Int> =
    SingleDirectionNode(8)

private fun allNodeSame(): SingleDirectionNode<Int> {
    val node = SingleDirectionNode(0)
    var temp = node
    repeat(5) {
        val newNode = SingleDirectionNode(0)
        temp.next = newNode
        temp = newNode
    }
    return node
}

private fun someNodesSame(): SingleDirectionNode<Int> {
    val node0 = SingleDirectionNode(0)
    val node1 = SingleDirectionNode(1)
    val node2 = SingleDirectionNode(1)
    val node3 = SingleDirectionNode(2)
    val node4 = SingleDirectionNode(3)
    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    return node0
}

private fun moreNodesSame(): SingleDirectionNode<Int> {
    val node0 = SingleDirectionNode(0)
    val node1 = SingleDirectionNode(1)
    val node2 = SingleDirectionNode(1)
    val node3 = SingleDirectionNode(2)
    val node4 = SingleDirectionNode(3)
    val node5 = SingleDirectionNode(4)
    val node6 = SingleDirectionNode(4)
    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    return node0
}