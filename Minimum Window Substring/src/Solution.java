import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int head = 0, begin = 0, end = 0, minLen = Integer.MAX_VALUE;
		int count = t.length();

		while (end < s.length()) {
			char c = s.charAt(end);

			if (map.containsKey(c)) {
				if (map.get(c) > 0) {
					count--;
				}
				map.put(c, map.get(c) - 1);
			}

			end++;

			while (count == 0) {
				if (minLen > end - begin) {
					minLen = end - begin;
					head = begin;
				}

				char cAtBegin = s.charAt(begin);
				if (map.containsKey(cAtBegin)) {
					if (map.get(cAtBegin) == 0) {
						count++;
					}
					map.put(cAtBegin, map.get(cAtBegin) + 1);
				}
				begin++;
			}

		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
	}
}