package com.qiaoyuang.algorithm.special

import kotlin.random.Random

fun test30() {
    printlnResult(1 to "abc", 2 to "def", 3 to "ghi")
}

/**
 * Questions 30: Implement a data container that delete, insert, access
 * operations are O(1) in time complexity, and implement a `getRandom` function
 */
private class MyHashMap<T, R> {

    private val container = HashMap<T, R>(8)

    operator fun get(key: T): R? = container[key]

    operator fun set(key: T, value: R) {
        container[key] = value
    }

    fun delete(key: T) {
        container.remove(key)
    }

    fun getRandom(): R {
        val random = Random.nextInt(container.size)
        return container.values.toList()[random]
    }

    val size: Int
        get() = container.size
}

private fun printlnResult(vararg  pairs: Pair<Int, String>) {
    val map = MyHashMap<Int, String>()
    println("Put ${pairs.toList()}")
    pairs.forEach { (key, value) ->
        map[key] = value
    }
    println("Get results: ${pairs.asSequence().map { it.second == map[it.first] }.all { it }}")
    println("Get randoms: ${map.getRandom()}, ${map.getRandom()}, ${map.getRandom()}")
}