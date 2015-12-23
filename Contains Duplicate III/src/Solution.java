import java.util.TreeSet;

public class Solution {
	// public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	// if (k < 1 || t < 0) {
	// return false;
	// }
	//
	// Map<Long, Long> map = new HashMap<Long, Long>();
	//
	// for (int i = 0; i < nums.length; i++) {
	// long reMappedNum = (long) nums[i] - Integer.MIN_VALUE;
	// long bucket = reMappedNum / ((long) t + 1);
	//
	// if (map.containsKey(bucket) || map.containsKey(bucket - 1) && reMappedNum
	// - map.get(bucket - 1) <= t
	// || map.containsKey(bucket + 1) && map.get(bucket + 1) - reMappedNum <= t)
	// {
	// return true;
	// }
	//
	// if (i >= k) {
	// long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t +
	// 1);
	// map.remove(lastBucket);
	// }
	//
	// map.put(bucket, reMappedNum);
	// }
	//
	// return false;
	// }

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) {
			return false;
		}

		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long) nums[i] + t);
			if (floor != null && floor >= nums[i] - t) {
				return true;
			}

			set.add((long) nums[i]);
			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2147483647 };
		System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
	}
}
