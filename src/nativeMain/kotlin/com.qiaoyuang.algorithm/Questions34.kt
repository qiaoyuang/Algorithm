package com.qiaoyuang.algorithm

/**
 * 寻找二叉树的和为某一值的全部路径
 */

fun main() {
	val a = BinaryTreeNode(10)
	val b = BinaryTreeNode(5)
	val c = BinaryTreeNode(6)
	val d = BinaryTreeNode(4)
	val e = BinaryTreeNode(7)
	val f = BinaryTreeNode(3)
	val g = BinaryTreeNode(1)
	val h = BinaryTreeNode(2)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	g.mLeft = h
	a.findPath(19)
}

fun BinaryTreeNode<Int>.findPath(num: Int) {
	var sum = 0
	val list = LinkedList<Int>()
	fun BinaryTreeNode<Int>.traverse() {
		list.push(mValue)
		sum += mValue
		when {
			sum < num -> {
				if (mLeft == null) {
				    if (mRight == null) {
				        sum -= list.dequeue()
		            } else {
			            mRight!!.traverse()
		            }
		        } else {
			        mLeft!!.traverse()
		        }  
			    mRight?.traverse()
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