package dp;

/**
 * @program: leetcode518
 * @description: 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-09-13 15:54
 */
public class B_Coins2 {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
    }

    /**
     * 思路：某面额下的组成方式num[i]= num[i-conins[0]] + num[i-coins[1]] +...+
     * 问题：没有通过，有重复的现象
     * @param amount 总金额
     * @param coins 硬币可用面额
     * @return 求这些硬币可以有多少种方式组成总金额数。
     */
    public static int change(int amount, int[] coins) {
        int[] nums = new int[amount+1];
        nums[0] = 1;
        for(int i=1;i<amount+1;i++){
            nums[i] = 0;
            for(int c:coins){
                if( i>=c && nums[i-c]!=0){
                    nums[i] += nums[i-c];
                }
            }
        }
        return nums[amount];

    }
}
