public class Solution {

  public boolean canJump(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i <= maxIndex; i++) {
      if (i + nums[i] > maxIndex) {
        maxIndex = Math.min(i + nums[i], nums.length - 1);
      }
    }
    return maxIndex >= nums.length - 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 1, 1, 4};
    System.out.println(new Solution().canJump(nums));
    nums = new int[]{3, 2, 1, 0, 4};
    System.out.println(new Solution().canJump(nums));
  }
}
