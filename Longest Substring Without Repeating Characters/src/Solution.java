import java.util.Arrays;

public class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
      return s.length();
    }

    int n = s.length();
    char[] chars = s.toCharArray();
    int[] dict = new int[128];
    Arrays.fill(dict, -1);
    dict[chars[0]] = 0;

    int max = 0;
    for (int i = 0, j = 1; j < n; j++) {
      int index = dict[chars[j]];
      dict[chars[j]] = j;
      if (index != -1 && index >= i) {
        max = Math.max(j - i, max);
        i = index + 1;
      } else if (j == n - 1) {
        max = Math.max(j - i + 1, max);
      }
    }
    return max;
  }
}
