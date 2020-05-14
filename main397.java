package Leetcode;

/**
 * 397. 整数替换
 *
 */
public class main397 {
    /**
     * 思路： 递归
     * 特殊情况：当n为1和Integer.MAX_VALUE时，返回值是确定的；
     * 当n为偶数时，只能替换为n/2；当n为奇数时，选择能得到最少替换次数的
     */
    public int integerReplacement(int n) {
        if(n == 1) return 0;
        if(n == Integer.MAX_VALUE) return 32;
        if((n&1)==0){  // 偶数
            return 1 + integerReplacement(n/2);
        }else{
            return 1 + Math.min(integerReplacement(n+1), integerReplacement(n-1));
        }
    }

    public static void main(String[] args) {
        main397 p = new main397();
        int res = p.integerReplacement(1234);
        System.out.println(res);
    }
}
