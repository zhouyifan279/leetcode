import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    int n = words.length;
    List<String> ret = new LinkedList<>();
    int size = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (size + count + words[i].length() <= maxWidth) {
        size += words[i].length();
        count++;
      } else {
        int spaces = maxWidth - size;
        int gap = spaces / Math.max(1, count - 1);
        int rem = spaces % Math.max(1, count - 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < count; j++) {
          sb.append(words[i + j - count]);
          if (sb.length() < maxWidth) {
            appendSpace(sb, gap);
            if (j < rem) {
              sb.append(' ');
            }
          }
        }
        ret.add(sb.toString());
        size = words[i].length();
        count = 1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < count; j++) {
      sb.append(words[n + j - count]);
      if (sb.length() < maxWidth) {
        sb.append(' ');
      }
    }
    appendSpace(sb, maxWidth - sb.length());
    ret.add(sb.toString());
    return ret;
  }

  private void appendSpace(StringBuilder sb, int num) {
    for (int i = 0; i < num; i++) {
      sb.append(' ');
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.fullJustify(
        new String[]{"This", "is", "an", "example", "of", "text", "justification."},
        16
    ).forEach(System.out::println);
    System.out.println();

    solution.fullJustify(
        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
        16
    ).forEach(System.out::println);
    System.out.println();

    solution.fullJustify(
        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
        20
    ).forEach(System.out::println);
    System.out.println();
  }
}
