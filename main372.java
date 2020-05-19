package Leetcode;

import java.util.Arrays;

/**
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 输入: a = 2, b = [1,0]
 * 输出: 1024 == 2^[10]
 */
public class main372 {
    int base = 1337;
    public int superPow(int a, int[] b) {
        // a^[1,5,6,4] = a^4 * a^[1,5,6,0] = a ^ (4 + 1560) = a^4 * (a^[1,5,6])^10
        // 这里是个递归
        if (b.length == 0) {
            return 1;
        }
        // 取出最后一位
        int last = b[b.length-1]; // 4
        b = Arrays.copyOfRange(b, 0, b.length-1); // [1,5,6,0] -> [1,5,6]
        // 利用递归，缩小规模求解
        int part1 = mypow(a,last); // a ^ 4
        int part2 = mypow(superPow(a, b), 10); // (a^[1,5,6])^10
        return part1 * part2;
    }
    /**
     *  这里不仅是pow运算，还有mod运算，因为形如 (a * b) % base 这样的运算，乘法的结果可能导致溢出.
     *  ⽐如在⼆分查找中，求中点索引时⽤ (l+r)/2 转化成 l+(r-l)/2 ，避免溢出的同时得到正确的结果。
     *  模运算在算法中⽐较常⻅： (a * b) % k = (a % k)(b % k) % k
     *  换句话说，『对乘法的结果求模，等价于先对每个因⼦都求模，然后对因⼦相乘的结果再求模』。
     */
    //private int mypow(int a, int k) {
    //    a %= base;
    //    int res = 1;
    //    for (int _ = 0; _ < k; _++) {
    //        res *= a;
    //        // 对乘法结果mod
    //        res %= base;
    //    }
    //    return res;
    //}

    /**
     * 高效求幂法
     * if(b & 1 == 1){ a^b = a * a^(b-1)}
     * if(b & 1 == 0){ a^b = (a^(b/2))^2}
     */
    private int mypow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        if ((k & 1) == 1) {
            // k 是奇数
            return (a * mypow(a, k - 1)) % base;
        } else {
            int sub = mypow(a, k / 2);
            return (sub * sub) % base;
        }
    }

    public static void main(String[] args) {
        main372 p = new main372();
        int res = p.superPow(2, new int[]{1, 0});
        System.out.println(res);
    }
}
