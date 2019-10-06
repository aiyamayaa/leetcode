package dp;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-06 13:03
 */
public class z_dp_mid_coinChange_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));//3
    }

    /**
     * 87.37%
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        amounts[0] = 0;

        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            amounts[i] = amount+1;
        }
        for(int i=1;i<=amount;i++){

            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    amounts[i] = Math.min(amounts[i-coins[j]]+1,amounts[i]);
                }else {
                    break;
                }
            }

        }
        return amounts[amount]==(amount+1)?-1:amounts[amount];
    }
}
