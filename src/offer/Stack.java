package offer;

public class Stack<T> {
	
	private LinkedList<T> list;
	
	
	public Stack() {
		list = new LinkedList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEnpty() {
		return list.isEnpty();
	}
	
	public void push(T t) {
		list.push(t);
	}
	
	public T pop() {
		return list.pop();
	}

}