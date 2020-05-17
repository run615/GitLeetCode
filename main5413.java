package Leetcode;

import java.util.*;

/**
 * 5413. 重新排列句子中的单词
 */
public class main5413 {
    // 用TreeMap排序，key是每个字符串的长度，value是同一长度的字符串，按序输入，所以相对位置不变
    public String arrangeWords(String text) {
        String ans = "";
        String[] split = text.split(" ");
        split[0] = split[0].toLowerCase();
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i].length())) {
                List<String> tmp = map.get(split[i].length());
                tmp.add(split[i]);
                map.put(split[i].length(), tmp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(split[i]);
                map.put(split[i].length(), list);
            }
        }
        for (int key : map.keySet()) {
            List<String> string = map.get(key);
            for (String str : string) {
                ans += str + " ";
            }
        }
        ans = ans.trim(); // 去除末尾空格
        String head = ans.substring(0, 1);
        head = head.toUpperCase(); // res的首字母大写
        ans = head + ans.substring(1);
        return ans;
    }

    public static void main(String[] args) {
        main5413 p = new main5413();
        String res = p.arrangeWords(new String("To be or not to be"));
        System.out.println(res);
    }
}
