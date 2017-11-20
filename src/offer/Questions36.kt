package offer

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(10)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(14)
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(8)
	val f = BinaryTreeNode<Int>(12)
	val g = BinaryTreeNode<Int>(16)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	var x: BinaryTreeNode<Int>? = a.convert()
	while (x != null) {
		println(x.mValue)
		x = x.mRight
	}
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
				return mRight!!.traverse(true, this)
			}
			mLeft != null && mRight == null -> {
				return mLeft!!.traverse(false, this)
			}
			else -> {
				if (isBig) {
					return mLeft!!.traverse(false, this)
				} else {
					return mRight!!.traverse(true, this)
				}
			}
		}
			
	}
	mLeft = mLeft?.traverse(false)
	mRight = mRight?.traverse(true)
	var head = this
	while (head.mLeft != null) {
		head = head.mLeft!!
	}
	return head
}