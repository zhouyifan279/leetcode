public class Solution {
	public int trailingZeroes(int n) {
		int count = 0;
		while (n >= 5) {
			count += n / 5;
			n /= 5;
		}

		return count;
	}

	public static void main(String[] args) {
		long s = System.nanoTime();
		System.out.println(new Solution().trailingZeroes(1808548329));
		long e = System.nanoTime();
		System.out.println(e - s);
	}
}