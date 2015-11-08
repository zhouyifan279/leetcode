import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {

	HashSet<String> results = new HashSet<>();
	Stack<Character> stack = new Stack<>();

	int length;
	int parenToRemove;

	public List<String> removeInvalidParentheses(String s) {
		length = s.length();
		parenToRemove=0;
		int leftCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if(leftCount > 0 && s.charAt(i) == ')') {
				leftCount--;
				parenToRemove--;
			} else if (s.charAt(i) == ')') {
				parenToRemove++;
			} else if (s.charAt(i) == '(') {
				leftCount++;
				parenToRemove++;
			}
		}
		
		search(s, 0, "", 0);
		ArrayList<String> ret = new ArrayList<>(results);
		return ret;
	}

	public void search(String s, int pathLen, String searchPath, int removedParens) {
		if (removedParens > parenToRemove) {
			return;
		}

		if (pathLen == length) {
			if (stack.isEmpty()) {
				results.add(searchPath);
			}
			return;
		}

		char c = s.charAt(pathLen);
		if (c != '(' && c != ')') {
			search(s, pathLen + 1, searchPath + c, removedParens);
		} else {

			char d = '0';
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (c == stack.peek() || c == '(') {
					stack.push(c);
				} else {
					d = stack.pop();
				}
			}

			search(s, pathLen + 1, searchPath + c, removedParens);

			if (d != '0') {
				stack.push(d);
			} else {
				stack.pop();
			}

			search(s, pathLen + 1, searchPath, removedParens + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().removeInvalidParentheses("()())()"));
	}
}