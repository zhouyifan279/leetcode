package my.leetcode;

import java.util.Arrays;

public class Solution {
	public int maxProduct(int[] nums) {
		int startIndex = 0;
		int max = nums[0];
		boolean hasZero = false;
		while (startIndex < nums.length) {
			int retLen = 0;
			int[] ret = new int[nums.length];
			int index = startIndex;
			while (index < nums.length && nums[index] != 0) {
				ret[retLen] = nums[index];
				retLen++;
				index++;
			}

			if (retLen == 0) {
				startIndex++;
				hasZero = true;
				continue;
			} else {
				startIndex = startIndex + retLen;
			}

			int maxInSubArray = maxProductOfNonZeroArray(Arrays.copyOf(ret,
					retLen));
			if (max < maxInSubArray) {
				max = maxInSubArray;
			}
		}

		if (max < 0 && hasZero) {
			max = 0;
		}

		return max;
	}

	public int maxProductOfNonZeroArray(int[] nums) {
		int product = 1;
		for (int i : nums) {
			product = product * i;
		}

		if (product > 0 || nums.length == 1) {
			return product;
		} else {
			int left = maxProductOfNonZeroArray(Arrays.copyOf(nums,
					nums.length - 1));
			int right = maxProductOfNonZeroArray(Arrays.copyOfRange(nums, 1,
					nums.length));

			return Math.max(left, right);
		}
	}
}
