import java.util.Arrays;

public class Solution1 {

  public void rotate(int[] nums, int k) {
    int length = nums.length;
    k = k % length;
    if (k == 0) {
      return;
    }


    int[] arr = new int[k];
    System.arraycopy(nums, length - k, arr, 0, k);
    System.arraycopy(nums, 0, nums, k, length - k);
    System.arraycopy(arr, 0, nums, 0, k);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    new Solution1().rotate(nums, 3);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1, -100, 3, 99};
    new Solution1().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));

    nums = new int[]{-1};
    new Solution1().rotate(nums, 2);
    System.out.println(Arrays.toString(nums));
  }
}
