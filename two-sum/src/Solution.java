import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
		for (int index = 0; index < nums.length; index++) {
			if (numIndexMap.containsKey(nums[index])) {
				return new int[] { numIndexMap.get(nums[index]) + 1, index + 1 };
			} else {
				numIndexMap.put(target - nums[index], index);
			}
		}

		return new int[] { 0, 0 };
	}
}
