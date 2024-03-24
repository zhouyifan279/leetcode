import java.util.HashMap;
import java.util.Map;

public class Solution2 {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> mp = new HashMap<>();
    mp.put(0, 1);
    int count = 0;
    int pre = 0;
    for (int i = 0; i < nums.length; i++) {
      pre += nums[i];
      if (mp.containsKey(pre - k)) {
        count += mp.get(pre - k);
      }
      mp.put(pre, mp.getOrDefault(pre, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
    System.out.println(s.subarraySum(new int[]{1, 2, 3}, 3));
  }
}
