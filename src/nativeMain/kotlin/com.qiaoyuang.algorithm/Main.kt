package com.qiaoyuang.algorithm

import com.qiaoyuang.algorithm.round1.*

fun main() {
    printlnQuestionsTitle(3, ::test3)
    printlnQuestionsTitle(4, ::test4)
    printlnQuestionsTitle(5, ::test5)
    printlnQuestionsTitle(6, ::test6)
    printlnQuestionsTitle(7, ::test7)
    printlnQuestionsTitle(8, ::test8)
    printlnQuestionsTitle(9, ::test9)
    printlnQuestionsTitle(10, ::test10)
    printlnQuestionsTitle(11, ::test11)
    printlnQuestionsTitle(14, ::test14)
    printlnQuestionsTitle(15, ::test15)
    printlnQuestionsTitle(16, ::test16)
    printlnQuestionsTitle(17, ::test17)
    printlnQuestionsTitle(18, ::test18)
    printlnQuestionsTitle(19, ::test19)
    printlnQuestionsTitle(20, ::test20)
    printlnQuestionsTitle(21, ::test21)
    printlnQuestionsTitle(22, ::test22)
    printlnQuestionsTitle(23, ::test23)
    printlnQuestionsTitle(24, ::test24)
    printlnQuestionsTitle(25, ::test25)
    printlnQuestionsTitle(26, ::test26)
    printlnQuestionsTitle(27, ::test27)
    printlnQuestionsTitle(28, ::test28)
    printlnQuestionsTitle(29, ::test29)
    printlnQuestionsTitle(30, ::test30)
    printlnQuestionsTitle(31, ::test31)
    printlnQuestionsTitle(32, ::test32)
    printlnQuestionsTitle(33, ::test33)
    printlnQuestionsTitle(34, ::test34)
}

private inline fun printlnQuestionsTitle(index: Int, test: () -> Unit) {
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Questions$index test ~~~~~~~~~~~~~~~~~~~~~~~~~~")
    test()
}