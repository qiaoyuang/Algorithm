package offer;

//实现一个方法，求输入的double类型数字的整数次方的值

public class Questions16 {
	
	public static void main(String[] arg0) {
		System.out.println(power(2, 0));
		System.out.println(power(1.5, 2));
		System.out.println(power(0.0, 5));
		System.out.println(power(5, -1));
		System.out.println(power(-1, 3));
		System.out.println(power(-2, -2));
	}
	
	public static double power(double base, int exponent) {
		if (base == 0.0 && exponent <= 0) {
			throw new IllegalArgumentException("0的0次方和负数次方没有意义");
		}
		if (base == 0) {
			return 0.0;
		}
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		int absExponent = Math.abs(exponent);
		double result = power(base, absExponent >> 1);
		result *= result;
		if ((absExponent & 1) == 1) {
			result *= base;
		}
		if (exponent < 0) {
			return 1 / result;
		} else {
			return result;
		}
	}

}