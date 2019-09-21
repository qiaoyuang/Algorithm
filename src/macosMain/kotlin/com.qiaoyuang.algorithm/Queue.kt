package com.qiaoyuang.algorithm

open class Queue<T>(private val list: LinkedList<T> = LinkedList()) : AbstractQueue<T> by list