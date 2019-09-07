package com.qiaoyuang.algorithm

/**
 * 二叉树节点
 */

data class BinaryTreeNode<T>(var mValue: T,
							 var mLeft: BinaryTreeNode<T>? = null,
							 var mRight: BinaryTreeNode<T>? = null) {
	
	fun preorder() {
		println(mValue)
		mLeft?.preorder()
		mRight?.preorder()
	}
	
	fun inorder() {
		mLeft?.inorder()
		println(mValue)
		mRight?.inorder()
	}
	
	fun postorder() {
		mLeft?.postorder()
		mRight?.postorder()
		println(mValue)
	}
	
}