package com.qiaoyuang.algorithm.special

fun test37() {
    printlnResult(4, 5, -6, 4, 8, -5)
    printlnResult(5, 10, -5)
    printlnResult(8, -8)
    printlnResult(10, 2, -5)
    printlnResult(-2, -1, 1, 2)
    printlnResult(-2, -2, 1,-2)
}

/**
 * Questions 37: Asteroids Collision, LeetCode 735
 */
private fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    asteroids.forEach {
        if (it > 0)
            stack.add(it)
        else {
            while (stack.isNotEmpty() && stack.last() > 0 && stack.last() < -it)
                stack.removeLast()
            if (stack.isEmpty() || stack.last() < 0)
                stack.add(it)
            else if (stack.last() == -it)
                stack.removeLast()
        }
    }
    return stack.toIntArray()
}

private fun printlnResult(vararg asteroids: Int) =
    println("We have planets: ${asteroids.toList()}, after impact we got: ${asteroidCollision(asteroids).toList()}")