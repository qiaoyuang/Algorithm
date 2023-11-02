package com.qiaoyuang.algorithm

import com.qiaoyuang.algorithm.round1.round1Main
import com.qiaoyuang.algorithm.special.specialMain

fun main() {
    // round1Main()
    specialMain()
}

inline fun printlnQuestionsTitle(index: Int, test: () -> Unit) {
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Questions $index test ~~~~~~~~~~~~~~~~~~~~~~~~~~")
    test()
}