package offer;

//将一个十进制数转化为二进制，求其中1的个数

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
	}
	
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

}