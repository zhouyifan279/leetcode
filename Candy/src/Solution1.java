public class Solution1 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] left = new int[n];
    left[0] = 1;
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        left[i] = left[i - 1] + 1;
      } else {
        left[i] = 1;
      }
    }

    int count = left[n - 1];
    for (int i = n - 1; i > 0; i--) {
      if (ratings[i - 1] > ratings[i]) {
        left[i - 1] = Math.max(left[i] + 1, left[i - 1]);
      }
      count += left[i - 1];
    }
    return count;
  }

  public static void main(String[] args) {
    int[] ratings = new int[]{1, 0, 2};
    System.out.println(new Solution1().candy(ratings));

    ratings = new int[]{1, 2, 2};
    System.out.println(new Solution1().candy(ratings));
  }
}
