package dp;

/**
 * @program: leetcode
 * @description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class C_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{2,3,1,1,4}));
        System.out.println(canJump1(new int[]{3,2,1,0,4}));
    }

    /**
     * 贪心算法
     * 思想：维护一个值maxDistance，表示从当前位置青蛙可以跳到的最远的位置
     *      （1）如果maxDistance大于数组长度，直接返回true
     *       (2) 如果maxDistance小于当前下标，直接返回false
     * @param nums
     * @return
     */
    public static Boolean canJump1(int[] nums)
    {
        int maxDistance = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxDistance) return false;
            maxDistance = Math.max(maxDistance,i+nums[i]);
            if(maxDistance>nums.length) return true;
        }
        return maxDistance==nums.length?true:false;
    }




}
