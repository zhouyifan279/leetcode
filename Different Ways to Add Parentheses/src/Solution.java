import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*'));

	public List<Integer> diffWaysToCompute(String input) {
		Map<String, List<Integer>> cache = new HashMap<>();
		return diffWaysToCompute(input, cache);
	}

	public List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> cache) {
		if (cache.containsKey(input))
			return cache.get(input);

		List<Integer> vals = new ArrayList<Integer>();
		for (int i = 1; i < input.length() - 1; i++) {
			if (!operators.contains(input.charAt(i))) {
				continue;
			}

			char operator = input.charAt(i);

			List<Integer> leftVals = diffWaysToCompute(input.substring(0, i), cache);
			List<Integer> rightVals = diffWaysToCompute(input.substring(i + 1), cache);

			for (int val1 : leftVals) {
				for (int val2 : rightVals) {
					if (operator == '+') {
						vals.add(val1 + val2);
					} else if (operator == '-') {
						vals.add(val1 - val2);
					} else if (operator == '*') {
						vals.add(val1 * val2);
					}
				}
			}
		}

		if (vals.size() == 0) {
			vals.add(Integer.valueOf(input));
		}

		cache.put(input, vals);
		return vals;
	}
}
