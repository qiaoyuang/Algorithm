package com.qiaoyuang.algorithm.round0

/**
 * 二叉树节点
 */

data class BinaryTreeNode<T>(
    var value: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
) {
	
	fun preOrder() {
		println(value)
		left?.preOrder()
		right?.preOrder()
	}
	
	fun inOrder() {
		left?.inOrder()
		println(value)
		right?.inOrder()
	}
	
	fun postOrder() {
		left?.postOrder()
		right?.postOrder()
		println(value)
	}

    fun preOrderList(): List<T> {
        val result = mutableListOf<T>()
        preOrderList(result)
        return result
    }

    private fun preOrderList(mutableList: MutableList<T>) {
        mutableList.add(value)
        left?.preOrderList(mutableList)
        right?.preOrderList(mutableList)
    }

    fun inOrderList(): List<T> {
        val result = mutableListOf<T>()
        inOrderList(result)
        return result
    }

    private fun inOrderList(mutableList: MutableList<T>) {
        left?.inOrderList(mutableList)
        mutableList.add(value)
        right?.inOrderList(mutableList)
    }

    fun postOrderList(): List<T> {
        val result = mutableListOf<T>()
        postOrderList(result)
        return result
    }

    private fun postOrderList(mutableList: MutableList<T>) {
        left?.postOrderList(mutableList)
        right?.postOrderList(mutableList)
        mutableList.add(value)
    }
}