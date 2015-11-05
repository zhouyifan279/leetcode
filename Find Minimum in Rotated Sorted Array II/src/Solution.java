public class Solution {
	public int findMin(int[] nums) {
		int len = nums.length;
		int min = nums[0];
		for (int i = 0; i < len; i++) {
			if (nums[i] > nums[(i + 1) % len]) {
				min = nums[(i + 1) % len];
			}
		}
		
		return min;
	}
}