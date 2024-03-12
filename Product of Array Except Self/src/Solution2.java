public class Solution2 {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    answer[0] = 1;
    for (int i = 0; i < n - 1; i++) {
      answer[i + 1] = answer[i] * nums[i];
    }

    int R = 1;
    for (int i = n - 1; i >= 0; i--) {
      answer[i] = answer[i] * R;
      R = R * nums[i];
    }

    return answer;
  }
}
