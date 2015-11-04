package my.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	@Test
	public void testMaxProduct() {
		int[] nums = { -2, 0, -1 };
		Solution s = new Solution();
		Assert.assertTrue(s.maxProduct(nums) == 0);
	}

	@Test
	public void testMaxProductOfNonZeroArray() {
		int[] nums = { 2, 3, -2, 4, 5, -1 };
		Solution s = new Solution();
		Assert.assertTrue(s.maxProductOfNonZeroArray(nums) == 240);
	}
}
