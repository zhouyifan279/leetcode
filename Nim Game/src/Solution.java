
public class Solution {
	public boolean canWinNim(int n) {
		if (n % 4 != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().canWinNim(20));
	}
}