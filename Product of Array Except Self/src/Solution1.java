public class Solution1 {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] L = new int[n];
    int[] R = new int[n];

    L[0] = 1;
    for (int i = 0; i < n - 1; i++) {
      L[i + 1] = L[i] * nums[i];
    }

    R[n - 1] = 1;
    for (int i = n - 1; i > 0; i--) {
      R[i - 1] = R[i] * nums[i];
    }

    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = L[i] * R[i];
    }
    return answer;
  }
}
