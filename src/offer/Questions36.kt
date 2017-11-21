package offer

//将一颗二叉排序树转换成一个排序的双向链表,并返回较小一端的端点

fun main(args: Array<String>) {
	//构造一个四层的排序二叉树
	val a = BinaryTreeNode<Int>(10)
	
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(14)
	
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(8)
	val f = BinaryTreeNode<Int>(12)
	val g = BinaryTreeNode<Int>(16)
	
	val h = BinaryTreeNode<Int>(3)
	val i = BinaryTreeNode<Int>(5)
	val j = BinaryTreeNode<Int>(7)
	val k = BinaryTreeNode<Int>(9)
	val l = BinaryTreeNode<Int>(11)
	val m = BinaryTreeNode<Int>(13)
	val n = BinaryTreeNode<Int>(15)
	val o = BinaryTreeNode<Int>(17)
	
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	d.mLeft = h
	d.mRight = i
	e.mLeft = j
	e.mRight = k
	f.mLeft = l
	f.mRight = m
	g.mLeft = n
	g.mRight = o
	
	var x = a.convert()
	while (x.mRight != null) {
		print("${x.mValue} ")
		x = x.mRight!!
	}
	print("${x.mValue} ")
	println()
	while (x.mLeft != null) {
		print("${x.mValue} ")
		x = x.mLeft!!
	}
	print("${x.mValue} ")
}

fun <T> BinaryTreeNode<T>.convert(): BinaryTreeNode<T> {
	fun BinaryTreeNode<T>.traverse(isBig: Boolean, father: BinaryTreeNode<T>? = null): BinaryTreeNode<T> {
		if (mLeft == null && mRight == null) {
			if (isBig) {
				mLeft = father
			} else {
				mRight = father
			}
			return this
		}
		mLeft?.let {
			mLeft = it.traverse(false, this)
			mLeft!!.mRight = this
		}
		mRight?.let {
			mRight = it.traverse(true, this)
			mRight!!.mLeft = this
		}
		if (isBig) {
			if (mLeft != null) {
				var node = mLeft
				while (node!!.mLeft != null) {
					node = node.mLeft
				}
				return node
			}
			return this
		} else {
			if (mRight != null) {
				var node = mRight
				while (node!!.mRight != null) {
					node = node.mRight
				}
				return node
			}
			return this
		}
	}
	mLeft?.let {
		mLeft = it.traverse(false, this)
		mLeft!!.mRight = this
	}
	mRight?.let {
		mRight = it.traverse(true, this)
		mRight!!.mLeft = this
	}
	var head = this
	while (head.mLeft != null) {
		head = head.mLeft!!
	}
	return head
}