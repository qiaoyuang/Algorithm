package offer;

//表示数值的字符串

public class Questions20 {
	
	public static void main(String[] main) {
		System.out.println(isNumber("168"));
		System.out.println(isNumber("1.2"));
		System.out.println(isNumber("1e3"));
		System.out.println(isNumber("-1e2"));
		System.out.println(isNumber("-1e+256"));
		System.out.println(isNumber(".12"));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1.2.3"));
		System.out.println(isNumber("1e2E3"));
		System.out.println(isNumber("1e"));
		System.out.println(isNumber("-1e+2-"));
	}
	
	public static boolean isNumber(String str) {
		if (str == null || str.length() < 1) {
			return false;
		}
		if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '.') {
			if (str.length() <= 1) {
				return false;
			}
			if (!Character.isDigit(str.charAt(1))) {
				return false;
			}
			if (str.length() <= 2) {
				return true;
			}
			return CycleJudgment(str, 2);
		} else if (Character.isDigit(str.charAt(0))) {
			return CycleJudgment(str, 0);
		} else {
			return false;
		}
	}
	
	private static boolean CycleJudgment(String str, int start) {
		boolean dot = false;
		boolean isE = false;
		for (int i = start; i <= str.length() - 1; i++) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				if (c == '.') {
					if (dot) {
						return false;
					}
					dot = true;
					if (str.length() - 1 <= i || !Character.isDigit(str.charAt(i + 1))) {
						return false;
					}
				} else if (c == 'e' || c == 'E') {
					if (isE) {
						return false;
					}
					isE = true;
					if (str.length() - 1 <= i) {
						return false;
					}
					if (str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-' || Character.isDigit(str.charAt(i + 1))) {
						if (!Character.isDigit(str.charAt(i + 1))) {
							if (str.length() - 1 <= i + 1) {
								return false;
							}
							if (!Character.isDigit(str.charAt(i + 2))) {
								return false;
							}
						}
					}
				} else if (c == '+' || c == '-') {
					if (str.charAt(i -1) != 'e' && str.charAt(i -1) != 'E') {
						return false;
					}
					if (str.length() - 1 <= i) {
						return false;
					}
					if (!Character.isDigit(str.charAt(i + 1))) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
}