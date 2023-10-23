package com.qiaoyuang.algorithm.round1

fun test62() {
    printlnResult(6, 2)
    printlnResult(5, 3)
    printlnResult(4, 4)
    printlnResult(3, 2)
    printlnResult(2, 1)
    printlnResult(1, 1)
}

/**
 * Questions 62: Josephuse Ring
 */
private fun lastNumberOfJosephuseRing(n: Int, m: Int): Int {
    require(m in 1..n) { "The n or m is illegal" }
    if (n == 1)
        return 0
    val header = SingleDirectionNode(0)
    var pointer = header
    for (i in 1..< n) {
        pointer.next = SingleDirectionNode(i)
        pointer = pointer.next!!
    }
    pointer.next = header

    repeat(n - 1) {
        repeat(m - 1) {
            pointer = pointer.next!!
        }
        pointer.next = pointer.next!!.next!!
    }

    return pointer.element
}

private fun printlnResult(n: Int, m: Int) =
    println("A Josephuse Ring has $n nodes, delete number $m node many times, last node is ${lastNumberOfJosephuseRing(n, m)}")