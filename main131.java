package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class main131 {
    /**
     * 回溯
     */
    LinkedList<List<String>> result = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return result;
        }
        backtrack(s,0,new LinkedList<String>());
        return result;
    }
    private void backtrack(String s, int start, LinkedList<String> sub){
        // 结束条件
        if(start == s.length()){
            result.add(new LinkedList<String>(sub));
            return;
        }

        // 选择列表
        for(int i = start; i < s.length(); i++){
            // 判断所选的是否为回文
            if(judgeIsPalindrome(s.substring(start,i+1))){
                sub.add(s.substring(start,i+1));
                //判断剩余字符串是否由多个回文构成
                backtrack(s, i+1, sub);
                // 回溯
                sub.removeLast();
            }
        }
    }
    // 利用双指针判断是否为回文字段
    private boolean judgeIsPalindrome(String sub){
        int left = 0;
        int right = sub.length() - 1;
        while(left < right){
            if(sub.charAt(left) == sub.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
