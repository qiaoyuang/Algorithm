package com.qiaoyuang.algorithm.special

fun test31() {
    printlnResult(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5)
}

/**
 * Questions 31: LRU cache
 */
private class LRUCache(private val capacity: Int) {

    private val firstNode = ListNode(-1, -1)
    private val lastNode = ListNode(-1, -1)

    private val map = HashMap<Int, ListNode>()

    init {
        firstNode.right = lastNode
        lastNode.left = firstNode
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        node.left?.right = node.right
        node.right?.left = node.left
        node.left = firstNode
        node.right = firstNode.right
        firstNode.right = node
        return node.value
    }

    operator fun set(key: Int, value: Int) {
        val newNode = when {
            map.containsKey(key) -> {
                val node = map[key]!!
                node.left?.right = node.right
                node.right?.left = node.left
                node.value = value
                node
            }
            map.size < capacity -> ListNode(key, value)
            else -> {
                val node = lastNode.left!!
                map.remove(node.key)
                node.left?.right = lastNode
                lastNode.left = node.left
                node.value = value
                node
            }
        }
        newNode.left = firstNode
        newNode.right = firstNode.right
        firstNode.right?.left = newNode
        firstNode.right = newNode
        map[key] = newNode
    }

    private class ListNode(
        var key: Int,
        var value: Int,
        var left: ListNode? = null,
        var right: ListNode? = null,
    )

    override fun toString(): String = map.toString()
}

private fun printlnResult(vararg pairs: Pair<Int, Int>) {
    val cache = LRUCache(3)
    println("Put ${pairs.toList()}")
    pairs.forEach { (key, value) ->
        cache[key] = value
    }
    println("The values are: $cache")
}