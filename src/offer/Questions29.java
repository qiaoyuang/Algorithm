package offer;

//顺时针打印二维数组

public class Questions29 {
	
	public static void main(String[] arg0) {
		int[][] matrix1 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		int[][] matrix2 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
				};
		printMatrixCircle(matrix1);
		printMatrixCircle(matrix2);
	}
	
	public static void printMatrixCircle(int[][] matrix) {
		int start = 0;
		int endRow = matrix[0].length - 1;
		int endColumn = matrix.length - 1;
		int row;
		int column;
		while (start <= endRow && start <= endColumn) {
			column = start;
			row = start;
			do {
				System.out.println(matrix[column][row]);
				if (column == start && row < endRow) {
					row++;
				} else if (row == endRow && column < endColumn) {
					column++;
				} else if (column == endColumn && row > start) {
					row--;
				} else if (row == start && column > start) {
					column--;
				}
			} while (!(row == start && column == start));
			start++;
			endRow--;
			endColumn--;
		}
	}

}