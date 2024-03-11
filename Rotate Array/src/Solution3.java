import java.util.Arrays;

public class Solution3 {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) {
      return;
    }

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int tmp = arr[start];
      arr[start] = arr[end];
      arr[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    new Solution3().rotate(nums, 3);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1, -100, 3, 99};
    new Solution3().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1};
    new Solution3().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));
  }
}
