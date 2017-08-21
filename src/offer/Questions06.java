package offer;

//从尾到头打印链表

public class Questions06 {
	
	public static void main(String[] arg0) {
		LinkedList<String> list = new LinkedList<>();
		//从头部将以下元素依次插入链表头部
		list.push("a");
		list.push("b");
		list.push("c");
		list.push("d");
		list.push("e");
		list.push("f");
		list.push("g");
		printLinkedList1(list.getFirst());
		printLinkedList2(list.getFirst());
	}
	
	//较为推荐的方法，使用另一个链表模拟栈，把链表从头输出到栈中，然后再按照栈弹出的顺序打印链表
	public static void printLinkedList1(LinkedList.Node<String> first) {
		LinkedList<String> list = new LinkedList<>();
		while (first != null) {
			list.push(first.get());
			first = first.getNext();
		}
		while (list.size() != 0) {
			System.out.println(list.pop());
		}
	}
	
	//使用递归的方法，不推荐，因为当链表过长时函数调用栈过深，有可能会导致调用栈溢出；
	public static void printLinkedList2(LinkedList.Node<String> first) {
		if (first != null) {
			if (first.getNext() != null) {
				printLinkedList2(first.getNext());
			}
			System.out.println(first.get());
		}
	}

}