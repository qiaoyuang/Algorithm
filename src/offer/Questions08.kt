package offer

//二叉树中的某一节点的中序遍历序列中的下一节点

class BinaryTreeNodeWithFather<T>(var mValues: T? = null,
						var mFather: BinaryTreeNodeWithFather<T>? = null,
						var mLeft: BinaryTreeNodeWithFather<T>? = null,
						var mRight: BinaryTreeNodeWithFather<T>? = null)

fun main(args: Array<String>) {
	val a = BinaryTreeNodeWithFather<Char>('a')
	val b = BinaryTreeNodeWithFather<Char>('b', a)
	val c = BinaryTreeNodeWithFather<Char>('c', a)
	val d = BinaryTreeNodeWithFather<Char>('d', b)
	val e = BinaryTreeNodeWithFather<Char>('e', b)
	val f = BinaryTreeNodeWithFather<Char>('f', c)
	val g = BinaryTreeNodeWithFather<Char>('g', c)
	val h = BinaryTreeNodeWithFather<Char>('h', e)
	val i = BinaryTreeNodeWithFather<Char>('i', e)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	e.mLeft = h
	e.mRight = i
	val str = "空"
	println("a:${getNext(a) ?: str}")
	println("b:${getNext(b) ?: str}")
	println("c:${getNext(c) ?: str}")
	println("d:${getNext(d) ?: str}")
	println("e:${getNext(e) ?: str}")
	println("f:${getNext(f) ?: str}")
	println("g:${getNext(g) ?: str}")
	println("h:${getNext(h) ?: str}")
	println("i:${getNext(i) ?: str}")
}

fun <T> getNext(node: BinaryTreeNodeWithFather<T>): T? {
	if (node.mRight == null) {
		if (node.mFather != null) {
			if (node.mFather!!.mLeft === node) {
				return node.mFather?.mValues
			} else {
				var nNode = node
				while (nNode.mFather!!.mFather != null) {
					if (nNode.mFather!!.mFather!!.mLeft === nNode.mFather) {
						return nNode.mFather!!.mFather!!.mValues
					}
					nNode = nNode.mFather!!
				}
				return null
			}
		} else {
			return null
		}
	} else {
		var right = node.mRight
		while (right!!.mLeft != null) {
			right = right.mLeft
		}
		return right.mValues
	}
}