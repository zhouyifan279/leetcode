public class Solution {

    int BIG = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(3));
        System.out.println(solution.isPowerOfTwo(4));
    }
}