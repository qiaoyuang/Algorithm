package offer

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(1)
	val b = BinaryTreeNode<Int>(2)
	val c = BinaryTreeNode<Int>(3)
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(5)
	val f = BinaryTreeNode<Int>(6)
	val g = BinaryTreeNode<Int>(7)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mRight = f
	e.mLeft = g
	println("二叉树的高度为：${a.treeDepth()}")
	println()
	println(a.isBalanced(1))
}

//题目一：二叉树的深度
fun <T> BinaryTreeNode<T>.treeDepth(): Int {
	var left = 1
	left += mLeft?.treeDepth() ?: 0
	var right = 1
	right += mRight?.treeDepth() ?: 0
	return if (left > right) {
		left
	} else {
		right
	}
}

//题目二：判断一棵二叉树是否是平衡二叉树
fun <T> BinaryTreeNode<T>.isBalanced(depth: Int): Boolean {
	val left = 0
	val right = 0
	var depthR = depth
	if (mLeft?.isBalanced(left) ?: true && mRight?.isBalanced(right) ?: true) {
		val diff: Int = left - right
		if (Math.abs(diff) > 1) {
			depthR = if (left > right)
				left
			else
				right
			return true
		}
	}
	return false
}