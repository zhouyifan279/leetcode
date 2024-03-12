import java.util.Arrays;

public class Solution1 {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = citations.length;
    for (int c : citations) {
      if (h > c) {
        h--;
      }
    }
    return h;
  }

  public static void main(String[] args) {
    int[] citations = new int[]{3, 0, 6, 1, 5};
    System.out.println(new Solution1().hIndex(citations));
    citations = new int[]{1, 3, 1};
    System.out.println(new Solution1().hIndex(citations));
  }
}
