package com.qiaoyuang.algorithm.round0

/**
 * 寻找二叉树的和为某一值的全部路径
 */

fun test34() {
	val a = BinaryTreeNode(10)
	val b = BinaryTreeNode(5)
	val c = BinaryTreeNode(6)
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(3)
	val g = BinaryTreeNode(1)
	val h = BinaryTreeNode(2)
	a.left = b
	a.right = c
	b.left = d
	b.right = e
	c.left = f
	c.right = g
	g.left = h
	a.findPath(19)
}

fun BinaryTreeNode<Int>.findPath(num: Int) {
	var sum = 0
	val list = LinkedList<Int>()
	fun BinaryTreeNode<Int>.traverse() {
		list.push(value)
		sum += value
		when {
			sum < num -> {
				if (left == null) {
				    if (right == null) {
				        sum -= list.dequeue()
		            } else {
			            right!!.traverse()
		            }
		        } else {
			        left!!.traverse()
		        }  
			    right?.traverse()
				sum -= list.dequeue()
			}
			sum > num -> {
				sum -= list.dequeue()
			}
			else -> {
				list.forEach { print("$it ") }
			    println()
			    sum -= list.dequeue()
			}
				
		}
	}
	traverse()
}