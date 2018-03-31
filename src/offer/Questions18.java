package offer;

import offer.LinkedList.Node;

public class Questions18 {
	
	public static void main(String[] arg0) {
		Node<String> node1 = new Node<>();
		node1.set("a");
		Node<String> node2 = new Node<>();
		node2.set("b");
		node1.setNext(node2);
		Node<String> node3 = new Node<>();
		node3.set("c");
		node2.setNext(node3);
		Node<String> node = node1;
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
		System.out.println(delete(node1, node2));
		node = node1;
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
		node = node1;
		System.out.println(delete(node1, node3));
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
		Node<String> node4 = new Node<>();
		node4.set("x");
		Node<String> node5 = new Node<>();
		node5.set("y");
		node4.setNext(node5);
		Node<String> node6 = new Node<>();
		node6.set("y");
		node5.setNext(node6);
		deleteRepeat(node4);
		node = node4;
		while (node != null) {
			System.out.println(node.get());
			node = node.getNext();
		}
	}
	
	//题目一：在O(n)时间内删除链表的某一个节点
	public static <T> T delete(Node<T> first, Node<T> node) {
		if (node.getNext() == null) {
			Node<T> oldFirst = first;
			while (first.getNext() != null) {
				oldFirst = first;
				first = first.getNext();
			}
			oldFirst.setNext(null);
			return first.get();
		}
		T t = node.get();
		Node<T> deleteNode = node.getNext();
		node.set(deleteNode.get());
		node.setNext(deleteNode.getNext());
		return t;
	}
	
	//题目二：删除链表重复节点（重复节点数量不定，重复次数不定）
	public static <T> void deleteRepeat(Node<T> first) {
		Node<T> oldFirst = first;
		while (first.getNext() != null) {
			oldFirst = first;
			first = first.getNext();
			if (oldFirst.get().equals(first.get())) {
				while (next(first)) {
					first = first.getNext();
				}
				oldFirst.setNext(first.getNext());
			}
		}
	}
	
	private static <T> boolean next(Node<T> first) {
		if (first.getNext() == null) {
			return false;
		}
		return first.get().equals(first.getNext().get());
	}

}