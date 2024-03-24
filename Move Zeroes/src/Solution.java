import java.util.Arrays;

public class Solution {

  public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        j++;
      }
    }
    for(; j < nums.length; j++) {
      nums[j] = 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = new int[]{0, 1, 0, 3, 12};
    s.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
