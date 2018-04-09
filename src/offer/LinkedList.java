package offer;

public class LinkedList<T> {
	
	public Node<T> first;
	
	private int N = 0;
	
	public Node<T> getFirst() {
		return first;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(T t) {
		Node<T> oldFirst = first;
		first = new Node<>();
		first.set(t);
		first.setNext(oldFirst);
		N++;
	}
	
	public T pop() {
		if (N < 0) {
			throw new UnsupportedOperationException("已经没有元素可以弹出");
		}
		T t = first.get();
		first = first.getNext();
		N--;
		return t;
	}
	
	public T top() {
		if (N == 0) {
			return null;
		}
		return first.get();
	}
	
	public static class Node<T> {
		
		private T t;
		
		private Node<T> next;
		
		public Node() {}
		
		public Node(T t) {
			this.t = t;
		}
		
		public void set(T t) {
			this.t = t;
		}
		
		public T get() {
			return t;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
	}

}