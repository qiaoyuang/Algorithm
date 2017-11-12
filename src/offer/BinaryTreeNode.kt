package offer

class BinaryTreeNode<T>(var mValue: T? = null,
						var mLeft: BinaryTreeNode<T>? = null,
						var mRight: BinaryTreeNode<T>? = null) {
	
	fun postOrder() {
		mLeft?.postOrder()
		mRight?.postOrder()
		println(mValue)
	}
	
}