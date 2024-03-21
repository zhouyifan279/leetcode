public class Solution {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }
    int i = 0;
    while (true) {
      String prev = strs[0];
      for (String str : strs) {
        if (i == str.length() || prev.charAt(i) != str.charAt(i)) {
          return new String(str.toCharArray(), 0, i);
        }
        prev = str;
      }
      i++;
    }
  }

  public static void main(String[] args) {
    String[] strs = new String[]{"flower", "flow", "flight"};
    System.out.println(new Solution().longestCommonPrefix(strs));
    strs = new String[]{"dog", "racecar", "car"};
    System.out.println(new Solution().longestCommonPrefix(strs));
    strs = new String[]{"dog"};
    System.out.println(new Solution().longestCommonPrefix(strs));
    strs = new String[]{"", "racecar", "car"};
    System.out.println(new Solution().longestCommonPrefix(strs));
  }
}
