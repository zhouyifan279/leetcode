import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ret = new LinkedList<>();
    Map<Integer, Map<Integer, Set<Integer>>> triplets = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int target = -nums[i];
      Map<Integer, Integer> mp = new HashMap<>();
      for (int j = i + 1; j < nums.length; j++) {
        Integer k = mp.get(target - nums[j]);
        if (k != null) {
          int[] triplet = new int[]{nums[i], nums[j], nums[k]};
          Arrays.sort(triplet);
          Set<Integer> set = triplets.computeIfAbsent(triplet[0], k0 -> new HashMap<>())
              .computeIfAbsent(triplet[1], k2 -> new HashSet<>());
          if (set.add(triplet[2])) {
            ret.add(Arrays.asList(triplet[0], triplet[1], triplet[2]));
          }
        }
        mp.put(nums[j], j);
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    System.out.println(solution.threeSum(new int[]{0, 1, 1}));
    System.out.println(solution.threeSum(new int[]{0, 0, 0}));
  }
}
