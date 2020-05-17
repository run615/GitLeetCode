package Leetcode;

import java.util.PriorityQueue;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 */
public class mainmianshi1001 {
    /**
     * 优先队列
     */
    //public void merge(int[] A, int m, int[] B, int n) {
    //    // 数组已经排序过
    //    PriorityQueue<Integer> res = new PriorityQueue<>();
    //    for (int i = 0; i <  n; i++) {
    //        res.offer(B[i]);
    //    }
    //    for (int i = 0; i <  m; i++) {
    //        res.offer(A[i]);
    //    }
    //    int a = 0;
    //    for (int i = 0; i < A.length; i++) {
    //        A[i] = res.poll();
    //    }
    //}

    /**
     * 不使用额外空间,逆序操作, 双百!
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m -1; // A数组
        int j = n - 1; // B数组
        int k = m + n - 1; // A合并B数组后的长度
        for (; i > 0 && j >= 0 && k >= 0; k--) {
            if (A[i] >= B[j]) {  // 如果A数组最后一位大于B数组的最后一位
                A[k] = A[i]; // 将最大的这一位放在合并A数组的最后一位
                i--; // 开始考虑A数组从后往前一位
            } else {
                A[k] = B[j]; // 如果B数组最后一位大于A数组的最后一位
                j--;
            }
        }
        // 如果A未合并的数组弄完了，即i = 0 的时候，j元素还有剩余。这个时候A数组前j个槽都是空值，b数组依次填入即可
        if (j >= 0) { // 通过j元素是否小于0，判断B数组是否迁移完毕，
                      // 如果j大于等于0，则需要将B中剩余元素从大到小赋予A[k],直到k元素小于0；
            while (k >= 0 && j >= 0) {
                A[k--] = B[j--];
            }

        }

    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int[] B = {1, 2, 2};
        int n = 3;
        mainmianshi1001 p = new mainmianshi1001();
        p.merge(A, m, B, n);
    }
}
