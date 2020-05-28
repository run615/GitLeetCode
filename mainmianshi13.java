package Leetcode;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class mainmianshi13 {
    /**
     * dfs，深度优先遍历
     */
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        // 第一步：先明确递归参数
        // 第二步：明确递归终止条件
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int x, int y, int m, int n, int k) {
        // 第一步：先明确递归参数
        // 第二步：明确递归终止条件
        if (x >= m || y >= n || visited[x][y] || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
            return 0;
        }
        // 第三步：递推工作
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k); // 这里只遍历了两个方向，是因为从左上角开始的，所以只要向右或者向下就可以了。
        // 求能走到的所有格子之和.简单的BFS,每加一个合法的坐标, res += 1
    }

    public static void main(String[] args) {
        mainmianshi13 p = new mainmianshi13();
        int res = p.movingCount(11, 8, 16);
        System.out.println(res);
    }
}
