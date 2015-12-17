public class Solution {
	public String multiply(String num1, String num2) {
		int num1Length = num1.length();
		int num2Length = num2.length();
		int[] sumArray = new int[num1Length + num2Length];

		for (int i = num1Length - 1; i >= 0; i--) {
			for (int j = num2Length - 1; j >= 0; j--) {
				int index = num1Length + num2Length - i - j - 2;
				sumArray[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				sumArray[index + 1] += sumArray[index] / 10;
				sumArray[index] %= 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean metMaxBit = false;
		for (int i = sumArray.length - 1; i >= 0; i--) {
			if (!metMaxBit) {
				if (sumArray[i] != 0 || i == 0) {
					metMaxBit = true;
				}
			}

			if (metMaxBit) {
				sb.append((char) (sumArray[i] + '0'));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().multiply("123", "456"));
	}
}