package com.qiaoyuang.algorithm

interface AbstractQueue<T> : Collection<T> {

    fun enqueue(t: T)

    fun dequeue(): T

}