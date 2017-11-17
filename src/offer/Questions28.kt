package offer

//鍒ゆ柇涓�涓簩鍙夋爲鏄笉鏄绉颁簩鍙夋爲

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(8)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(6)
	val d = BinaryTreeNode<Int>(5)
	val e = BinaryTreeNode<Int>(7)
	val f = BinaryTreeNode<Int>(7)
	val g = BinaryTreeNode<Int>(5)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.isSymmetrical())
	c.mValue = 9
	println(a.isSymmetrical())
	val h = BinaryTreeNode<Int>(7)
	val i = BinaryTreeNode<Int>(7)
	val j = BinaryTreeNode<Int>(7)
	val k = BinaryTreeNode<Int>(7)
	val l = BinaryTreeNode<Int>(7)
	val m = BinaryTreeNode<Int>(7)
	h.mLeft = i
	h.mRight = j
	i.mLeft = k
	i.mRight = l
	j.mLeft = m
	println(h.isSymmetrical())
}

fun <T> BinaryTreeNode<T>.isSymmetrical(): Boolean {
	if (preorderJudgment()) {
	    if (preorderBack() == _preorderBack()) {
		    return true
	    }
	}
	return false
}

//浣跨敤鍏堝簭閬嶅巻妫�鏌ヤ竴涓簩鍙夋爲鏄笉鏄墍鏈夊瓙鑺傜偣鐨勫乏鍙宠妭鐐规槸涓嶆槸鍚屾椂涓虹┖鎴栧悓鏃朵笉涓虹┖
fun <T> BinaryTreeNode<T>.preorderJudgment(): Boolean {
	var boo = judgment()
	if (boo) {
	    mLeft?.let { boo = it.preorderJudgment() }
		mRight?.let { boo = it.preorderJudgment() }
	}
	return boo
}

//鍒ゆ柇涓�涓簩鍙夋爲鐨勮妭鐐规槸涓嶆槸宸﹀彸鑺傜偣鍚屾椂涓虹┖鎴栧悓鏃朵笉涓虹┖
private fun <T> BinaryTreeNode<T>.judgment() = (mLeft == null && mRight == null) || (mLeft != null && mRight != null)

//鍏堝簭閬嶅巻鐨勫甫杩斿洖搴忓垪鐗堟湰
fun <T> BinaryTreeNode<T>.preorderBack(): String {
	var str = mValue.toString()
	str += mLeft?.preorderBack()
	str += mRight?.preorderBack()
	return str
}

//鍏堝簭閬嶅巻鏀圭増锛岃皟鎹㈤亶鍘嗗乏瀛愭爲鍜屽彸瀛愭爲鐨勯『搴�
fun <T> BinaryTreeNode<T>._preorderBack(): String {
	var str = mValue.toString()
	str += mRight?._preorderBack()
	str += mLeft?._preorderBack()
	return str
}