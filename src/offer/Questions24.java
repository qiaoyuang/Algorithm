package offer;

import offer.LinkedList.Node;

//反转链表

public class Questions24 {
	
	public static void main(String[] arg0) {
		Node<String> node1 = new Node<>();
		node1.set("a");
		Node<String> node2 = new Node<>();
		node2.set("b");
		node1.setNext(node2);
		Node<String> node3 = new Node<>();
		node3.set("c");
		node2.setNext(node3);
		Node<String> node4 = new Node<>();
		node4.set("d");
		node3.setNext(node4);
		Node<String> node5 = new Node<>();
		node5.set("e");
		node4.setNext(node5);
		Node<String> node6 = new Node<>();
		node6.set("f");
		node5.setNext(node6);
		Node<String> node = reverseList1(node1);
		//Node<String> node = reverseList2(node);
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
	}
	
	//使用循环
	public static <T> Node<T> reverseList1(Node<T> first) {
		if (first == null) {
			throw new IllegalArgumentException("输入的链表不能为空");
		}
		if (first.getNext() == null) {
			throw new IllegalArgumentException("输入的链表不能只有一个节点");
		}
		Node<T> node = first.getNext();
		Node<T> temp = node;
		first.setNext(null);
		while (node.getNext() != null) {
			node = node.getNext();
			temp.setNext(first);
			first = temp;
			temp = node;
		}
		node.setNext(first);
		return node;
	}
	
	//使用递归
	public static <T> Node<T> reverseList2(Node<T> first) {
		if (first == null) {
			throw new IllegalArgumentException("输入的链表不能为空");
		}
		if (first.getNext() == null) {
			return first;
		}
		Node<T> newHead = reverseList2(first.getNext());
		first.getNext().setNext(first);
		first.setNext(null);
		return newHead;
	}

}