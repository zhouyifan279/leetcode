import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

  public List<Integer> findAnagrams(String s, String p) {
    if (s.length() < p.length()) {
      return Collections.emptyList();
    }

    char[] sc = s.toCharArray();
    char[] pc = p.toCharArray();
    int[] sCount = new int[26];
    int[] pCount = new int[26];

    for (int i = 0; i < p.length(); i++) {
      pCount[pc[i] - 'a']++;
      sCount[sc[i] - 'a']++;
    }

    List<Integer> ret = new LinkedList<>();
    if (Arrays.equals(pCount, sCount)) {
      ret.add(0);
    }

    for (int i = p.length(); i < s.length(); i++) {
      sCount[sc[i] - 'a']++;
      sCount[sc[i - p.length()] - 'a']--;

      if (Arrays.equals(pCount, sCount)) {
        ret.add(i - p.length());
      }
    }
    return ret;
  }
}
