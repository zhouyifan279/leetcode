
public class Solution {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i)
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
				swap(nums, i, nums[i] - 1);

		for (int i = 0; i < n; ++i)
			if (nums[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		new Solution().firstMissingPositive(new int[] { 1, 8, 4, 77, 9832, 3262, 2, 3 });
	}
}
