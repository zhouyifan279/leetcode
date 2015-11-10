
public class Solution {
	public int mySqrt(int x) {
		long r = x;
		while (r * r > x) {
			r = (r + x / r) / 2;
		}
		return (int) r;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().mySqrt(2147395599));
	}
}
