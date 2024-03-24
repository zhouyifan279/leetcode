import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    int max = 0;
    for (int n : set) {
      if (!set.contains(n - 1)) {
        int count = 1;
        while (set.contains(n + 1)) {
          n++;
          count++;
        }
        if (count > max) {
          max = count;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
  }
}
