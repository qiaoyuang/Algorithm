package com.qiaoyuang.algorithm

/**
 * 根据先序遍历序列和中序遍历序列重建二叉树
 */

fun main() {
	val preorder = listOf(1, 2, 4, 7, 3, 5, 6, 8)
	val inorder = listOf(4, 7, 2, 1, 5, 3, 8, 6)
	val root = binaryTreeConstruct(preorder, inorder)
	root?.postorder()
}

fun <T> binaryTreeConstruct(preorder: List<T>, inorder: List<T>): BinaryTreeNode<T>? {
	if (preorder.isEmpty() || inorder.isEmpty()) {
		return null
	}
	val rootValue = preorder[0]
	val root = BinaryTreeNode<T>(rootValue)
	var isRoot = false
	val sonInorderLeft = ArrayList<T>()
	val sonInorderRight = ArrayList<T>()
	for (t in inorder) {
		if (t == rootValue) {
			isRoot = true
		} else if (isRoot) {
			sonInorderRight.add(t)
		} else {
			sonInorderLeft.add(t)
		}
	}
	val sonPreorderLeft = ArrayList<T>()
	val sonPreorderRight = ArrayList<T>()
	for (i in 0 until preorder.size) {
		if (i != 0) {
			if (i <= sonInorderLeft.size) {
				sonPreorderLeft.add(preorder[i])
			} else {
				sonPreorderRight.add(preorder[i])
			}
		}
	}
	root.mLeft = binaryTreeConstruct(sonPreorderLeft, sonInorderLeft)
	root.mRight = binaryTreeConstruct(sonPreorderRight, sonInorderRight)
	return root
}