package dp;

/**
 * @program: https://www.lintcode.com/problem/coins-in-a-line-ii/description
 * @description:
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从 "左边" 依次拿走 1 或 2 个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
 *
 * 请判定 先手玩家 必胜还是必败?
 *
 * 若必胜, 返回 true, 否则返回 false.
 * 您在真实的面试中是否遇到过这个题？  是
 * 题目纠错
 * 样例
 * 样例 1:
 *
 * 输入: [1, 2, 2]
 * 输出: true
 * 解释: 先手玩家直接拿走两颗硬币即可.
 * 样例 2:
 *
 * 输入: [1, 2, 4]
 * 输出: false
 * 解释: 无论先手拿一个还是两个, 后手可以拿完, 然后总价值更高.
 * @author: jiaxin_feng
 * @create: 2019-09-19 16:42
 */
public class R_Coins_in_a_Line2 {
    public static void main(String[] args) {

    }

    /**
     * dp[i] 先手，还剩i个硬币的时候，是否必胜？
     *  如果dp[i-2]是必胜，并且values
     * @param values 硬币的金额
     * @return 价值高的人获胜，问先手必胜还是必败？
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
       return true;

    }
}
