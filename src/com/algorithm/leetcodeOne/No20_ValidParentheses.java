package com.algorithm.leetcodeOne;

import org.junit.Test;
import java.util.*;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：1
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-09-07-[下午 8:14]-周三
 */
public class No20_ValidParentheses {

    private static final Map<Character, Character> pairs = new HashMap<Character, Character>(){{
        put('}','{');put(']','[');put(')','(');put('?','?');
    }};

    /**
     * 需用 Map集合
     * @param str
     * @return
     */
    public boolean isValid(String str) {
        if (str.length() == 0 || str.length() % 2 != 0) return false;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 优化：可以不用 Map集合
     * @param str
     * @return
     */
    public boolean isValid2(String str) {
        if(str.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:str.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }

    @Test
    public void testValidParentheses() {
        System.out.println(isValid("()[]{}{)"));
        System.out.println(isValid2("()[]{}{)"));
    }
}

