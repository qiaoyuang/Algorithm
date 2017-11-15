package offer

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(8)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(6)
	val d = BinaryTreeNode<Int>(5)
	val e = BinaryTreeNode<Int>(7)
	val f = BinaryTreeNode<Int>(7)
	val g = BinaryTreeNode<Int>(5)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.isSymmetrical())
	c.mValue = 9
	println(a.isSymmetrical())
	val h = BinaryTreeNode<Int>(7)
	val i = BinaryTreeNode<Int>(7)
	val j = BinaryTreeNode<Int>(7)
	val k = BinaryTreeNode<Int>(7)
	val l = BinaryTreeNode<Int>(7)
	val m = BinaryTreeNode<Int>(7)
	h.mLeft = i
	h.mRight = j
	i.mLeft = k
	i.mRight = l
	j.mLeft = m
	println(h.isSymmetrical())
}

fun <T> BinaryTreeNode<T>.isSymmetrical(): Boolean {
	if (preorderJudgment()) {
	    if (preorderBack() == _preorderBack()) {
		    return true
	    }
	}
	return false
}

//先序遍历来判断每个节点是否左右节点同时为空或同时不为空
fun <T> BinaryTreeNode<T>.preorderJudgment(): Boolean {
	var boo = judgment()
	if (boo) {
	    mLeft?.let { boo = it.preorderJudgment() }
		mRight?.let { boo = it.preorderJudgment() }
	}
	return boo
}

//判断一个二叉树节点的左右子树是否同时为空或同时不为空
private fun <T> BinaryTreeNode<T>.judgment(): Boolean = (mLeft == null && mRight == null) || (mLeft != null && mRight != null)

//先序遍历的有返回值的版本
fun <T> BinaryTreeNode<T>.preorderBack(): String {
	var str: String = mValue.toString()
	str = str + mLeft?.preorderBack()
	str = str + mRight?.preorderBack()
	return str
}

//先序遍历的对称遍历方法，即先遍历右子树再遍历左子树
fun <T> BinaryTreeNode<T>._preorderBack(): String {
	var str: String = mValue.toString()
	str = str + mRight?._preorderBack()
	str = str + mLeft?._preorderBack()
	return str
}