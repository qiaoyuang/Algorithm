package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test48() {
    printlnResult(binaryTreeTestCase1())
    printlnResult(binaryTreeTestCase2())
    printlnResult(binaryTreeTestCase3())
    printlnResult(binaryTreeTestCase4())
}

/**
 * Questions 48: Serialize and Deserialize Binary Tree, LeetCode 297
 */
private fun BinaryTreeNode<Int>.serialize(): String = buildString {
    preOrderSerialize(this)
    deleteAt(lastIndex)
}

private fun BinaryTreeNode<Int>.preOrderSerialize(builder: StringBuilder) {
    builder.append(value)
    builder.append(',')
    left?.preOrderSerialize(builder) ?: builder.append("$,")
    right?.preOrderSerialize(builder) ?: builder.append("$,")
}

private fun String.deserialize(): BinaryTreeNode<Int> {
    val strings = split(',')
    val i = intArrayOf(0)
    return dfs(strings, i)!!
}

private fun dfs(strings: List<String>, i: IntArray): BinaryTreeNode<Int>? {
    val str = strings[i.first()]
    i[0]++
    if (str == "$")
        return null
    val node = BinaryTreeNode(str.toInt())
    node.left = dfs(strings, i)
    node.right = dfs(strings, i)
    return node
}

private fun printlnResult(root: BinaryTreeNode<Int>) {
    println("Input a binary tree ${root.preOrderList()}(preorder)")
    val string = root.serialize()
    println("We serialize it to ${root.serialize()}")
    val deserialization = string.deserialize()
    println(deserialization.preOrderList())
    println(deserialization.inOrderList())
    println("Deserializer it we can get the same tree: ${root.preOrderList() == deserialization.preOrderList() && root.inOrderList() == deserialization.inOrderList()}")
}