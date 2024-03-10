import java.util.Arrays;

public class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, index = m + n - 1;
    for (; i >= 0 && j >= 0; index--) {
      if (nums1[i] >= nums2[j]) {
        nums1[index] = nums1[i];
        i--;
      } else {
        nums1[index] = nums2[j];
        j--;
      }
    }

    for (; j >= 0; j--, index--) {
      nums1[index] = nums2[j];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    new Solution().merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
}
