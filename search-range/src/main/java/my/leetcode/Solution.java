package my.leetcode;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int index = binarySearch(nums, 0, nums.length - 1, target);
		int[] result = { -1, -1 };
		if (index != -1) {
			int left = index;
			int right = index;
			result[0] = left;
			result[1] = right;
			while ((left = binarySearch(nums, 0, left - 1, target)) != -1)
				result[0] = left;
			while ((right = binarySearch(nums, right + 1, nums.length - 1,
					target)) != -1)
				result[1] = right;
		}
		return result;
	}

	protected int binarySearch(int[] A, int lo, int hi, int target) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] < target)
				lo = mid + 1;
			else if (A[mid] > target)
				hi = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
