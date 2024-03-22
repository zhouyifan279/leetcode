public class Solution {

  public String convert(String s, int numRows) {
    if (numRows == 1 || s.length() <= numRows) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    int t = numRows * 2 - 2;
    for (int r = 0; r < numRows; r++) {
      for (int j = 0; j < s.length(); j += t) {
        sb.append(s.charAt(j + r));
        if (r > 0 && r < numRows - 1 && j + t - r < s.length()) {
          sb.append(s.charAt(j + t - r));
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().convert("PAYPALISHIRING", 2));
    System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    System.out.println(new Solution().convert("A", 1));
  }
}
