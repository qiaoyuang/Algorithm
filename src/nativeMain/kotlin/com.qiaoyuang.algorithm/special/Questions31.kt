package com.qiaoyuang.algorithm.special

fun test31() {
    printlnResult(1 to "abc", 2 to "def", 3 to "ghi", 4 to "jkl", 5 to "mno")
}

/**
 * Questions 31: LRU cache
 */
private class LRUCache<K, V>(private val maxSize: Int) {

    private val map = HashMap<K, V>(maxSize)
    private val keyList = ArrayDeque<K>()

    operator fun get(key: K): V? {
        if (!map.contains(key))
            return null
        keyList.remove(key)
        keyList.addFirst(key)
        return map[key]
    }

    operator fun set(key: K, value: V) {
        if (map.contains(key))
            keyList.remove(key)
        keyList.addFirst(key)
        map[key] = value
        if (keyList.size > maxSize)
            map.remove(keyList.removeLast())
    }

    override fun toString(): String = map.toString()
}

private fun printlnResult(vararg pairs: Pair<Int, String>) {
    val cache = LRUCache<Int, String>(3)
    println("Put ${pairs.toList()}")
    pairs.forEach { (key, value) ->
        cache[key] = value
    }
    println("The values are: $cache")
}