package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test78() {
    printlnResult(listOf(
        SingleDirectionNode(element = 1, next = SingleDirectionNode(element = 4, next = SingleDirectionNode(element = 7))),
        SingleDirectionNode(element = 2, next = SingleDirectionNode(element = 5, next = SingleDirectionNode(element = 8))),
        SingleDirectionNode(element = 3, next = SingleDirectionNode(element = 6, next = SingleDirectionNode(element = 9))),
    ))
}

/**
 * Questions 78: Merge multiple sorted linked lists
 */
private fun <T : Comparable<T>> List<SingleDirectionNode<T>>.merge(): SingleDirectionNode<T> =
    merge(0, lastIndex)

private fun <T : Comparable<T>> List<SingleDirectionNode<T>>.merge(start: Int, end: Int): SingleDirectionNode<T> {
    if (start == end)
        return this[start]
    val mid = (start + end) shr 1
    return merge(merge(start, mid), merge(mid + 1, end))
}

private fun printlnResult(headList: List<SingleDirectionNode<Int>>) {
    println("Merge these lists: ")
    headList.forEach {
        printlnLinkedList(it)
    }
    print("We can get: ")
    printlnLinkedList(headList.merge())
}