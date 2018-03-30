package offer;

public class Questions10 {
	
	public static void main(String[] arg0) {
		for (int i = 0; i < 11; i++) {
			System.out.print(fibonacci1(i) + " ");
		}
		System.out.println("\n");
		for (int i = 0; i < 11; i++) {
			System.out.print(fibonacci2(i) + " ");
		}
		System.out.println("\n");
		
		System.out.println("台阶数3，有" +  frogSteps1(3) + "种跳法。");
		System.out.println("台阶数4，有" +  frogSteps1(4) + "种跳法。");
		System.out.println("台阶数5，有" +  frogSteps1(5) + "种跳法。");
		System.out.println();
		System.out.println("台阶数3，有" +  frogSteps2(3) + "种跳法。");
		System.out.println("台阶数4，有" +  frogSteps2(4) + "种跳法。");
		System.out.println("台阶数5，有" +  frogSteps2(5) + "种跳法。");
	}
	
	/*
	 * 题目一：斐波那契数列
	 */
	
	//使用循环，较为实用
	public static int fibonacci1(int position) {
		if (position < 0)
			throw new IllegalArgumentException("输入的数字不能为负数");
		int value = 1;
		int before = 0;
		int temp;
		if (position == 1) return value;
		if (position == 0) return before;
		for (int i = 2; i <= position; i++) {
			temp = value;
			value += before;
			before = temp;
		}
		return value;
	}
	
	//使用递归，速度较慢
	public static int fibonacci2(int position) {
		if (position < 0)
			throw new IllegalArgumentException("输入的数字不能为负数");
		if (position == 0)
			return 0;
		if (position == 1)
			return 1;
		return fibonacci2(position - 1) + fibonacci2(position - 2);
	}
	
	/*
	 * 题目二：青蛙跳台阶问题
	 */
	
	//递归实现
	public static int frogSteps1(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("输入的数字必须为正数");
		if (n == 1) return 1;
		if (n == 2) return 2;
		return frogSteps1(n - 1) + frogSteps1(n - 2);
	}
	
	//循环实现
	public static int frogSteps2(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("输入的数字必须为正数");
		int before = 1;
		int value = 2;
		if (n == 1) return before;
		if (n == 2) return value;
		int temp;
		for (int i = 3; i <= n; i++) {
			temp = value;
			value += before;
			before = temp;
		}
		return value;
	}

}