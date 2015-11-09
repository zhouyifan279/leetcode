
public class Solution {

	// public boolean search(int[] nums, int target) {
	// int len = nums.length;
	// if (len == 0) {
	// return false;
	// } else if (len == 1) {
	// return nums[0] == target;
	// }
	//
	// int start = findMinIndex(nums);
	// int end = start + len - 1;
	//
	// if (target < nums[start] || target > nums[end % len]) {
	// return false;
	// } else {
	// return search(nums, target, start, end);
	// }
	// }
	//
	// public boolean search(int[] nums, int target, int start, int end) {
	// if (start > end) {
	// return false;
	// }
	//
	// int len = nums.length;
	//
	// int mid = (start + end) / 2 % len;
	//
	// if (nums[mid] == target || nums[start % len] == target || nums[end % len]
	// == target) {
	// return true;
	// } else if (nums[mid] > target) {
	// if (mid < start) {
	// mid = mid + len;
	// }
	// return search(nums, target, start + 1, mid - 1);
	// } else {
	// if (mid > end) {
	// end = end + len;
	// }
	//
	// return search(nums, target, mid + 1, end - 1);
	// }
	// }
	//
	// public int findMinIndex(int[] nums) {
	// int len = nums.length;
	// int minIndex = 0;
	// for (int i = 0; i < len; i++) {
	// if (nums[i] > nums[(i + 1) % len]) {
	// minIndex = (i + 1) % len;
	// }
	// }
	//
	// return minIndex;
	// }

	public boolean search(int[] nums, int target) {
		int len = nums.length;
		int prev = 0;
		int cur = 0;
		for (int i = 0; i < len; i++) {
			if (target == nums[cur]) {
				return true;
			} else if (target > nums[cur]) {
				if (nums[(cur + 1) % len] >= nums[cur]) {
					prev = cur;
					cur = (cur + 1) % len;
				} else {
					return false;
				}
			} else {
				if (nums[(cur + len - 1) % len] <= nums[cur]) {
					prev = cur;
					cur = (cur + len - 1) % len;
				} else {
					return false;
				}
			}

			if (cur == prev) {
				return nums[cur] == target;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int target = 0;
		System.out.println(new Solution().search(nums, target));
	}
}
