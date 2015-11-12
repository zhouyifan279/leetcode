import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int calculate(String s) {

		s = "(" + s + ")";

		Deque<Integer> numStack = new ArrayDeque<>();
		Deque<Character> opStack = new ArrayDeque<>();

		Deque<Integer> localNumStack = new ArrayDeque<>();
		Deque<Character> localOpStack = new ArrayDeque<>();

		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-') {
				opStack.push(s.charAt(i));
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = num * 10 + s.charAt(i) - '0';
				if (i + 1 == s.length() || s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9') {
					numStack.push(num);
					num = 0;
				}
			} else if (s.charAt(i) == ')') {
				localNumStack.clear();
				localOpStack.clear();

				char op = opStack.pop();
				while (op != '(') {
					localOpStack.push(op);
					op = opStack.pop();
				}

				int count = localOpStack.size() + 1;
				while (count > 0) {
					count--;
					localNumStack.push(numStack.pop());
				}

				while (!localOpStack.isEmpty()) {
					op = localOpStack.pop();
					int num1 = localNumStack.pop();
					int num2 = localNumStack.pop();
					if (op == '+') {
						localNumStack.push(num1 + num2);
					} else {
						localNumStack.push(num1 - num2);
					}
				}

				numStack.push(localNumStack.pop());
			}
		}

		return numStack.pop();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().calculate("0"));
	}
}
