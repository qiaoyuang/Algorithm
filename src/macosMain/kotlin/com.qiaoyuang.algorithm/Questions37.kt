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
	node.preorder()
}

// 序列化
fun <T> BinaryTreeNode<T>.serialize(): String {
	var str = ""
	fun BinaryTreeNode<T>.preorderSerialize() {
		str += "$mValue,"
		if (mLeft != null) {
			mLeft!!.preorderSerialize()
		} else {
			str += "\$,"
		}
		if (mRight != null) {
			mRight!!.preorderSerialize()
		} else {
			str += "\$,"
		}
	}
	preorderSerialize()
	return str
}

// 反序列化
fun String.deserialize(): BinaryTreeNode<String> {
	val str = split(",")
	var i = 0
	fun String.preorderDeserialize(): BinaryTreeNode<String>? {
		if (i+1 < str.size) {
			if (str[i] != "\$" && str[i+1] != "\$") {
			    val node = BinaryTreeNode(this)
			    node.mLeft = str[++i].preorderDeserialize()
			    return node
		    } else if (str[i] != "\$" && str[i+1] == "\$") {
			    val node = BinaryTreeNode(this)
			    node.mRight = str[++i].preorderDeserialize()
			    return node
		    } else {
			    return str[++i].preorderDeserialize()
		    }
		}
		return null
	}
	return str[i].preorderDeserialize()!!
}