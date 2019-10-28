package com.qiaoyuang.algorithm

/**
 * 根据先序遍历序列和中序遍历序列重建二叉树
 */

fun test7() {
	val preOrder = listOf(1, 2, 4, 7, 3, 5, 6, 8)
	val inOrder = listOf(4, 7, 2, 1, 5, 3, 8, 6)
	val root = binaryTreeConstruct(preOrder, inOrder)
	root?.postOrder()
}

fun <T> binaryTreeConstruct(preOrder: List<T>, inorder: List<T>): BinaryTreeNode<T>? {
	if (preOrder.isEmpty() || inorder.isEmpty()) {
		return null
	}
	val rootValue = preOrder[0]
	val root = BinaryTreeNode(rootValue)
	var isRoot = false
	val sonInorderLeft = ArrayList<T>()
	val sonInorderRight = ArrayList<T>()
	for (t in inorder) when {
		t == rootValue -> isRoot = true
		isRoot -> sonInorderRight.add(t)
		else -> sonInorderLeft.add(t)
	}
	val sonPreOrderLeft = ArrayList<T>()
	val sonPreOrderRight = ArrayList<T>()
	for (i in preOrder.indices) {
		if (i != 0) {
			if (i <= sonInorderLeft.size) {
				sonPreOrderLeft.add(preOrder[i])
			} else {
				sonPreOrderRight.add(preOrder[i])
			}
		}
	}
	root.mLeft = binaryTreeConstruct(sonPreOrderLeft, sonInorderLeft)
	root.mRight = binaryTreeConstruct(sonPreOrderRight, sonInorderRight)
	return root
}