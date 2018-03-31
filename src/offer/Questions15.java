package offer;

public class Questions15 {
	
	public static void main(String[] arg0) {
		System.out.println(numberOf1(1));
		System.out.println(numberOf1(0x7fffffff));
		System.out.println(numberOf1(0x80000000));
		System.out.println(numberOf1(0xffffffff));
		System.out.println(numberOf1(0));
		System.out.println(numberOf2(1));
		System.out.println(numberOf2(0x7fffffff));
		System.out.println(numberOf2(0x80000000));
		System.out.println(numberOf2(0xffffffff));
		System.out.println(numberOf2(0));
		System.out.println();
		System.out.println("8是否是2的n次方：" + judgment(8));
		System.out.println("9是否是2的n次方：" + judgment(9));
		System.out.println();
		System.out.println("10改变" + calculate(10, 13) + "位可以变为13");
	}
	
	/*
	 * 将一个十进制数转化为二进制，求其中1的个数
	 */
	public static int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int numberOf2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
	/*
	 * 相关题目一：用一条语句判断一个数是不是2的证书次方
	 */
	public static boolean judgment(int number) {
		int _number = number - 1;
		int result = _number & number;
		if (result == 0) return true;
		else return false;
	}
	
	/*
	 * 相关题目二：输入m和n，判断m改变多少位以后可以变为n
	 */
	public static int calculate(int m, int n) {
		int result = m ^ n;
		int count = 0;
		while (result != 0) {
			int mod = result % 2;
			result >>= 1;
			if (mod == 1) count++;
		}
		return count;
	}

}