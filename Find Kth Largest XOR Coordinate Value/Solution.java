import java.util.Arrays;

public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] xorMatrix = new int[matrix.length][matrix[0].length];

        int s = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            xorMatrix[i][0] = s ^ matrix[i][0];
            s = xorMatrix[i][0];
            result[index++] = s;
        }

        s = xorMatrix[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            xorMatrix[0][j] = s ^ matrix[0][j];
            s = xorMatrix[0][j];
            result[index++] = s;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                xorMatrix[i][j] = xorMatrix[i - 1][j - 1] ^ xorMatrix[i][j - 1] ^ xorMatrix[i - 1][j] ^ matrix[i][j];
                result[index++] = xorMatrix[i][j];
            }
        }

        Arrays.sort(result);
        return result[result.length - k];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{5, 2},
                new int[]{1, 6}
        };
        Solution solution = new Solution();
        System.out.println(solution.kthLargestValue(matrix, 1));
        System.out.println(solution.kthLargestValue(matrix, 2));
        System.out.println(solution.kthLargestValue(matrix, 3));
        System.out.println(solution.kthLargestValue(matrix, 4));
    }
}
