package my.leetcode;

public class Solution1 implements Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		if (x < 10) {
			return true;
		}

		int len = numDigits(x);

		int highHalf = x / (int) Math.pow(10, (len + 1) / 2);
		int lowHalf = reverse(x, len / 2);
		return highHalf == lowHalf;
	}

	public int numDigits(int x) {
		int len = 0;
		while (x > 0) {
			x /= 10;
			len++;
		}
		return len;
	}

	public int reverse(int x, int numDigits) {
		int y = 0;
		for (int i = 0; i < numDigits; i++) {
			y = y * 10 + x % 10;
			x /= 10;
		}

		return y;
	}
}
