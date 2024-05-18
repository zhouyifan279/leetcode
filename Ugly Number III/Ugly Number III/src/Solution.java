public class Solution {

  public int nthUglyNumber(int n, int a, int b, int c) {
    int left = 1, right = (int) 2e9;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long t = f(mid, a, b, c);
      if (t < n) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  long f(int num, int a, int b, int c) {
    long abLcm = num / lcm(a, b);
    long acLcm = num / lcm(a, c);
    long bcLcm = num / lcm(b, c);
    long abcLcm = num / lcm(a, lcm(b, c));
    return num / a + num / b + num / c - abLcm - acLcm - bcLcm + abcLcm;
  }

  long gcd(long x, long y) {
    if (x < y) {
      return gcd(y, x);
    }

    if (y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }

  long lcm(long x, long y) {
    return x * y / gcd(x, y);
  }
}
