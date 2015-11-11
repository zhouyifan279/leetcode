public class Solution {

	public int myAtoi(String str) {

		if (str.length() == 0) {
			return 0;
		}

		int sign = 1, i = 0;
		long base = 0;
		char[] chs = str.toCharArray();
		while (chs[i] == ' ')
			i++;

		if (chs[i] == '-' || chs[i] == '+') {
			sign = (chs[i] == '-') ? -1 : 1;
			i++;
		}

		while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
			base = base * 10 + chs[i] - '0';
			if (base > Integer.MAX_VALUE)
				break;
			else
				i++;
		}

		if (base > Integer.MAX_VALUE) {
			if (sign == 1) {
				return Integer.MAX_VALUE;
			} else {
				return Integer.MIN_VALUE;
			}
		}

		return (int) base * sign;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().myAtoi(""));
	}
}
