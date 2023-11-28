package com.qiaoyuang.algorithm.round0

interface Collection<T> {

    val isEmpty: Boolean
    val isNotEmpty: Boolean
        get() = !isEmpty

    val size: Int

    val first: T
    val last: T

}