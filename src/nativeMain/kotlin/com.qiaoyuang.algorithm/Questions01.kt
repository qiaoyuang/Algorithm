package com.qiaoyuang.algorithm

/**
 * 赋值运算符函数
 */
fun test1() {
	val myString1 = MyString("a")
	val myString2 = MyString("b")
	val myString3 = MyString("c")
	println(myString1 assign myString2 assign myString3)
}

class MyString(var str: String) {
	
	infix fun assign(another: MyString): MyString {
		if (this !== another || str != another.str)
			str = another.str
		return this
	}
	
	override fun toString(): String = "MyString, data = $str"
	
}