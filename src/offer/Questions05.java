package offer;

//替换空格（将字符串中的空格替换为其它字符串）

public class Questions05 {
	
	public static void main(String[] arg0) {
		System.out.println(replace1("We are happy;"));
		System.out.println(replace2("We are happy;"));
	}
	
	public static String replace1(String str) {
		StringBuilder builder = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++) {
			if (builder.charAt(i) == ' ') {
				builder.insert(i + 1, "%20");
				builder.deleteCharAt(i);
			}
		}
		return builder.toString();
	}
	
	public static String replace2(String str) {
		return str.replaceAll(" ", "%20");
	}

}