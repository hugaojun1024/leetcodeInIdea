package com.leetcode.exer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个'.' 或 '+' 。
 *
 * 例如，在alice@leetcode.com中，alice是 本地名 ，而leetcode.com是 域名 。
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 *
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com”会转发到同一电子邮件地址。
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 *
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * 可以同时使用这两个规则。
 *
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 *
 * 示例 1：
 *
 * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * 示例 2：
 *
 * 输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-04-[14:41]-周六
 */
public class No929_UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {

        Set<String> emailSet = new HashSet<String>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0];
            local = local.replace(".", "");//返回的是一个新的字符串
            emailSet.add(local + email.substring(i));
        }

        Iterator<String> iterator = emailSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        return emailSet.size();
    }

    @Test
    public void test(){

        String[] strs = new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        int num = numUniqueEmails(strs);
        System.out.println(num);
    }
}
