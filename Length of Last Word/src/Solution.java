public class Solution {

  public int lengthOfLastWord(String s) {
    int ret = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        ret++;
      } else if (ret > 0) {
        return ret;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLastWord("Hello World"));
    System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(new Solution().lengthOfLastWord("luffy is still joyboy"));
  }
}
