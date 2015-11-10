
public class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] a = new int[nums.length];
		int len = 0;
		for (int i : nums) {
			int j = binarySearch(a, 0, len - 1, i);
			a[j] = i;
			if (j == len)
				len++;
		}
		return len;
	}

	public int binarySearch(int[] a, int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key <= a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(new Solution().lengthOfLIS(nums));
	}
}
