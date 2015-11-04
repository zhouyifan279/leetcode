package my.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
	private int[] nums = { 1, 2, 3, 4, 4, 5, 6, 6, 8 };

	private int target = 6;
	private Solution s = new Solution();

	@Test
	public void testFindRoughRange() {
		int index = s.binarySearch(nums, 0, nums.length - 1, target);
		Assert.assertTrue(index == 6);
	}

	@Test
	public void testSearchRange1() {
		int[] result = s.searchRange(nums, target);
		Assert.assertTrue(result[0] == 6 && result[1] == 7);
	}
}
