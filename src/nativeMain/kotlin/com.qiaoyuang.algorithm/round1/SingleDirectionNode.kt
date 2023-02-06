package com.qiaoyuang.algorithm.round1

data class SingleDirectionNode<T>(
    val element: T,
    var next: SingleDirectionNode<T>? = null,
)