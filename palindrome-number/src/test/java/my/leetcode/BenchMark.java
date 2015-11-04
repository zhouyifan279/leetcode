package my.leetcode;

import java.util.Random;

import org.junit.Test;

public class BenchMark {

	public void run(Solution s) {
		Random r = new Random();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s.isPalindrome(r.nextInt());
		}
		long end = System.currentTimeMillis();
		System.out.println("Test: " + s.getClass().getName());
		System.out.println("Used: " + (end - start) + " ms");
	}

	@Test
	public void test1() {
		Solution s = new Solution1();
		run(s);
	}

	@Test
	public void test2() {
		Solution s = new Solution2();
		run(s);
	}
}
