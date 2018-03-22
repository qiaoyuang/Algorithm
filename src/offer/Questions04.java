package offer;

//二维数组中的查找

public class Questions04 {
	
	public static void main(String[] arg0) {
		int matrix[][] = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}};
		if (find(matrix, 10)) {
			System.out.println("存在");
		} else {
			System.out.println("不存在");
		}
	}
	
	private static boolean find(int[][] matrix, int number) {
		int horLength = matrix.length - 1;
		int i;
		for (i = horLength; i > 0; i--) {
			if (matrix[i][0] < number) {
				break;
			} else if (matrix[i][0] == number) {
				return true;
			}
		}
		int verLength = matrix[0].length - 1;
		int j;
		for (j = 0; j < verLength; j++) {
			if (matrix[i][j] > number) {
				break;
			} else if (matrix[i][j] == number) {
				return true;
			}
		}
		for (int a = 0; a <= i; a++) {
			for (int b = j; b <= verLength; b++) {
				if (matrix[a][b] == number) {
					return true;
				}
			}
		}
		return false;
	}

}