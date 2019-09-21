package dp;

/**
 * @program: lintcode-394,https://www.lintcode.com/problem/coins-in-a-line/description
 * @description:
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 *
 * 请判定 先手玩家 必胜还是必败?
 *
 * 若必胜, 返回 true, 否则返回 false.
 * 您在真实的面试中是否遇到过这个题？  是
 * 题目纠错
 * 样例
 * 样例 1:
 *
 * 输入: 1
 * 输出: true
 * 样例 2:
 *
 * 输入: 4
 * 输出: true
 * 解释:
 * 先手玩家第一轮拿走一个硬币, 此时还剩三个.
 * 这时无论后手玩家拿一个还是两个, 下一次先手玩家都可以把剩下的硬币拿完.
 * 挑战
 * O(1) 时间复杂度且O(1) 存储。
 * @author: jiaxin_feng
 * @create: 2019-09-19 16:23
 */
public class R_Coins_in_a_Line {
    public static void main(String[] args) {

        System.out.println(firstWillWin(4));
    }

    /**
     * 注意：拿到最后一枚硬币的人获胜。
     * 时间复杂度：O(n),空间复杂度O(n)
     * @param n
     * @return 有n个硬币，问先手玩家是必胜还是必败。
     */
    public static boolean firstWillWin(int n) {
        // write your code here

        if(n==0) return false;
        if(n<=2) return true;
        boolean res[] = new boolean[n+1];
        res[0] = false;
        res[1] = true; res[2] = true;
        for(int i=2;i<=n;i++){
            //拿走一个两个最后都是true的话，那就必败
            if(res[i-1]&&res[i-2]) res[i] = false;
            else res[i] = true;
        }
        return res[n];
    }



    /**
     * 您的提交打败了 54.40% 的提交!
     * 时间复杂度：O(n),空间复杂度O(1)
     * @param n
     * @return 有n个硬币，问先手玩家是必胜还是必败。
     */
    public boolean firstWillWin2(int n) {
        if(n==0) return false;
        if(n<=2) return true;
        boolean res1 = true; boolean res2 = true;
        for(int i=3;i<=n;i++){
            //拿走一个两个最后都是true的话，那就必败
            if(res1&&res2) {
                res1 = res2;
                res2 = false;
            }else {
                res1 = res2;
                res2 = true;
            }
        }
        return res2;
    }
}
