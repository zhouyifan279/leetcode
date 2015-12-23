import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new LinkedList<>();

		int[] board = new int[n];
		Arrays.fill(board, -1);

		int row = 0, col = 0;
		while (row < n) {
			while (col < n) {
				if (isValid(row, col, board)) {
					board[row] = col;
					break;
				} else {
					col++;
				}
			}

			if (board[row] == -1) {
				if (row == 0) {
					break;
				} else {
					col = board[row - 1] + 1;
					board[row - 1] = -1;
					row--;
				}
			} else {
				if (row == n - 1) {
					result.add(toString(board));
					board[row] = -1;
					col++;
				} else {
					row++;
					col = 0;
				}
			}
		}

		return result;
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
		List<List<String>> result = new Solution().solveNQueens(9);
		long end = System.currentTimeMillis();
		System.out.println(result.size());
		System.out.println((end - start) + " ms");
	}
}
