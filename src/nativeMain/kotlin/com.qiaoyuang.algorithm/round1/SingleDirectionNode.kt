package com.qiaoyuang.algorithm.round1

data class SingleDirectionNode<T>(
    var element: T, // Used for some special algorithms those need to change node's value.
    var next: SingleDirectionNode<T>? = null,
)