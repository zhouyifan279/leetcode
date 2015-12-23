import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	List<List<String>> result = new LinkedList<>();
	int upperlimit = 1;
	int[] board;

	public List<List<String>> solveNQueens(int n) {
		upperlimit = (1 << n) - 1;
		board = new int[n];
		solveNQueens(0, 0, 0, 0);
		return result;
	}

	void solveNQueens(int row, int ld, int rd, int index) {
		int placeable = upperlimit & ~(row | ld | rd);

		if (row != upperlimit) {
			while (placeable != 0) {
				int pos = placeable & (~placeable + 1);
				board[index] = bitmapToInt(pos);
				placeable -= pos;
				solveNQueens(row | pos, (ld | pos) << 1, (rd | pos) >> 1, index + 1);
			}
		} else {
			result.add(boardToString(board));
		}
	}

	int bitmapToInt(int bitmap) {
		int ret = 0;
		while (bitmap > 0) {
			bitmap = bitmap >> 1;
			ret++;
		}
		return ret - 1;
	}

	List<String> boardToString(int[] board) {
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
		List<List<String>> result = new Solution3().solveNQueens(4);
		long end = System.currentTimeMillis();
		System.out.println(result.size());
		System.out.println((end - start) + " ms");

		for (List<String> list : result) {
			for (String s : list) {
				System.out.println(s);
			}

			System.out.println();
		}
	}
}
