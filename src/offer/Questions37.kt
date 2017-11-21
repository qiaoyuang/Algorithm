package offer

//序列化与反序列化二叉树

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(1)
	val b = BinaryTreeNode<Int>(2)
	val c = BinaryTreeNode<Int>(3)
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(5)
	val f = BinaryTreeNode<Int>(6)
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

fun String.deserialize(): BinaryTreeNode<String> {
	val strs = split(",")
	var i = 0
	fun String.preorderDeserialize(): BinaryTreeNode<String>? {
		if (i+1 < strs.size) {
			if (strs[i] != "\$" && strs[i+1] != "\$") {
			    val node = BinaryTreeNode(this)
			    node.mLeft = strs[++i].preorderDeserialize()
			    return node
		    } else if (strs[i] != "\$" && strs[i+1] == "\$") {
			    val node = BinaryTreeNode(this)
			    node.mRight = strs[++i].preorderDeserialize()
			    return node
		    } else {
			    return strs[++i].preorderDeserialize()
		    }
		}
		return null
	}
	return strs[i].preorderDeserialize()!!
}