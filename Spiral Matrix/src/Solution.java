import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return Arrays.asList();
		}

		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		List<Integer> list = new ArrayList<>(rowNum * colNum);

		int startX = 0, startY = 0;
		while (startX <= (rowNum - 1) / 2 && startY <= (colNum - 1) / 2) {
			for (int col = startY; col < colNum - startY; col++) {
				list.add(matrix[startX][col]);
			}

			for (int row = startX + 1; row < rowNum - startX - 1; row++) {
				list.add(matrix[row][colNum - startY - 1]);
			}

			if (startX != rowNum - startX - 1) {
				for (int col = colNum - startY - 1; col > startY - 1; col--) {
					list.add(matrix[rowNum - startX - 1][col]);
				}
			}

			if (startY != colNum - startY - 1) {
				for (int row = rowNum - startX - 2; row > startX; row--) {
					list.add(matrix[row][startY]);
				}
			}

			startX++;
			startY++;
		}

		return list;
	}

	public static void main(String[] args) {
		// int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6
		// }, { 10, 9, 8, 7 } };
//		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		 int[][] matrix = { { 6, 9, 7 } };
//		 int[][] matrix = { { 2,5,8 },{4,0,-1} };
		List<Integer> list = new Solution().spiralOrder(matrix);
		System.out.print(list);
	}
}