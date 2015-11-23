public class Solution {
	public int removeElement(int[] nums, int val) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (nums[low] == val) {
				nums[low] = nums[high];
				high--;
			} else {
				low++;
			}
		}

		return high + 1;
	}
}
