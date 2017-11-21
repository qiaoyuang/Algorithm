package offer

//å°†ä¸€é¢—äºŒå‰æ’åºæ ‘è½¬æ¢æˆä¸€ä¸ªæ’åºçš„åŒå‘é“¾è¡¨,å¹¶è¿”å›è¾ƒå°ä¸€ç«¯çš„ç«¯ç‚¹

fun main(args: Array<String>) {
	//¹¹ÔìÒ»¸öËÄ²ãµÄÅÅĞò¶ş²æÊ÷
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