package com.qiaoyuang.algorithm

/**
 * 一个包含min方法的栈，永远都可以知道栈内最小的数字是多少
 */

fun main() {
	val stack = MinStack()
	fun myPrintln() {
		println("栈顶：${stack.first}")
	    println("最小值：${stack.min()}")
	}
	stack push 3
	myPrintln()
	stack push 5
	myPrintln()
	stack push 4
	myPrintln()
	stack push 2
	myPrintln()
	stack push 1
	myPrintln()
	while (!stack.isEmpty) {
		myPrintln()
		stack.pop()
	}
}

class MinStack : Stack<Int>() {
	
	private val assistStack = Stack<Int>()
	
	override infix fun push(t: Int) {
		super.push(t)
		val e =  if (assistStack.isEmpty || t < assistStack.first) t
		else assistStack.first
		assistStack.push(e)
	}
	
	override fun pop(): Int {
		assistStack.pop()
		return super.pop()
	}
	
	fun min(): Int = assistStack.first
	
}