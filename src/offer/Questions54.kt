package offer

//在二叉搜索树中寻找第k大的节点

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(5)
	val b = BinaryTreeNode<Int>(3)
	val c = BinaryTreeNode<Int>(7)
	val d = BinaryTreeNode<Int>(2)
	val e = BinaryTreeNode<Int>(4)
	val f = BinaryTreeNode<Int>(6)
	val g = BinaryTreeNode<Int>(8)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.kThNode(3))
}

fun <T> BinaryTreeNode<T>.kThNode(k: Int): T {
	val list = ArrayList<T>()
	fun postorderFind(node: BinaryTreeNode<T>) {
		node.mLeft?.let { postorderFind(it) }
		list.add(node.mValue)
		node.mRight?.let { postorderFind(it) }
	}
	postorderFind(this)
	return list.get(list.size - k)
}