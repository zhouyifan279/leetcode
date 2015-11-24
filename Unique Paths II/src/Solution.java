
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int w = obstacleGrid[0].length;
		int[] dp = new int[w];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int i = 0; i < w; i++) {
				if (row[i] == 1) {
					dp[i] = 0;
				} else if (i > 0) {
					dp[i] += dp[i - 1];
				}
			}
		}

		return dp[w - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 },
				{ 0, 0 }, { 0, 0 }, { 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 1 }, { 0, 0 },
				{ 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 }, { 0, 1 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
				{ 0, 0 }, { 0, 0 }, { 0, 1 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 },
				{ 0, 0 }, { 0, 0 } };

		System.out.println(new Solution().uniquePathsWithObstacles(grid));
	}
}
