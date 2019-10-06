package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description: 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-06 09:48
 */
public class dfs_makesquare_473 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,4};
        System.out.println(new dfs_makesquare_473().makesquare(arr));
    }
    public boolean makesquare(int[] nums) {
        if(nums.length < 4 ) return false;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%4!=0) return false;
        int sideLen = sum / 4;
        Arrays.sort(nums);
        if(nums[nums.length-1]>sideLen) return false;
        return dfs(nums,nums.length-1,0,0,0,0,sum/4);
    }

    private boolean dfs(int[] nums, int i,  int i1, int i2, int i3, int i4, int i5) {
        if(i<0){
            if(i1==i5 && i2==i5 && i3==i5 && i4==i5 ) return true;
            else return false;
        }
        if(i1>i5 || i2>i5 || i3>i5 || i4>i5 ) return false;
        return dfs(nums,i-1,i1+nums[i],i2,i3,i4,i5)||
                dfs(nums,i-1,i1,i2+nums[i],i3,i4,i5)||
                dfs(nums,i-1,i1,i2,i3+nums[i],i4,i5)||
                dfs(nums,i-1,i1,i2,i3,i4+nums[i],i5);
    }
}

