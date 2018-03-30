package offer;

public class Stack<T> {
	
	private LinkedList<T> list;
	
	
	public Stack() {
		list = new LinkedList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(T t) {
		list.push(t);
	}
	
	public T pop() {
		return list.pop();
	}
	
	public T top() {
		return list.top();
	}

}