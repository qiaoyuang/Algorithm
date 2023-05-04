package com.qiaoyuang.algorithm.round0

open class Stack<T>(val list: LinkedList<T> = LinkedList()) : AbstractStack<T> by list {
    inline fun forEach(block: (T) -> Unit) = list.forEach(block)
}

fun Stack<Int>.toIntArray(): IntArray = IntArray(size) { list[it] }