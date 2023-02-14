package com.qiaoyuang.algorithm.round1

fun test25() {
    printlnResult(testCase1())
    printlnResult(testCase2())
    printlnResult(testCase3())
}

/**
 * Questions25: Merge two linked lists be sorted those have benn sorted
 */
private fun <T : Comparable<T>> mergeTwoMergedLinkedList(head1: SingleDirectionNode<T>, head2: SingleDirectionNode<T>): SingleDirectionNode<T> {
    var current1: SingleDirectionNode<T>? = head1
    var current2: SingleDirectionNode<T>? = head2
    val head = if (head1.element <= head2.element) {
        current1 = current1?.next
        head1
    } else {
        current2 = current2?.next
        head2
    }
    var current = head
    while (current1 != null || current2 != null) {
        when {
            current1 == null -> {
                current.next = current2!!
                current = current2
                current2 = current2.next
            }
            current2 == null -> {
                current.next = current1
                current = current1
                current1 = current1.next
            }
            else -> if (current1.element <= current2.element) {
                current.next = current1
                current = current1
                current1 = current1.next
            } else {
                current.next = current2
                current = current2
                current2 = current2.next
            }
        }
    }
    return head
}

private fun testCase1(): Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>> {
    val node0 = SingleDirectionNode(0)
    val node1 = SingleDirectionNode(1)
    val node2 = SingleDirectionNode(2)
    val node3 = SingleDirectionNode(3)
    val node4 = SingleDirectionNode(4)
    val node5 = SingleDirectionNode(5)
    val node6 = SingleDirectionNode(6)
    val node7 = SingleDirectionNode(7)
    val node8 = SingleDirectionNode(8)
    val node9 = SingleDirectionNode(9)
    node0.next = node2
    node2.next = node4
    node4.next = node6
    node6.next = node8
    node1.next = node3
    node3.next = node5
    node5.next = node7
    node7.next = node9
    return node0 to node1
}

private fun testCase2(): Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>> {
    val node0 = SingleDirectionNode(0)
    val node1 = SingleDirectionNode(1)
    val node2 = SingleDirectionNode(2)
    val node3 = SingleDirectionNode(3)
    val node4 = SingleDirectionNode(4)
    val node5 = SingleDirectionNode(5)
    val node6 = SingleDirectionNode(6)
    val node7 = SingleDirectionNode(7)
    val node8 = SingleDirectionNode(8)
    val node9 = SingleDirectionNode(9)
    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node7.next = node8
    node8.next = node9
    return node0 to node7
}

private fun testCase3(): Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>> {
    val node0 = SingleDirectionNode(0)
    val node1 = SingleDirectionNode(1)
    val node2 = SingleDirectionNode(2)
    val node3 = SingleDirectionNode(3)
    val node4 = SingleDirectionNode(4)
    val node5 = SingleDirectionNode(5)
    val node6 = SingleDirectionNode(6)
    val node7 = SingleDirectionNode(7)
    val node8 = SingleDirectionNode(8)
    val node9 = SingleDirectionNode(9)
    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node8
    node8.next = node9
    return node7 to node0
}

private fun printlnResult(pair: Pair<SingleDirectionNode<Int>, SingleDirectionNode<Int>>) {
    val (head1, head2) = pair
    print("The linked list 1 is: ")
    printlnLinkedList(head1)
    print("The linked list 2 is: ")
    printlnLinkedList(head2)
    print("After the merger: ")
    val head = mergeTwoMergedLinkedList(head1, head2)
    printlnLinkedList(head)
}