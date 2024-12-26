package com.qiaoyuang.algorithm.special

class LFUCache(private val capacity: Int) {

    private var minCount = Int.MIN_VALUE

    private val keyValue = HashMap<Int, Int>()
    private val keyCount = HashMap<Int, Int>()
    private val countKeys = HashMap<Int, LinkedHashSet<Int>>()

    operator fun set(key: Int, value: Int) {
        keyValue[key] = value
        if (keyCount.containsKey(key)) {
            get(key)
            return
        }
        if (keyCount.size == capacity) {
            val set = countKeys[minCount]!!
            val minKey = set.first()
            set.remove(minKey)
            keyValue.remove(minKey)
            keyCount.remove(minKey)
            if (set.isEmpty())
                countKeys.remove(minCount)
        }
        minCount = 1
        keyCount[key] = minCount
        val set = countKeys[minCount] ?: LinkedHashSet<Int>().also { countKeys[minCount] = it }
        set.add(key)
    }

    operator fun get(key: Int): Int {
        if (keyValue.containsKey(key)) {
            var count = keyCount[key]!!
            val set = countKeys[count]!!
            if (count == minCount && set.size == 1) {
                countKeys.remove(key)
                minCount = ++count
                keyCount[key] = count
            } else {
                set.remove(key)
                keyCount[key] = ++count
            }
            val newSet = countKeys[count] ?: LinkedHashSet<Int>().also { countKeys[count] = it }
            newSet.add(key)
            return keyValue[key]!!
        }
        return -1
    }
}