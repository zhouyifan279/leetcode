public class Solution3 {

  public int hIndex(int[] citations) {
    int start = 0, end = citations.length;
    while (start < end) {
      int mid = (start + end + 1) / 2;
      int count = 0;
      for (int citation : citations) {
        if (citation >= mid) {
          count++;
        }
      }
      if (count >= mid) {
        start = mid;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    int[] citations = new int[]{3, 0, 6, 1, 5};
    System.out.println(new Solution3().hIndex(citations));
    citations = new int[]{1, 3, 1};
    System.out.println(new Solution3().hIndex(citations));
  }
}
