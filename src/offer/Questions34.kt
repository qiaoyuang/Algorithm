package offer

fun main(args: Array<String>) {
	
}

fun BinaryTreeNode<Int>.findPath(num: Int) {
	var sum = 0
	val list = ArrayList<Int>()
	list.add(mValue)
	var node = this
	while (sum < num) {
		if (node.mLeft != null) {
			val next = node.mLeft!!
			sum += next.mValue
			if (sum == num) {
			    list.forEach {
				    print("$it ")
			    }
			    println()
				list.clear()
				
		    }
		}
	
		
		if (node.mRight != null) {
			val next = node.mRight!!
			sum += next.mValue
		}
	}
}