public class Solution1 {

  public String longestPalindrome(String s) {
    int len = s.length();
    char[] chars = s.toCharArray();
    boolean[][] p = new boolean[len][len];

    int maxLen = 1;
    int start = 0;
    for (int l = 1; l <= len; l++) {
      for (int i = 0; i <= len - l; i++) {
        if (chars[i] == chars[i + l - 1]) {
          if (l < 4) {
            p[i][i + l - 1] = true;
          } else {
            p[i][i + l - 1] = p[i + 1][i + l - 2];
          }

          if (p[i][i + l - 1] && l > maxLen) {
            maxLen = l;
            start = i;
          }
        }
      }

    }
    return s.substring(start, start + maxLen);
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    System.out.println(s.longestPalindrome("babad"));
    System.out.println(s.longestPalindrome("cbbd"));
  }
}