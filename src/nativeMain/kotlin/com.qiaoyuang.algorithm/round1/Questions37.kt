package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test37() {
    printlnResult(testCase1())
}

/**
 * Questions37: Serialization and Deserialization of a binary tree
 */
private fun BinaryTreeNode<Int>.serialize2String(): String = buildString {
    preOrderForSerialization(this)
    deleteAt(lastIndex)
}

private fun <T> BinaryTreeNode<T>.preOrderForSerialization(builder: StringBuilder) {
    builder.append("$value,")
    left?.preOrderForSerialization(builder) ?: builder.append("$,")
    right?.preOrderForSerialization(builder) ?: builder.append("$,")
}

private fun String.deserialize2BinaryTree(): BinaryTreeNode<Int> {
    require(isNotEmpty()) { "The string is illegal" }
    val nodes = splitToSequence(',')
        .map { if (it == "$") null else BinaryTreeNode(it.toInt()) }
        .toList()
    var pointer1 = 0
    var pointer2 = 1
    while (pointer2 + 1 < nodes.size) {
        val current = nodes[pointer1]!!

        val node = nodes[pointer2]
        val newNode = nodes[pointer2 + 1]
        when {
            node != null -> {
                current.left = node
                pointer1 = pointer2++
                continue
            }
            newNode == null -> {
                pointer1--
                pointer2++
                continue
            }
            else -> {
                current.right = newNode
                pointer1 = ++pointer2
                pointer2++
            }
        }
    }
    return nodes.first()!!
}

private fun printlnResult(root: BinaryTreeNode<Int>) {
    val str = root.serialize2String()
    println("The serialized string is: $str")
    println("Is the deserialized binary tree correct: ${str.deserialize2BinaryTree() == root}")
}

private fun testCase1(): BinaryTreeNode<Int> = BinaryTreeNode(
    value = 1,
    left = BinaryTreeNode(value = 2, left = BinaryTreeNode(value = 4)),
    right = BinaryTreeNode(
        value = 3,
        left = BinaryTreeNode(value = 5),
        right = BinaryTreeNode(value = 6),
    )
)