public class Solution {

  public int strStr(String haystack, String needle) {
    // KMP 算法

    // 求 needle 部分的前缀函数
    int[] pi = new int[needle.length()];
    for (int i = 1, j = 0; i < needle.length(); i++) {
      while (needle.charAt(i) != needle.charAt(j) && j > 0) {
        j = pi[j - 1];
      }
      if (needle.charAt(i) == needle.charAt(j)) {
        j++;
      }
      pi[i] = j;
    }

    // 求 haystack 部分的前缀函数
    for (int i = 0, j = 0; i < haystack.length(); i++) {
      while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
        j = pi[j - 1];
      }
      if (haystack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      if (j == needle.length()) {
        return i - j + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().strStr("sadbutsad", "sad"));
    System.out.println(new Solution().strStr("leetcode", "leeeto"));
    System.out.println(new Solution().strStr("mississippi", "issip"));
  }
}
