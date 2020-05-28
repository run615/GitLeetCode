package Leetcode;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class main394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int loop = 0;
        LinkedList<Integer> stack_loop = new LinkedList<>(); // 当 c 为数字的时候，将数字字符转化为数字，用于后序倍数计算。
        LinkedList<String> stack_res = new LinkedList<>();  // 当 c 为字母的时候，在res尾部添加c。
        for (Character c : s.toCharArray()) {
            if (c == '[') {  // 当 c 为 [ 时，将当前 loop 和 res 入栈，并分别置空置 0：
                stack_loop.addLast(loop); // addLast方法用于在LinkedList的末尾插入特定元素
                stack_res.addLast(res.toString());
                loop = 0; // 当前的loop已经取出之后，就需要重置，重新记录下一个[]的loop
                res = new StringBuilder(); // 同理，res取出之后需要重置,重新记录下一个[]
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_loop = stack_loop.removeLast(); // cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2
                for (int i = 0; i < cur_loop; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp); //
            } else if (c >= '0' && c <= '9') {  // 当 c 是数字的时候
                String tmp = c + "";
                Integer.parseInt(tmp);
                loop = loop * 10 + Integer.parseInt(c + ""); // Integer.parseInt 可以将字符串变为数字
            } else {
                res.append(c); // 如果是字母就直接添加进尾部
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        main394 p = new main394();
        String s = "10[leetcode]";
        String res = p.decodeString(s);
        System.out.println(res);
    }
}
