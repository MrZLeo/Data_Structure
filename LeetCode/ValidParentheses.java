package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author MrZLeo
 * <p>
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String brackets) {
        if (brackets.isEmpty()) {
            return true;
        }
        Deque<String> stack = new ArrayDeque<>();
        for (String bracket : brackets.split("")) {
            if ("{".equals(bracket) || "(".equals(bracket) || "[".equals(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String element = stack.pop();
                if ("}".equals(bracket) && !"{".equals(element)) {
                    return false;
                }
                if (")".equals(bracket) && !"(".equals(element)) {
                    return false;
                }
                if ("]".equals(bracket) && !"[".equals(element)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
