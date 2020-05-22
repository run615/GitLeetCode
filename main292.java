package Leetcode;

/**
 * 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */
public class main292 {
    /**
     * 反向思考：
     * 1. 如果我能赢，那么最后轮到我取石子的时候必须要剩下1~3颗石子，这样才能一把拿完。
     * 2. 想要满足1，必须得让对手拿的时候还有4颗；
     * 3. 想要满足2，必须得我选择的时候还有5~7颗石子；
     * 4. 想要满足3，必须让对手面对8颗石子
     * ...
     * 这样循环下去，只要是踩到4的倍数，就落入了圈套，永远逃不出4的倍数，而且一定会输。
     */
    public boolean canWinNim(int n) {
        // 如果上来就是4的倍数，就只能认输了；
        // 否则，把对方控制在4的倍数，必胜
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        main292 p = new main292();
        boolean res = p.canWinNim(3);
        if (res) {
            System.out.println("赢了");
        } else {
            System.out.println("输了");
        }
    }
}
