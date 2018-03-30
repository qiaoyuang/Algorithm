package offer;

public class Questions09 {
	
	public static void main(String[] arg0) {
		Queue<String> queue = new Queue<>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		queue.enqueue("f");
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
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
		
		System.out.println();
		
		TwoQueueStack<String> stack = new TwoQueueStack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.push("f");
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		stack.push("a");
		stack.push("b");
		stack.push("c");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	/*
	 * 用两个栈实现一个队列
	 */
	public static class Queue<T> {
		
		private Stack<T> stack1;
		private Stack<T> stack2;
		
		public Queue() {
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}
		
		public boolean isEmpty() {
			return stack1.isEmpty() && stack2.isEmpty();
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
	
	/*
	 * 相关题目：用两个队列实现一个栈
	 */
	private static class TwoQueueStack<T> {
		
		private Queue<T> queue1;
		private Queue<T> queue2;
		
		public TwoQueueStack() {
			queue1 = new Queue<>();
			queue2 = new Queue<>();
		}
		
		public boolean isEmpty() {
			return queue1.isEmpty() && queue2.isEmpty();
		}
		
		public int size() {
			return queue1.size() + queue2.size();
		}
		
		public void push(T t) {
			queue1.enqueue(t);
		}
		
		public T pop() {
			if (isEmpty()) {
				return null;
			}
			if (queue1.size() == 1) {
				return queue1.dequeue();
			} else if (queue1.size() > 1) {
				while (queue1.size() != 1) {
					queue2.enqueue(queue1.dequeue());
				}
				return queue1.dequeue();
			} else {
				while (queue2.size() > 0) {
					queue1.enqueue(queue2.dequeue());
				}
				return pop();
			}
		}
		
	}

}