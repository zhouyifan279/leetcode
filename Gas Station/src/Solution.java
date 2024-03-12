import java.util.Arrays;

public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int i = 0;
    while (i < n) {
      int sumOfGas = 0, sumOfCoast = 0, count = 0;
      while (count < n) {
        int j = (i + count) % n;
        sumOfGas += gas[j];
        sumOfCoast += cost[j];
        if (sumOfGas < sumOfCoast) {
          break;
        }
        count++;
      }
      if (count == n) {
        return i;
      } else {
        i = i + count + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] gas = new int[]{1, 2, 3, 4, 5};
    int[] cost = new int[]{3, 4, 5, 1, 2};
//    System.out.println(new Solution().canCompleteCircuit(gas, cost));

    gas = new int[]{2, 3, 4};
    cost = new int[]{3, 4, 3};
//    System.out.println(new Solution().canCompleteCircuit(gas, cost));

    gas = new int[100000];
    Arrays.fill(gas, 1);
    cost = new int[100000];
    Arrays.fill(cost, 1);
    System.out.println(new Solution().canCompleteCircuit(gas, cost));
  }
}
