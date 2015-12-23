public class Solution extends VersionControl {
	public int firstBadVersion(int n) {
		long start = 1, end = n;

		while (start <= end) {
			long mid = (start + end) / 2;
			if (isBadVersion((int)mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return (int)start;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstBadVersion(2126753390) == 1702766719);
	}
}
