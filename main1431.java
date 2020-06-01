package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1431.拥有最多糖果的孩子
 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 */
public class main1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> res = new ArrayList();
        int len = candies.length;
        // 找到当前数组中最大的值，设置为max。
        // 遍历当前孩子拥有的苹果树，然后加上extraCandies，看是否大于最大值max，大于则res.append(true),小于则res.append(false);
        int max = 0;
        for (int num : candies) {
            if (num > max) {
                max = num;
            }
        }
        for (int num : candies) {
            if (num + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        main1431 p = new main1431();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> res = p.kidsWithCandies(candies, extraCandies);
        System.out.println(res);
    }
}
