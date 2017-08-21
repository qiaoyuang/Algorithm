package offer;

//斐波那契数列

public class Questions10 {
	
	public static void main(String[] arg0) {
		System.out.println(fibonacci1(0));
		System.out.println(fibonacci1(1));
		System.out.println(fibonacci1(2));
		System.out.println(fibonacci1(3));
		System.out.println(fibonacci1(4));
		System.out.println(fibonacci1(5));
		System.out.println(fibonacci1(6));
		System.out.println(fibonacci1(7));
		System.out.println(fibonacci1(8));
		System.out.println(fibonacci1(9));
		System.out.println(fibonacci1(10));
		System.out.println(fibonacci2(0));
		System.out.println(fibonacci2(1));
		System.out.println(fibonacci2(2));
		System.out.println(fibonacci2(3));
		System.out.println(fibonacci2(4));
		System.out.println(fibonacci2(5));
		System.out.println(fibonacci2(6));
		System.out.println(fibonacci2(7));
		System.out.println(fibonacci2(8));
		System.out.println(fibonacci2(9));
		System.out.println(fibonacci2(10));
	}
	
	//使用循环，较为实用
	private static int fibonacci1(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("输入的数字不能为负数");
		}
		int value = 1;
		int before = 0;
		int temp;
		if (position == 1) {
			return value;
		}
		if (position == 0) {
			return before;
		}
		for (int i = 2; i <= position; i++) {
			temp = value;
			value += before;
			before = temp;
		}
		return value;
	}
	
	//使用递归，速度较慢
	private static int fibonacci2(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("输入的数字不能为负数");
		}
		if (position == 0) {
			return 0;
		}
		if (position == 1) {
			return 1;
		}
		return fibonacci2(position - 1) + fibonacci2(position - 2);
	}

}