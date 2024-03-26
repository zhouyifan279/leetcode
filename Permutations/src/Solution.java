import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new LinkedList<>();
    List<Integer> output = new LinkedList<>();
    for (int n : nums) {
      output.add(n);
    }
    backtrack(ret, output, 0, nums.length);
    return ret;
  }

  private void backtrack(List<List<Integer>> ret, List<Integer> output, int first, int n) {
    if (first == n - 1) {
      ret.add(new ArrayList<>(output));
      return;
    }

    for (int i = first; i < n; i++) {
      Collections.swap(output, first, i);
      backtrack(ret, output, first + 1, n);
      Collections.swap(output, first, i);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.permute(new int[]{1, 2, 3, 4, 5})
        .forEach(System.out::println);
  }
}