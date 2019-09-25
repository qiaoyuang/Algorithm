package com.qiaoyuang.algorithm

class LinkedList<T> : AbstractStack<T>, AbstractQueue<T>, Iterable<T> {

    private var top: Node<T>? = null
    private var tail: Node<T>? = null

    override val first: T
        get() = top?.t ?: throw IllegalStateException("当前没有可用元素")

    override val last: T
        get() = tail?.t ?: throw IllegalStateException("当前没有可用元素")

    override var size = 0
        private set

    override val isEmpty: Boolean
        get() = size == 0

    override fun push(t: T) {
        val newTop = Node(t)
        newTop.next = top
        top?.front = newTop
        top = newTop
        if (isEmpty) tail = top
        size++
    }

    fun offer(t: T) {
        val newTail = Node(t)
        newTail.front = tail
        tail?.next = newTail
        tail = newTail
        if (isEmpty) top = tail
        size++
    }

    override fun pop(): T {
        check(!isEmpty) { "已经没有元素可以弹出" }
        val t = top!!.t
        top = top!!.next
        top?.front = null
        size--
        if (isEmpty) tail = null
        return t!!
    }

    override fun enqueue(t: T) = push(t)

    override fun dequeue(): T {
        check(!isEmpty) { "已经没有元素可以弹出" }
        val t = tail!!.t
        tail = tail!!.front
        tail?.next = null
        size--
        if (isEmpty) top = null
        return t!!
    }

    override fun iterator(): Iterator<T> = object : Iterator<T> {

        private var pointer = top

        override fun hasNext(): Boolean = pointer?.next != null

        override fun next(): T {
            val t = pointer?.t
            pointer = pointer?.next
            return t ?: throw IllegalStateException("集合为空")
        }
    }

    operator fun get(index: Int): T {
        var pointer = top
        repeat(index) {
            pointer = pointer?.next
        }
        return pointer?.t ?: throw IndexOutOfBoundsException("获取的下标越界")
    }

}