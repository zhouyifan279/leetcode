import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();
        int ret = 0, s = 0;
        for (int k = 0; k < arr.length; k++) {
            int val = arr[k];
            int sk = s ^ val;
            if (cnt.containsKey(sk)) {
                ret += cnt.get(sk) * k - total.get(sk);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s = sk;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.countTriplets(new int[]{2, 3}));
        System.out.println(solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}