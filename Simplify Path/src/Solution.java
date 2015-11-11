import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
		int start = 0;

		for (int i = 0; i < path.length(); i++) {
			String str = "";
			if (path.charAt(i) == '/') {
				str = path.substring(start, i);
				start = i + 1;
			} else if (i == path.length() - 1) {
				str = path.substring(start);
			}

			if (str.equals("..")) {
				if(!stack.isEmpty()) stack.pop();
			} else {
				if (!str.equals("") && !str.equals("."))
					stack.push(str);
			}

		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append("/" + stack.pollLast());
		}

		String ret = sb.toString();
		if (ret.length() == 0) {
			ret = "/";
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("/.."));
	}
}
