package com.qiaoyuang.algorithm

/**
 * 层序遍历二叉树
 */

fun main() {
	// 构造二叉树
	val a = BinaryTreeNode(1)
	
	val b = BinaryTreeNode(2)
	val c = BinaryTreeNode(3)
	
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(5)
	val f = BinaryTreeNode(6)
	val g = BinaryTreeNode(7)
	
	val h = BinaryTreeNode(8)
	val i = BinaryTreeNode(9)
	val j = BinaryTreeNode(10)
	val k = BinaryTreeNode(11)
	val l = BinaryTreeNode(12)
	val m = BinaryTreeNode(13)
	val n = BinaryTreeNode(14)
	val o = BinaryTreeNode(15)
	
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
	
	a.printFromTopToBottom1()
	println()
	println()
	a.printFromTopToBottom2()
	println()
	println()
	a.printFromTopToBottom3()
}

// 从上到下层序遍历二叉树
fun <T> BinaryTreeNode<T>.printFromTopToBottom1() {
	val list = LinkedList<BinaryTreeNode<T>>()
	print("$mValue ")
	mLeft?.let { list.push(it) }
	mRight?.let { list.push(it) }
	while (list.size != 0) {
		val node = list.dequeue()
		print("${node.mValue} ")
		node.mLeft?.let { list.push(it) }
	    node.mRight?.let { list.push(it) }
	}
}

// 分行从上到下打印二叉树
fun <T> BinaryTreeNode<T>.printFromTopToBottom2() {
	val list = LinkedList<BinaryTreeNode<T>>()
	print("$mValue ")
	println()
	mLeft?.let { list.push(it) }
	mRight?.let { list.push(it) }
	var thisFloorCount = 2
	var nextFloorCount = 0
	while (list.size != 0) {
		val node = list.dequeue()
		thisFloorCount--
		print("${node.mValue} ")
		node.mLeft?.let {
			list.push(it)
			nextFloorCount++
		}
	    node.mRight?.let {
			list.push(it)
			nextFloorCount++
		}
		if (thisFloorCount == 0) {
			println()
			thisFloorCount = nextFloorCount
		}
	}
}

//“之”字型遍历打印二叉树
fun <T> BinaryTreeNode<T>.printFromTopToBottom3() {
	val list = LinkedList<BinaryTreeNode<T>>()
	print("$mValue ")
	println()
	mLeft?.let { list.push(it) }
	mRight?.let { list.push(it) }
	var thisFloorCount = 2
	var nextFloorCount = 0
	var lineCount = 2
	
	fun left(node: BinaryTreeNode<T>, boo: Boolean) {
		node.mLeft?.let {
			if (boo) {
				list.offer(it)
			} else {
				list.push(it)
			}
			nextFloorCount++
		}
	}
	
	fun right(node: BinaryTreeNode<T>, boo: Boolean) {
		node.mRight?.let {
			if (boo) {
				list.offer(it)
			} else {
				list.push(it)
			}
			nextFloorCount++
		}
	}
	
	fun printValue(value: T) {
		thisFloorCount--
		print("$value ")
	}
	
	while (list.size != 0) {
		val boo = lineCount % 2 == 0
		if (boo) {
			val node = list.pop()
			printValue(node.mValue)
			right(node, boo)
			left(node, boo)
		} else {
			val node = list.pop()
			printValue(node.mValue)
			left(node, boo)
			right(node, boo)
		}
		
		if (thisFloorCount == 0) {
			println()
			thisFloorCount = nextFloorCount
			lineCount++
		}
	}
}