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
#include <string.h>
#include <stdbool.h>

bool isValid(char * s){
    int len = strlen(s);
    char str[10000] = {0};
    int top = -1;
    for(int i = 0; i < len; i++) {
        if(s[i] == '{' || s[i] == '(' || s[i] == '['){
            str[++top] = s[i];
        }
        else{
            if(top == -1){
                return false;
            }
            char c = str[top--];
            if(s[i] == '}'){
                if(c != '{'){
                    return false;
                }
            } else if(s[i] == ')') {
                if(c != '(') {
                    return false;
                }
            } else if(s[i] == ']') {
                if(c != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    return top==-1;
}