import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	static enum State {
		START, SIGN, INTEGER_PART, INT_DOT, EMP_DOT, FLOAT_PART, SYMBOL_E, EXP_SIGN, EXP_PART;
	}

	public boolean isNumber(String s) {
		String str = s.trim();
		if (str.isEmpty())
			return false;
		return isNumber(str.toCharArray(), 0, State.START);
	}

	public boolean isNumber(char[] chs, int cur, State s) {
		if (cur + 1 < chs.length) {
			switch (s) {
			case START:
				if (chs[cur] == '+' || chs[cur] == '-') {
					return isNumber(chs, cur + 1, State.SIGN);
				} else if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.INTEGER_PART);
				} else if (chs[cur] == '.') {
					return isNumber(chs, cur + 1, State.EMP_DOT);
				} else {
					return false;
				}
			case SIGN:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.INTEGER_PART);
				} else if (chs[cur] == '.') {
					return isNumber(chs, cur + 1, State.EMP_DOT);
				} else {
					return false;
				}
			case EMP_DOT:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.FLOAT_PART);
				} else {
					return false;
				}
			case INTEGER_PART:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.INTEGER_PART);
				} else if (chs[cur] == '.') {
					return isNumber(chs, cur + 1, State.INT_DOT);
				} else if (chs[cur] == 'e') {
					return isNumber(chs, cur + 1, State.SYMBOL_E);
				} else {
					return false;
				}
			case INT_DOT:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.FLOAT_PART);
				} else if (chs[cur] == 'e') {
					return isNumber(chs, cur + 1, State.SYMBOL_E);
				} else {
					return false;
				}
			case FLOAT_PART:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.FLOAT_PART);
				} else if (chs[cur] == 'e') {
					return isNumber(chs, cur + 1, State.SYMBOL_E);
				} else {
					return false;
				}
			case SYMBOL_E:
				if (chs[cur] == '+' || chs[cur] == '-') {
					return isNumber(chs, cur + 1, State.EXP_SIGN);
				} else if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.EXP_PART);
				} else {
					return false;
				}
			case EXP_SIGN:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.EXP_PART);
				} else {
					return false;
				}
			case EXP_PART:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return isNumber(chs, cur + 1, State.EXP_PART);
				} else {
					return false;
				}
			default:
				return false;
			}
		} else {
			switch (s) {
			case START:
			case SIGN:
			case EMP_DOT:
			case INT_DOT:
			case FLOAT_PART:
			case SYMBOL_E:
			case EXP_SIGN:
			case EXP_PART:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return true;
				} else {
					return false;
				}
			case INTEGER_PART:
				if (chs[cur] >= '0' && chs[cur] <= '9') {
					return true;
				} else if (chs[cur] == '.') {
					return true;
				} else {
					return false;
				}
			default:
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Map<String, Boolean> tests = new HashMap<>();
		Solution s = new Solution();

		tests.put("", false);

		tests.put(" ", false);
		tests.put(".", false);
		tests.put("+", false);
		tests.put("e", false);
		tests.put("x", false);
		tests.put("0", false);

		tests.put(" .", false);
		tests.put("+.", false);
		tests.put("+e", false);
		tests.put("++", false);
		tests.put("+ ", false);
		tests.put("+x", false);
		tests.put(".+", false);
		tests.put("..", false);
		tests.put(".e", false);
		tests.put(".x", false);
		tests.put("e+", false);
		tests.put("e.", false);
		tests.put("ee", false);
		tests.put("ex", false);
		tests.put("0+", false);

		tests.put("0", true);
		tests.put("+0", true);
		tests.put(".0", true);
		tests.put("00", true);
		tests.put("0.", true);

		tests.put(" -0.0e-1 ", true);
		tests.put(" -.0e-1 ", true);
		tests.put(" -.0e-1.1 ", false);
		tests.put(".e1", false);

		for (Entry<String, Boolean> test : tests.entrySet()) {
			if (!(s.isNumber(test.getKey()) == test.getValue())) {
				System.out.println("Error" + test);
				return;
			}
		}

		System.out.println("All tests passed");
	}
}