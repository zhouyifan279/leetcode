import java.util.Arrays;

public class Solution2 {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) {
      return;
    }

    int count = gcd(nums.length, k);
    for (int start = 0; start < count; start++) {
      int prevValue = nums[start];
      int current = (start + k) % nums.length;
      int currentValue = nums[current];
      while (current != start) {
        nums[current] = prevValue;
        prevValue = currentValue;
        current = (current + k) % nums.length;
        currentValue = nums[current];
      }
      nums[current] = prevValue;
    }
  }

  private int gcd(int x, int y) {
    return y > 0 ? gcd(y, x % y) : x;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    new Solution2().rotate(nums, 3);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1, -100, 3, 99};
    new Solution2().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1};
    new Solution2().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));
  }
}
