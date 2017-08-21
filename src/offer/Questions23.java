package offer;

import offer.LinkedList.Node;

//寻找链表的环节点

public class Questions23 {
	
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
		node6.setNext(node3);
		System.out.println(findEntry(node1));
	}
	
	public static <T> T findEntry(Node<T> first) {
		int count = isLoop(first);
		if (count == 0) {
			throw new IllegalArgumentException("输入的链表中没有环");
		}
		Node<T> one = first;
		Node<T> two = first;
		for (int i = 1; i <= count; i++) {
			one = one.getNext();
		}
		while (!one.equals(two)) {
			one = one.getNext();
			two = two.getNext();
		}
		return two.get();
	}
	
	private static <T> int isLoop(Node<T> first) {
		Node<T> one = first;
		Node<T> two = first;
		if (one == null || one.getNext() == null) {
			return 0;
		}
		while (one.getNext() != null && one.getNext().getNext() != null) {
			one = one.getNext().getNext();
			two = two.getNext();
			if (one.equals(two)) {
				Node<T> node = one;
				one = one.getNext();
				if (one.equals(node)) {
					return 1;
				}
				int i;
				for (i = 1; !one.equals(node); i++) {
					one = one.getNext();
				}
				return i;
			}
		}
		return 0;
	}

}