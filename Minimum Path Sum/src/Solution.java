public class Solution {

	public int minPathSum(int[][] grid) {
		int h = grid.length;
		int w = grid[0].length;

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (x == 0 && y == 0)
					continue;
				if (x == 0)
					grid[y][0] += grid[y - 1][0];
				else if (y == 0)
					grid[0][x] += grid[0][x - 1];
				else
					grid[y][x] += Math.min(grid[y - 1][x], grid[y][x - 1]);
			}
		}

		return grid[h - 1][w - 1];

	}

	public static void main(String[] args) {
		int[][] grid = { { 6, 2, 9, 8, 8, 7, 8, 2, 7, 7, 7, 5, 8, 8, 6, 9 },
				{ 0, 4, 7, 0, 4, 8, 5, 3, 4, 1, 9, 3, 6, 8, 1, 2 }, { 0, 1, 3, 9, 0, 1, 3, 7, 0, 2, 3, 9, 1, 1, 0, 1 },
				{ 7, 7, 3, 3, 7, 8, 6, 1, 2, 8, 7, 8, 6, 8, 2, 9 }, { 1, 5, 8, 3, 9, 3, 1, 9, 6, 6, 0, 7, 9, 0, 8, 6 },
				{ 9, 1, 0, 7, 1, 8, 0, 3, 6, 9, 1, 5, 8, 6, 4, 1 }, { 3, 4, 7, 4, 7, 0, 6, 3, 6, 6, 2, 5, 7, 0, 3, 6 },
				{ 3, 3, 3, 7, 2, 6, 0, 0, 5, 4, 5, 5, 0, 1, 9, 3 }, { 5, 6, 0, 3, 6, 6, 6, 2, 2, 9, 9, 9, 1, 2, 8, 7 },
				{ 8, 3, 4, 2, 9, 6, 2, 5, 0, 0, 0, 2, 1, 9, 8, 7 }, { 7, 8, 2, 3, 4, 0, 7, 6, 1, 6, 8, 3, 1, 6, 2, 1 },
				{ 1, 8, 3, 1, 4, 7, 8, 7, 7, 0, 9, 1, 0, 7, 0, 7 }, { 7, 2, 3, 1, 2, 0, 0, 4, 9, 0, 9, 2, 8, 3, 3, 9 },
				{ 1, 8, 2, 7, 5, 0, 4, 3, 1, 6, 6, 3, 5, 6, 2, 3 }, { 8, 5, 4, 2, 8, 6, 6, 7, 6, 7, 9, 4, 0, 4, 6, 3 },
				{ 2, 8, 3, 7, 9, 7, 2, 2, 5, 8, 5, 1, 4, 9, 4, 4 },
				{ 7, 0, 7, 5, 7, 5, 2, 5, 3, 3, 2, 5, 7, 0, 1, 9 } };
		for (int i = 0; i < grid.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("]");
		}
		long start = System.currentTimeMillis();
		int ret = new Solution().minPathSum(grid);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(ret);
	}
}