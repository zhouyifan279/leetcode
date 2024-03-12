public class Solution2 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int inc = 1, dec = 0, count = 1;
    int prev = 1;
    for (int i = 1; i < n; i++) {
      if (ratings[i] >= ratings[i - 1]) {
        dec = 0;
        prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
        inc = prev;
        count += prev;
      } else {
        dec++;
        if (dec == inc) {
          dec++;
        }
        count += dec;
        prev = 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] ratings = new int[]{1, 0, 2};
    System.out.println(new Solution2().candy(ratings));

    ratings = new int[]{1, 2, 2};
    System.out.println(new Solution2().candy(ratings));
  }
}
