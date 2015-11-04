package my.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTests {

	@Test
	public void testBasic() {
		Solution s = new Solution();
		Assert.assertTrue(s.reverseBits(43261596) == 964176192);
		Assert.assertTrue(s.reverseBits(2147483648L) == 1);
	}
}
