package com.qiaoyuang.algorithm

data class Node<T>(var t: T? = null,
                   var front: Node<T>? = null,
                   var next: Node<T>? = null)
