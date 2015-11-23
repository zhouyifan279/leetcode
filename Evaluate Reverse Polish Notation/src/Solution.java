import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		Set<String> ops = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
		for (String token : tokens) {
			if (ops.contains(token)) {
				int num2 = stack.pop();
				int num1 = stack.pop();

				switch (token) {
				case "+":
					stack.push(num1 + num2);
					break;
				case "-":
					stack.push(num1 - num2);
					break;
				case "*":
					stack.push(num1 * num2);
					break;
				case "/":
					stack.push(num1 / num2);
					break;
				}

			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}
}