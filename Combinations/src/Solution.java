import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	//
	// Deque<Integer> stack = new ArrayDeque<>();
	//
	// public List<List<Integer>> combine(int n, int k) {
	// if (n < 1 || k < 1) {
	// return null;
	// } else {
	// List<List<Integer>> list = new ArrayList<>();
	// fillStack(n, k, list);
	// return list;
	// }
	// }
	//
	// public void fillStack(int n, int k, List<List<Integer>> list) {
	// if (k == 0) {
	// List<Integer> l = new ArrayList<>(stack);
	// list.add(l);
	// } else {
	// for (int i = n; i > 0; i--) {
	// stack.push(i);
	// fillStack(i - 1, k - 1, list);
	// stack.pop();
	// }
	// }
	// }

	public List<List<Integer>> combine(int n, int k) {
		if (k == n || k == 0) {
			List<Integer> row = new LinkedList<>();
			for (int i = 1; i <= k; ++i) {
				row.add(i);
			}
			return new LinkedList<>(Arrays.asList(row));
		}
		
		List<List<Integer>> result = this.combine(n - 1, k - 1);
		for (List<Integer> list : result) {
			list.add(n);
		}
		
		result.addAll(this.combine(n - 1, k));
		
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new Solution().combine(5, 2);
		for (List<Integer> l : list) {
			System.out.println(l);
		}

		System.out.println(list.size());
	}
}