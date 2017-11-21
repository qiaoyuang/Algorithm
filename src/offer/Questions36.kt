package offer

//将一颗二叉排序树转换成一个排序的双向链表,并返回较小一端的端点

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(10)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(14)
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(8)
	val f = BinaryTreeNode<Int>(12)
	val g = BinaryTreeNode<Int>(16)
	val h = BinaryTreeNode<Int>(3)
	val i = BinaryTreeNode<Int>(5)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	d.mLeft = h
	d.mRight = i
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
		when {
			mLeft == null && mRight == null -> {
			    father?.let {
				    if (isBig) {
					    mLeft = it
				    } else {
					    mRight = it
				    }
			    }
				return this
		    }
			mLeft == null && mRight != null -> {
				if (isBig) {
					mLeft = father
				    mRight!!.traverse(true, this)
				    return this
				} else {
					val node = mRight!!.traverse(true, this)
					father?.let { mRight!!.mRight = it }
					return node
				}
			}
			mLeft != null && mRight == null -> {
				if (isBig) {
					val node = mLeft!!.traverse(false, this)
					father?.let { mLeft!!.mLeft = it }
					return node
				} else {
					mRight = father
				    mLeft!!.traverse(false, this)
				    return this
				}
			}
			else -> {
				if (isBig) {
					mRight!!.traverse(true, this)
					val node = mLeft!!.traverse(false, this)
					node.mLeft = father
					return node
				} else {
					mLeft!!.traverse(false, this)
					val node = mRight!!.traverse(true, this)
					node.mRight = father
					return node
				}
			}
		}
	}
	mLeft = mLeft?.traverse(false, this)
	mRight = mRight?.traverse(true, this)
	var head = this
	while (head.mLeft != null) {
		head = head.mLeft!!
	}
	return head
}