package offer;

import java.math.BigInteger;

//打印出一个n位数的从1到最大的所有数字

public class Questions17 {
	
	public static void main(String[] arg0) {
		printlToMaxOfNDigits(1);
		printlToMaxOfNDigits(2);
		printlToMaxOfNDigits(3);
	}
	
	public static void printlToMaxOfNDigits(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("输入的数字必须大于0");
		}
		if (n <= 18) {
			long max = 0L;
			long num = 1L;
			for (int i = 1; i <= n; i++) {
				max = 9 * num + max;
				num *= 10L;
			}
			for (long l = 1; l <= max; l++) {
				System.out.println(l);
			}
		} else {
			BigInteger max = new BigInteger("0");
			BigInteger num = new BigInteger("1");
			for (int i = 1; i <= n; i++) {
				max = max.add(num.multiply(BigInteger.valueOf(9)));
				num = num.multiply(BigInteger.valueOf(10));
			}
			for (BigInteger i = new BigInteger("1"); i.compareTo(max) < 0; i = i.add(BigInteger.valueOf(1))) {
				System.out.println(i);
			}
		}
	}

}