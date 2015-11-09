
public class Solution {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2)
			return 0;
		int max = 0;
		int low = prices[0];
		for (int i = 1; i < len; i++) {
			max = Math.max(prices[i] - low, max);
			low = Math.min(prices[i], low);
		}

		return max;
	}
}
