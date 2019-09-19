package dp;

/**
 * @program: lintcode76:最长递增子序列：https://www.lintcode.com/problem/longest-increasing-subsequence/description
 * 可以不连续
 * 样例
 * Example 1:
 * 	Input:  [5,4,1,2,3]
 * 	Output:  3
 *
 * 	Explanation:
 * 	LIS is [1,2,3]
 *
 *
 * Example 2:
 * 	Input: [4,2,4,5,3,7]
 * 	Output:  4
 *
 * 	Explanation:
 * 	LIS is [2,4,5,7]
 * 挑战
 * Time complexity O(n^2) or O(nlogn)
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-15 13:22
 */
public class M_longest_increasing_subsequence {
    public static void main(String[] args) {

        int[] i = new int[]{4,2,4,5,3,7};
        System.out.println(longestIncreasingSubsequence(i));        //4
    }

    /**
     * 思路：longest[i] = Math.max(1,longest[m]+1 );m为前面第一个比i小的数字
     * 最后遍历一遍longest求最大值
     * @param nums 一个数字序列
     * @return：返回最长递增子序列
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int[] longest = new int[len];
        longest[0] = 1;
        for(int i=1;i<len;i++){
            int index = i-1;
            int m=0;
            while (index>=0){
                if(nums[index]<nums[i]){
                   m=Math.max(longest[index],m);
                }
                index--;
            }
            longest[i] = m+1;
        }
        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(max,longest[i]);
        }
        return max;
    }
}
