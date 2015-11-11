import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {

	Pattern p = Pattern.compile("(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?");

	public boolean isNumber(String s) {
		Matcher m = p.matcher(s.trim());
		return m.matches();
	}
	
	public static void main(String[] args) {
		Map<String, Boolean> tests = new HashMap<>();
		Solution2 s = new Solution2();

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
