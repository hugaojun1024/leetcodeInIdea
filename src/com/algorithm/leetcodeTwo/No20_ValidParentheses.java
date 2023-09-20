package com.algorithm.leetcodeTwo;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-06-05-[下午 7:26]-周一
 */
public class No20_ValidParentheses {
    private static final Map<Character, Character> pairs = new HashMap<Character, Character>(){{
        put('}','{');put(']','[');put(')','(');put('?','?');
    }};

    /**
     * 思想：类似于消积木游戏，将匹配的积木在栈中消除
     *
     * 算法流程如下：
     * 	      for 遍历整个Str,通过str.charAt()方法取该索引对应的字符；
     * 	      if 判断字符是否为Paris哈希表中的key,如果是
     * 				if 再判断stack栈顶元素是否为key对应的Value值或者栈不为空,如果不是
     * 						输出str字符串不是有效的括号；
     * 				else stack栈顶元素存在且为Key对应的Value值，将该栈顶元素出栈；
     * 		  else 如果不是说明是value字符，即左符号或者其他符号，
     * 				将该value字符存入栈顶；
     *        return 返回栈是否为空的结果；
     * @param str
     * @return boolean
     */
    public boolean isValid(String str) {
        int n = str.length();
        //开辟一个栈
        Deque<Character> stack = new LinkedList<Character>();
        //遍历str中每一个字符
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (pairs.containsKey(ch)) {// 如果ch为pairs中的key，判断stack中是否存在对应的Value
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {// 不存在Value或者stack为空，返回False
                    return false;
                }
                //存在对应的Value，出栈
                stack.pop();
            } else {// 如果ch不为pairs中的key,将ch字符存在stack中
                stack.push(ch);
            }
        }
        return stack.isEmpty();
//        return true;
    }

    @Test
    public void testIsValid() {
        System.out.println(isValid("@()()()")); //该测试用例输出True，所以必须是return stack.isEmpty();
    }
}
