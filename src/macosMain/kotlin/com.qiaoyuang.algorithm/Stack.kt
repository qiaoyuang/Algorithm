package com.qiaoyuang.algorithm

open class Stack<T>(private val list: LinkedList<T> = LinkedList()) : AbstractStack<T> by list