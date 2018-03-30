package offer;

public class Questions05 {
	
	public static void main(String[] arg0) {
		System.out.println(replace1("We are happy;"));
		System.out.println(replace2("We are happy;"));
		int[] array1 = new int[10];
		int count = 1;
		for (int i = 0; i < 5; i++) {
			array1[i] = count;
			count += 2;
		}
		int[] array2 = {0, 2, 4, 6, 8};
		mergeArray(array1, array2);
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
	}
	
	/*
	 * 替换空格（将字符串中的空格替换为其它字符串）
	 */
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
	
	/*
	 * 相关题目：替换空格（将字符串中的空格替换为其它字符串）
	 */
	public static int[] mergeArray(int[] array1, int[] array2) {
		int index1 = array1.length - 1;
		while (array1[index1] == 0) 
			index1--;
		int index2 = array2.length - 1;
		while (index2 >= 0) {
			if (array2[index2] < array1[index1]) {
				if (index1 == 0 || array1[index1 - 1] < array2[index2]) {
					insertArray(array2[index2], index1, array1);
					index1--;
					index2--;
				}
			} else index1++;
		}
		return array1;
	}
	
	private static void insertArray(int insertNumber, int index, int[] array) {
		int temp = insertNumber;
		int cache;
		for (int i = index; i < array.length; i++) {
			cache = array[i];
			array[i] = temp;
			temp = cache;
		}
	}

}