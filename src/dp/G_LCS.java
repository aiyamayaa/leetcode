package dp;


/**
 * @program:  Lintcode 397
 * @description:https://www.lintcode.com/problem/longest-continuous-increasing-subsequence/description
 * 描述
 * 中文
 *
 * English
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 * 您在真实的面试中是否遇到过这个题？  是
 * 题目纠错
 * 样例
 * 样例 1：
 *
 * 输入：[5, 4, 2, 1, 3]
 * 输出：4
 * 解释：
 * 给定 [5, 4, 2, 1, 3]，其最长上升连续子序列（LICS）为 [5, 4, 2, 1]，返回 4。
 * 样例 2：
 *
 * 输入：[5, 1, 2, 3, 4]
 * 输出：4
 * 解释：
 * 给定 [5, 1, 2, 3, 4]，其最长上升连续子序列（LICS）为 [1, 2, 3, 4]，返回 4。
 * 挑战
 * 使用 O(n) 时间和 O(1) 额外空间来解决
 *
 * @author: jiaxin_feng
 * @create: 2019-09-14 00:13
 */
public class G_LCS {

    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 2, 3, 4};
        System.out.println(longestIncreasingContinuousSubsequence2(A));
    }

    /**
     * 您的提交打败了 65.80% 的提交!
     * @param A
     * @return
     */
    public static int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A==null) return 0;
        if(A.length<=1) return A.length;
        int max1 = 0,max2 = 0;
        int curr = 1;
        for(int a=1;a<A.length;a++){
            if(A[a]>A[a-1]){
                curr++;
            }else {
                max1 = Math.max(max1,curr);
                curr=1;
            }
        }
        max1 = Math.max(max1,curr);
        curr=1;
        for(int a = A.length-2;a>=0;a--){
            if(A[a]>A[a+1]){
                curr++;
            }else {
                max2 = Math.max(max2,curr);
               curr=1;
            }
        }
        max2 = Math.max(max2,curr);
        return max1>max2?max1:max2;
    }

    /**
     * 您的提交打败了 75.80% 的提交!
     * 查看详情
     * @param A
     * @return
     */
    public static int longestIncreasingContinuousSubsequence2(int[] A) {
        if(A==null) return 0;
        if(A.length<=1) return A.length;
        // write your code here
        int max1 = 0,max2 = 0;
        int curr1 = 1,curr2 =1;
        int len = A.length;
        for(int a=1;a<len;a++){
            if(A[a]>A[a-1]){
                curr1++;
            }else {
                max1 = Math.max(max1,curr1);
                curr1=1;
            }
            if(A[len-a-1]>A[len-a]){
                curr2++;
            }else{
                max2 = Math.max(max2,curr2);
                curr2=1;
            }

        }
        max1 = Math.max(max1,curr1);
        max2 = Math.max(max2,curr2);
        return max1>max2?max1:max2;
    }


}
