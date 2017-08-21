package offer;

//求字符串的全排列

public class Questions38 {
	
	public static void main(String[] arg0) {
		permutation("abcd");
		permutation("abc");
		permutation("ab");
		permutation("a");
		combination("abcd");
		combination("abc");
		combination("ab");
		combination("a");
		int[] i = {1,2,3,4,5,6,7,8};
		System.out.println(vertex(i));
		int[] a = {1,1,1,1,1,1,1,1};
		System.out.println(vertex(a));
		System.out.println(eightQueen());
	}
	
	//字符串的全排列
	public static void permutation(String str) {
		if (str == null || str.length() < 1) {
			throw new IllegalArgumentException("输入的字符串不能为空，且长度不能为0");
		}
		if (str.length() == 1) {
			System.out.println(str);
			return;
		}
		permutation(str.toCharArray(), 0);
	}
	
	private static void permutation(char[] c, int i) {
		char temp;
		char[] d;
		if (i < c.length - 1) {
			for (int j = i; j < c.length; j++) {
				d = c.clone();
				if (i != j) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
					System.out.println(String.valueOf(d));
				} else if (i == 0) {
					System.out.println(String.valueOf(d));
				}
				permutation(d, i + 1);
			}
		}
	}
	
	//字符串的全组合
	public static void combination(String str) {
		if (str == null || str.length() < 1) {
			throw new IllegalArgumentException("输入的字符串不能为空且长度不能为0");
		}
		if (str.length() == 1) {
			System.out.println(str);
			return;
		}
		char[] c = str.toCharArray();
		for (int i = 1; i <= c.length; i++) {
			char[] d = new char[i];
			fill(c, d, 0, 0);
		}
	}
	
	private static void fill(char[] c, char[] d, int pointerC, int pointerD) {
		if (pointerD < d.length) {
			for (int i = pointerC; i < c.length; i++) {
				d[pointerD] = c[i];
				if (pointerD == d.length - 1) {
					System.out.println(d);
				}
				fill(c, d, i + 1, pointerD + 1);
			}
		}
	}
	
	
	//判断一个数组中的8个数字能不能分别放在一个正方体的8个顶点，使得两两相对的两面的四个数相加的和相等
	public static boolean vertex(int[] array) {
		if (array.length != 8) {
			throw new IllegalArgumentException("输入的数组长度必须为8");
		}
		return permutationInt(array, 0);
	}
	
	private static boolean permutationInt(int[] a, int i) {
		int temp;
		int[] d;
		if (i < a.length - 1) {
			for (int j = i; j < a.length; j++) {
				d = a.clone();
				if (i != j) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
					if (judgment(d)) {
						return true;
					}
				} else if (i == 0) {
					if (judgment(d)) {
						return true;
					}
				}
				permutationInt(d, i + 1);
			}
		}
		return false;
	}
	
	private static boolean judgment(int[] a) {
		if (a[0] + a[1] + a[2] + a[3] != a[4] + a[5] + a[6] + a[7]) {
			return false;
		}
		if (a[0] + a[2] + a[4] + a[6] != a[1] + a[3] + a[5] + a[7]) {
			return false;
		}
		if (a[0] + a[1] + a[4] + a[5] != a[2] + a[4] + a[6] + a[7]) {
			return false;
		}
		return true;
	}
	
	//8皇后问题
	public static int eightQueen() {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
		return permutationEightQueen(array, 0);
	}
	
	private static int permutationEightQueen(int[] a, int i) {
		int count = 0;
		int temp;
		int[] d;
		if (i < a.length - 1) {
			for (int j = i; j < a.length; j++) {
				d = a.clone();
				if (i != j) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
					if (judgmentEightQueen(d)) {
						count++;
					}
				} else if (i == 0) {
					if (judgmentEightQueen(d)) {
						count++;
					}
				}
				count += permutationEightQueen(d, i + 1);
			}
		}
		return count;
	}
	
	private static boolean judgmentEightQueen(int[] a) {
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				int var = j - i;
				if (a[i] + var == a[j] || a[i] - var == a[j]) {
					return false;
				}
			}
		}
		return true;
	}

}