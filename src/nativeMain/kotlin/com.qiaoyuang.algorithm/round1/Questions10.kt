package com.qiaoyuang.algorithm.round1

fun test10() {
    val index0 = 0U
    println("The $index0 th Fibonacci number is ${fibonacci(index0)}, correct is 0.")
    val index20 = 20U
    println("The $index20 th Fibonacci number is ${fibonacci(index20)}, correct is 6765.")
    val index50 = 50U
    println("The $index50 th Fibonacci number is ${fibonacci(index50)}, correct is 12586269025.")
}

/**
 * Questions10: Find the Nth term of the Fibonacci sequence
 */

fun fibonacci(n: UInt): ULong = when (n) {
    0U -> 0UL
    1U -> 1UL
    else -> {
        var result = 0UL
        var fn_1 = 1UL
        var fn_2 = 0UL
        for (i in 2U..n) {
            result = fn_1 + fn_2
            fn_2 = fn_1
            fn_1 = result
        }
        result
    }
}
