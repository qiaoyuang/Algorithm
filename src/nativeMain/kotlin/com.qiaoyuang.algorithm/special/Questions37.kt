package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack

fun test37() {
    printlnResult(4, 5, -6, 4, 8, -5)
}

/**
 * Questions 37: Planets impact
 */
private fun IntArray.planetsCrash(): IntArray {
    if (size <= 1)
        return this
    val stack = Stack<Int>()
    forEach { planet ->
        when {
            stack.isEmpty -> stack.push(planet)
            stack.top() < 0 && planet > 0 -> stack.push(planet)
            stack.top() > 0 && planet < 0 -> {
                when {
                    stack.top() < -planet -> {
                        var isPerishTogether = false
                        while (!stack.isEmpty)
                            when {
                                stack.top() > -planet -> break
                                stack.top() < -planet -> stack.pop()
                                else -> {
                                    stack.pop()
                                    isPerishTogether = true
                                    break
                                }
                            }
                        if (stack.isEmpty && !isPerishTogether)
                            stack.push(planet)
                    }
                    stack.top() == -planet -> stack.pop()
                }
            }
            else -> stack.push(planet)
        }
    }
    return IntArray(stack.size).apply {
        for (i in lastIndex downTo 0)
            this[i] = stack.pop()
    }
}

private fun printlnResult(vararg planets: Int) =
    println("We have planets: ${planets.toList()}, after impact we got: ${planets.planetsCrash().toList()}")