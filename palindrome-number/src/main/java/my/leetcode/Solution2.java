package my.leetcode;

public class Solution2 implements Solution {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int len = numDigits(x);

		while (len > 1) {
			int tmp = (int) Math.pow(10, len - 1);
			int head = x / tmp % 10;
			int tail = x % 10;
			if (head != tail) {
				return false;
			}

			x %= tmp;
			x /= 10;
			len -= 2;
		}

		return true;
	}

	private int numDigits(int x) {
		int len = 0;
		while (x > 0) {
			x /= 10;
			len++;
		}
		return len;
	}

}
