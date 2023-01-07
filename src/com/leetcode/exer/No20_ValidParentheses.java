package com.leetcode.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *  
 *
 * 提示：
 *
 *
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


    static {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        int length = s.length();

        char[] a = new char[length + 1];

        for (int i = 0; i < length; i++) {

            a[i] = s.charAt(i);
            System.out.print(a[i]);


            HashMap<Character, Character> map = new HashMap<Character, Character>();
            map.put('{', '}');
            map.put('(', ')');
            map.put('[', ']');

            return false;
        }
        return true;
    }
}

        /*
        int length = s.length();

        char[] a = new char[length + 1];

        for (int i = 0; i < length; i++) {

            a[i] = s.charAt(i);
            System.out.print(a[i]);
        }
        
        return false;
    }

      */

//        public List<String> generateParenthesis(int n) {
//            List<String> result = new ArrayList<>();
//            if (n == 0) return result;
//            sdf("", n, n, result);
//            return result;
//        }
//
//        private void sdf (String curStr, int left, int right, List<String> result) {
//
//            if (left == 0 && right == 0) {
//                result.add(curStr);
//                return;
//            }
//            if (left > right) {
//                return;
//            }
//            if (left > 0) {
//                sdf(curStr + "(", left - 1, right, result);
//            }
//            if (right >  0) {
//                sdf(curStr + ")", left, right - 1, result);
//            }
//        }

//    @Test
//    public void test() {
//
//        isValid("()");
//    }

