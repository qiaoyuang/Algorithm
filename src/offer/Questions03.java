package offer;

//寻找数组中重复的数字

public class Questions03 {
	
	public static void main(String[] arg0) {
		int[] matrix1 = {2, 3, 1, 0, 2, 5, 3};
		int[] matrix2 = {2, 3, 5, 4, 3, 2, 6, 7};
		int[] matrix3 = {2, 1, 4, 3, 5, 6, 7, 7};
		System.out.println(find1(matrix1));
		System.out.println(find1(matrix2));
		System.out.println(find1(matrix3));
		System.out.println(find2(matrix2));
		System.out.println(find2(matrix3));
		System.out.println(find3(matrix2));
		System.out.println(find3(matrix3));
	}
	
	//可以改变数组
	private static int find1(int[] matrix) {
		int temp;
		for (int i = 0; i < matrix.length; i++) {
			while (matrix[i] != i) {
				if (matrix[matrix[i]] == matrix[i]) {
					return matrix[i];
				}
				temp = matrix[i];
				matrix[i] = matrix[matrix[i]];
				matrix[temp] = temp;
			}
		}
		return -1;
	}
	
	//不能改变数组本身(二分查找)
	private static int find2(int[] matrix) {
		int high = matrix.length - 1;
		int low = 1;
		int count;
		while (high >= low) {
			int mid = (high - low) / 2 + low;
			count = 0;
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i] <= mid && matrix[i] >= low) {
					count++;
				}
			}
			if (count > mid - low + 1) {
				if (low == mid) {
					return mid;
				}
				high = mid;
			} else {
				if (mid == high) {
					return mid;
				}
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//不能改变数组本身（使用辅助数组，增加空间占用但节约时间）
	private static int find3(int[] matrix) {
		int[] a = new int[matrix.length + 1];
		for (int i = 0; i < matrix.length; i++) {
			if (a[matrix[i]] == matrix[i]) {
				return matrix[i];
			}
			a[matrix[i]] = matrix[i];
		}
		return -1;
	}

}