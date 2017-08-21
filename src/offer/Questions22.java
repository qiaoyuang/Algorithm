package offer;

import offer.LinkedList.Node;

//链表的倒数第K个节点

public class Questions22 {
	
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
		System.out.println(nodeK(node1, 2).get());
		System.out.println(nodeK(node1, 3).get());
		System.out.println(nodeK(node1, 4).get());
		Node<String> node = null;
		System.out.println(nodeK(node, 3).get());
		System.out.println(nodeK(node1, 0).get());
		System.out.println(nodeK(node1, 7).get());
	}
	
	public static <T> Node<T> nodeK(Node<T> first, int k) {
		if (first == null) {
			throw new NullPointerException("输入的链表头节点为空");
		}
		if (k <= 0) {
			throw new IllegalArgumentException("输入的数字k必须大于0");
		}
		Node<T> one = first;
		Node<T> two = first;
		for (int i = 0; i < k - 1; i++) {
			one = one.getNext();
			if (one == null) {
				throw new IllegalArgumentException("输入的链表没有最多没有k项");
			}
		}
		while (one.getNext() != null) {
			one = one.getNext();
			two = two.getNext();
		}
		/*for (int i = 1; one.getNext() != null; i++) {
			one = one.getNext();
			if (i > k - 1) {
				two = two.getNext();
			}
		}*/
		return two;
	}

}