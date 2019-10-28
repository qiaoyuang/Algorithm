package com.qiaoyuang.algorithm

/**
 * 二叉树节点
 */

data class BinaryTreeNode<T>(var mValue: T,
							 var mLeft: BinaryTreeNode<T>? = null,
							 var mRight: BinaryTreeNode<T>? = null) {
	
	fun preOrder() {
		println(mValue)
		mLeft?.preOrder()
		mRight?.preOrder()
	}
	
	fun inOrder() {
		mLeft?.inOrder()
		println(mValue)
		mRight?.inOrder()
	}
	
	fun postOrder() {
		mLeft?.postOrder()
		mRight?.postOrder()
		println(mValue)
	}
	
}