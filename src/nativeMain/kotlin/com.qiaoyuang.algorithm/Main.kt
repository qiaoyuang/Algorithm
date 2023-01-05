package com.qiaoyuang.algorithm

import com.qiaoyuang.algorithm.round1.test3
import com.qiaoyuang.algorithm.round1.test4
import com.qiaoyuang.algorithm.round1.test5
import com.qiaoyuang.algorithm.round1.test6

fun main() {
    printlnQuestionsTitle(3, ::test3)
    printlnQuestionsTitle(4, ::test4)
    printlnQuestionsTitle(5, ::test5)
    printlnQuestionsTitle(6, ::test6)
}

private inline fun printlnQuestionsTitle(index: Int, test: () -> Unit) {
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Questions$index test ~~~~~~~~~~~~~~~~~~~~~~~~~~")
    test()
}