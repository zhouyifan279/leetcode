public class Solution2 {

  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];
    for (int c : citations) {
      if (c >= n) {
        count[n]++;
      } else {
        count[c]++;
      }
    }
    int total = 0;

    for (int h = n; h > 0; h--) {
      total += count[h];
      if (total >= h) {
        return h;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] citations = new int[]{3, 0, 6, 1, 5};
    System.out.println(new Solution2().hIndex(citations));
    citations = new int[]{1, 3, 1};
    System.out.println(new Solution2().hIndex(citations));
  }
}
