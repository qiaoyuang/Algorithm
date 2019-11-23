package com.qiaoyuang.algorithm

/**
 * 序列化与反序列化二叉树
 */

fun main() {
	val a = BinaryTreeNode(1)
	val b = BinaryTreeNode(2)
	val c = BinaryTreeNode(3)
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(5)
	val f = BinaryTreeNode(6)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	c.mLeft = e
	c.mRight = f
	val str = a.serialize()
	println(str)
	println()
	val node = str.deserialize()
	node.preOrder()
}

// 序列化
fun <T> BinaryTreeNode<T>.serialize(): String {
	var str = ""
	fun BinaryTreeNode<T>.preOrderSerialize() {
		str += "$mValue,"
		if (mLeft != null) {
			mLeft!!.preOrderSerialize()
		} else {
			str += "\$,"
		}
		if (mRight != null) {
			mRight!!.preOrderSerialize()
		} else {
			str += "\$,"
		}
	}
	preOrderSerialize()
	return str
}

// 反序列化
fun String.deserialize(): BinaryTreeNode<String> {
	val str = split(",")
	var i = 0
	fun String.preOrderDeserialize(): BinaryTreeNode<String>? =
		if (i+1 < str.size) when {
			str[i] != "\$" && str[i+1] != "\$" -> {
				val node = BinaryTreeNode(this)
				node.mLeft = str[++i].preOrderDeserialize()
				node
			}
			str[i] != "\$" && str[i+1] == "\$" -> {
				val node = BinaryTreeNode(this)
				node.mRight = str[++i].preOrderDeserialize()
				node
			}
			else -> str[++i].preOrderDeserialize()
		} else null
	return str[i].preOrderDeserialize()!!
}