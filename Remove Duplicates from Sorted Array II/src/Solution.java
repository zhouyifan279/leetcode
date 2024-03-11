import java.util.Arrays;

public class Solution {
  public int removeDuplicates(int[] nums) {
    int lastValue = Integer.MIN_VALUE;
    int repeatCount = 0;
    int writeIndex = 0;
    int readIndex = 0;

    for (; readIndex < nums.length; readIndex++) {
      if (nums[readIndex] == lastValue) {
        repeatCount++;
      } else {
        repeatCount = 1;
      }

      if (repeatCount <= 2) {
        lastValue = nums[readIndex];
        nums[writeIndex] = lastValue;
        writeIndex++;
      }
    }
    return writeIndex;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
    int k = new Solution().removeDuplicates(nums);
    System.out.println("k: " + k);
    System.out.println("nums: " + Arrays.toString(Arrays.copyOf(nums, k)));
  }
}
