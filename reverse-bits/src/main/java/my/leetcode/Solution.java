package my.leetcode;

public class Solution {
	// you need treat n as an unsigned value
	public long reverseBits(long n) {
		long number = n;
		long ret = 0;
		for (int i = 0; i < 32; i++) {
			ret = ret << 1;
			long bit = number % 2;
			number = number >>> 1;
			ret = ret + bit;
		}

		return ret;
	}
}
