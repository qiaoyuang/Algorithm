package offer;

//使用两个栈来实现队列

public class Questions09 {
	
	public static void main(String[] arg0) {
		Queue<String> queue = new Queue<>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		queue.enqueue("f");
		System.out.println(queue.isEnpty());
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEnpty());
		System.out.println(queue.size());
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
	public static class Queue<T> {
		
		private Stack<T> stack1;
		private Stack<T> stack2;
		
		public Queue() {
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}
		
		public boolean isEnpty() {
			return stack1.isEnpty() && stack2.isEnpty();
		}
		
		public int size() {
			if (stack1.size() != 0) {
				return stack1.size();
			} else if (stack2.size() != 0) {
				return stack2.size();
			} else {
				return 0;
			}
		}
		
		public void enqueue(T t) {
			stack1.push(t);
		}
		
		public T dequeue() {
			if (stack2.size() == 0) {
				while (stack1.size() != 0) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}
		
	}

}