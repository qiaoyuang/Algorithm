package com.qiaoyuang.algorithm

interface Collection<T> {

    val isEmpty: Boolean
    val size: Int

    val first: T
    val last: T

}