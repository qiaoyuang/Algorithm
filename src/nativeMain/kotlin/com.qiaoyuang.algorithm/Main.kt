package com.qiaoyuang.algorithm

import com.qiaoyuang.algorithm.round1.*

fun main() {
    printlnQuestionsTitle(3, ::test3)
    printlnQuestionsTitle(4, ::test4)
    printlnQuestionsTitle(5, ::test5)
    printlnQuestionsTitle(6, ::test6)
    printlnQuestionsTitle(9, ::test9)
}

private inline fun printlnQuestionsTitle(index: Int, test: () -> Unit) {
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Questions$index test ~~~~~~~~~~~~~~~~~~~~~~~~~~")
    test()
}