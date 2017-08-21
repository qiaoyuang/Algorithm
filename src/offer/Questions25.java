package offer;

import offer.LinkedList.Node;

//合并两个已排序的链表

public class Questions25 {
	
	public static void main(String[] arg0) {
		Node<Integer> node1 = new Node<>();
		node1.set(1);
		Node<Integer> node2 = new Node<>();
		node2.set(3);
		node1.setNext(node2);
		Node<Integer> node3 = new Node<>();
		node3.set(5);
		node2.setNext(node3);
		Node<Integer> node4 = new Node<>();
		node4.set(2);
		Node<Integer> node5 = new Node<>();
		node5.set(4);
		node4.setNext(node5);
		Node<Integer> node6 = new Node<>();
		node6.set(6);
		node5.setNext(node6);
		//Node<Integer> node = merge1(node1, node4);
		Node<Integer> node = merge2(node1, node4);
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
	}
	
	//使用循环
	public static Node<Integer> merge1(Node<Integer> node1, Node<Integer> node2) {
		if (node1 == null && node2 == null) {
			throw new IllegalArgumentException("输入的链表不能为空");
		}
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		Node<Integer> head;
		Node<Integer> tail;
		if (node1.get() >= node2.get()) {
			head = tail = node2;
			node2 = node2.getNext();
		} else {
			head = tail = node1;
			node1 = node1.getNext();
		}
		while (node1 != null && node2 != null) {
			if (node1.get() >= node2.get()) {
				tail.setNext(node2);
				tail = node2;
				node2 = node2.getNext();
			} else {
				tail.setNext(node1);
				tail = node1;
				node1 = node1.getNext();
			}
		}
		if (node1 == null) {
			while (node2 != null) {
				tail.setNext(node2);
				node2 = node2.getNext();
			}
		}
		if (node2 == null) {
			while (node1 != null) {
				tail.setNext(node1);
				node1 = node1.getNext();
			}
		}
		return head;
	}
	
	//使用递归
	public static Node<Integer> merge2(Node<Integer> node1, Node<Integer> node2) {
		Node<Integer> head;
		Node<Integer> oldNode;
		if (node1 == null && node2 == null) {
			throw new IllegalArgumentException("输入的链表不能为空");
		}
		if (node1 != null && node2 != null) {
			if (node1.get() >= node2.get()) {
				oldNode = node2;
				node2 = node2.getNext();
				head = merge2(node1, node2);
			} else {
				oldNode = node1;
				node1 = node1.getNext();
				head = merge2(node1, node2);
			}
			oldNode.setNext(head);
			head = oldNode;
		} else if (node1 == null) {
			while (node2.getNext() != null) {
				head = node2;
				node2 = node2.getNext();
				head.setNext(node2);
			}
			head = node2;
		} else {
			while (node1.getNext() != null) {
				head = node1;
				node2 = node1.getNext();
				head.setNext(node1);
			}
			head = node1;
		}
		return head;
	}

}