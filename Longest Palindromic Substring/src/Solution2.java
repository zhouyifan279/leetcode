public class Solution2 {

  public String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int max = 1;
    int start = 0;
    for (int i = 0; i < chars.length; i++) {
      int l1 = expand(chars, i, i + 1);
      int l2 = expand(chars, i, i + 2);
      int l = Math.max(l1, l2);
      if (l > max) {
        start = i - l / 2 + 1;
        max = l;
      }
    }
    return s.substring(start, start + max);
  }

  private int expand(char[] chars, int start, int end) {
    while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
      start--;
      end++;
    }
    return end - start - 1;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    System.out.println(s.longestPalindrome("babad"));
    System.out.println(s.longestPalindrome("cbbd"));
    System.out.println(s.longestPalindrome("aaaa"));
  }
}