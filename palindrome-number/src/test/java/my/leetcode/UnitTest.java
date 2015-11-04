package my.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
	public void run(Solution s) {
		Assert.assertTrue(s.isPalindrome(0));
		Assert.assertTrue(s.isPalindrome(11));
		Assert.assertTrue(s.isPalindrome(101));
		Assert.assertTrue(s.isPalindrome(999));
		Assert.assertTrue(s.isPalindrome(1001));
		
		Assert.assertFalse(s.isPalindrome(10));
		Assert.assertFalse(s.isPalindrome(100));
		Assert.assertFalse(s.isPalindrome(1010));
	}

	@Test
	public void test1() {
		Solution s = new Solution1();
		run(s);
	}

	@Test
	public void test2() {
		Solution s = new Solution2();
		run(s);
	}
}
