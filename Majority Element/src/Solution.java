import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int count = 0;
    for (int i : nums) {
      if (count == 0) {
        candidate = i;
      }

      if (i == candidate) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
    int n = new Solution().majorityElement(nums);
    System.out.println(n);
  }

}
