package offer

import java.util.LinkedList

//寻找二叉树的和为某一值的全部路径

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(10)
	val b = BinaryTreeNode<Int>(5)
	val c = BinaryTreeNode<Int>(6)
	val d = BinaryTreeNode<Int>(4)
	val e = BinaryTreeNode<Int>(7)
	val f = BinaryTreeNode<Int>(3)
	val g = BinaryTreeNode<Int>(1)
	val h = BinaryTreeNode<Int>(2)
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
		list.add(mValue)
		sum += mValue
		when {
			sum < num -> {
				if (mLeft == null) {
				    if (mRight == null) {
				        sum -= list.removeLast()
		            } else {
			            mRight!!.traverse()
		            }
		        } else {
			        mLeft!!.traverse()
		        }  
			    if (mRight == null) {
				    sum -= list.removeLast()
		        } else {
		            mRight!!.traverse()
				    sum -= list.removeLast()
	            } 
			}
			sum > num -> {
				sum -= list.removeLast()
			}
			else -> {
				list.forEach { print("$it ") }
			    println()
			    sum -= list.removeLast()
			}
				
		}
	}
	traverse()
}