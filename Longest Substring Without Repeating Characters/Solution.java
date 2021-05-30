import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;

        Map<Character, Integer> indexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = indexes.get(c);
            if (index != null) {
                maxLength = Math.max(maxLength, i - start);
                for (int x = start; x < index; x++) {
                    indexes.remove(s.charAt(x));
                }
                start = index + 1;
            }
            indexes.put(c, i);
        }
        return Math.max(maxLength, indexes.size());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}
