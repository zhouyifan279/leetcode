public class Solution {
	public boolean isAnagram(String s, String t) {

		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int indexS = s.charAt(i) - 'a';
			alphabet[indexS] += 1;
		}

		for (int i = 0; i < t.length(); i++) {
			int indexT = t.charAt(i) - 'a';
			alphabet[indexT] -= 1;
			if (alphabet[indexT] < 0) {
				return false;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] != 0) {
				return false;
			}
		}
		
		return true;

	}
}