public class Solution {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int prev = prices[0];
    int profit = 0;
    for (int price : prices) {
      if (price > prev) {
        profit += price - prev;
      }
      prev = price;
    }
    return profit;
  }

  public static void main(String[] args) {
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(new Solution().maxProfit(prices));
    prices = new int[]{1, 2, 3, 4, 5};
    System.out.println(new Solution().maxProfit(prices));
    prices = new int[]{7, 6, 4, 3, 1};
    System.out.println(new Solution().maxProfit(prices));
  }
}
