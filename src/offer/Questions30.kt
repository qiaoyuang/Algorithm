package offer

//一个包含min方法的栈，永远都可以知道栈内最小的数字是多少

fun main(arg0: Array<String>) {
	val stack = MinStack()
	fun myPrintln() {
		println("栈顶：${stack.top()}")
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
	while (!stack.isEnpty) {
		myPrintln()
		stack.pop()
	}
}

class MinStack() : Stack<Int>() {
	
	val assistStack: Stack<Int>
	
	init {
		assistStack = Stack()
	}
	
	override infix fun push(i: Int) {
		super.push(i)
		if (assistStack.size() == 0) {
			assistStack.push(i)
			return
		} else if (i < assistStack.top()) {
			assistStack.push(i)
			return
		} else assistStack.push(assistStack.top())
	}
	
	override fun pop(): Int {
		assistStack.pop()
		return super.pop()
	}
	
	fun min(): Int = assistStack.top()
	
}