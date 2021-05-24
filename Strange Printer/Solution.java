public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = min;
                }
            }
        }
        return f[0][n - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strangePrinter("aaabbb"));
        System.out.println(solution.strangePrinter("aba"));
        System.out.println(solution.strangePrinter("tbgtgb"));
        System.out.println(solution.strangePrinter("ababc"));
    }
}
