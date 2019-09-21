package com.qiaoyuang.algorithm

interface AbstractStack<T> : Collection<T> {

    fun push(t: T)

    fun pop(): T

}