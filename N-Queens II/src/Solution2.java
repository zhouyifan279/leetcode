
public class Solution2 {

	int sum = 0, upperlimit = 1;

	public int totalNQueens(int n) {
		upperlimit = (1 << n) - 1;
		totalNQueens(0, 0, 0);
		return sum;
	}

	void totalNQueens(int row, int ld, int rd) {
		int placeable = upperlimit & ~(row | ld | rd);

		if (row != upperlimit) {
			while (placeable != 0) {
				int pos = placeable & (~placeable + 1);
				placeable -= pos;
				totalNQueens(row | pos, (ld | pos) << 1, (rd | pos) >> 1);
			}
		} else {
			sum++;
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = new Solution2().totalNQueens(15);
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println((end - start) + " ms");
	}
}
