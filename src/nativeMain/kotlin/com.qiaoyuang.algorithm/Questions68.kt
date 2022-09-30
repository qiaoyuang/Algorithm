package com.qiaoyuang.algorithm

/**
 * 题目：给出两个树的节点，求这两个节点的公共子节点
 * 本题根据给出的具体条件的不同则解法也不同，例如，树是否是二叉树，
 * 是否是二叉搜索树，每个节点是否包含指向父节点的引用等，
 * 为了编程方便，以及难度又较高，我给出的解法为，适用于该树是二叉树，
 * 但是不是二叉搜索树，子节点也没有指向父节点的引用。
 */

fun main() {
	val a = BinaryTreeNode('A')
	val b = BinaryTreeNode('B')
	val c = BinaryTreeNode('C')
	val d = BinaryTreeNode('D')
	val e = BinaryTreeNode('E')
	val f = BinaryTreeNode('F')
	val g = BinaryTreeNode('G')
	val h = BinaryTreeNode('H')
	val i = BinaryTreeNode('I')
	val j = BinaryTreeNode('J')
	
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	d.mLeft = f
	d.mRight = g
	e.mLeft = h
	e.mRight = i
	i.mRight = j
	
	println(a.getLastCommonParent(g, j).mValue)
	println(a.getLastCommonParent(h, j).mValue)
	println(a.getLastCommonParent(f, c).mValue)
}

fun <T> BinaryTreeNode<T>.getLastCommonParent(
		node1: BinaryTreeNode<T>,
		node2: BinaryTreeNode<T>): BinaryTreeNode<T> {
	fun BinaryTreeNode<T>.myPreOrder(node: BinaryTreeNode<T>): NodeAndIsFound<T> {
		val thisNode = Node<BinaryTreeNode<T>>(this)
		if (this === node)
			return NodeAndIsFound(thisNode, true)
		var left: NodeAndIsFound<T>? = null
		mLeft?.let {
			val myNode = Node<BinaryTreeNode<T>>(it)
			val next = it.myPreOrder(node)
			myNode.next = next.node
			left = NodeAndIsFound(myNode, next.isFound)
		}
		var right: NodeAndIsFound<T>? = null
		mRight?.let {
			val myNode = Node<BinaryTreeNode<T>>(it)
			val next = it.myPreOrder(node)
			myNode.next = next.node
			right = NodeAndIsFound(myNode, next.isFound)
		}
		left?.let {
			if (it.isFound) {
				thisNode.next = it.node
				return NodeAndIsFound(thisNode, it.isFound)
			}
		}
		right?.let {
			if (it.isFound) {
				thisNode.next = it.node
				return NodeAndIsFound(thisNode, it.isFound)
			}
		}
		return NodeAndIsFound(thisNode)
	}
	var pNode1: Node<BinaryTreeNode<T>>? = myPreOrder(node1).node
	var pNode2: Node<BinaryTreeNode<T>>? = myPreOrder(node2).node
	lateinit var result: BinaryTreeNode<T>
	while (true) {
		if (pNode1?.next?.t === pNode2?.next?.t) {
			pNode1 = pNode1?.next
			pNode2 = pNode2?.next
		} else {
			result = pNode1?.t!!
			break
		}
	}
	return result
}

data class NodeAndIsFound<T>(val node: Node<BinaryTreeNode<T>>, val isFound: Boolean = false)