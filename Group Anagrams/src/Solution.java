import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>(strs.length);

    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> group = map.getOrDefault(key, new LinkedList<>());
      group.add(s);
      map.put(key, group);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(s.groupAnagrams(new String[]{""}));
    System.out.println(s.groupAnagrams(new String[]{"a"}));
  }
}
