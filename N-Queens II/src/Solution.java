import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private int sum = 0;

	public int totalNQueens(int n) {
		int[] board = new int[n];
		totalNQueens(n, board, 0);

		return sum;
	}

	void totalNQueens(int n, int[] board, int row) {
		for (int col = 0; col < n; col++) {
			if (isValid(row, col, board)) {
				board[row] = col;
				if (row == n - 1) {
					sum++;
				} else {
					totalNQueens(n, board, row + 1);
				}
			}
		}
	}

	boolean isValid(int row, int col, int[] board) {
		for (int r = 0; r < row; r++) {
			if (col == board[r] || Math.abs(row - r) == Math.abs(col - board[r])) {
				return false;
			}
		}

		return true;
	}

	List<String> toString(int[] board) {
		List<String> ret = new LinkedList<>();
		char[] s = new char[board.length];
		Arrays.fill(s, '.');
		for (int pos : board) {
			s[pos] = 'Q';
			ret.add(new String(s));
			s[pos] = '.';
		}

		return ret;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = new Solution().totalNQueens(9);
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println((end - start) + " ms");
	}
}
