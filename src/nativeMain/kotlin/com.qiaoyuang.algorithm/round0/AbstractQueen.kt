package com.qiaoyuang.algorithm.round0

interface AbstractQueue<T> : Collection<T> {

    fun enqueue(t: T)

    fun dequeue(): T

}