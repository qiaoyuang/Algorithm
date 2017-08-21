package offer;

//将一个数组的奇数全部放到前面，偶数全部放到后面

public class Questions21 {
	
	public static void main(String[] arg0) {
		int[] array = {4, 7, 3, 2, 0, 9, 5, 1, 6, 8};
		int[] newArray = exchange(array);
		for (int i : newArray) {
			System.out.println(i);
		}
	}
	
	public static int[] exchange(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == array[i] >> 1 << 1) {
				for (int j = array.length - 1; j >= i; j--) {
					if (array[j] != array[j] >> 1 << 1) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
				}
			}
		}
		return array;
	}

}