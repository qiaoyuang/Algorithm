package com.qiaoyuang.algorithm.round0

interface AbstractStack<T> : Collection<T> {

    fun push(t: T)

    fun pop(): T

    fun top(): T
}