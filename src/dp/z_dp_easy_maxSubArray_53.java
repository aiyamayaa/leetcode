package dp;

/**
 * @program: leetcode
 * @description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-06 12:11
 */
public class z_dp_easy_maxSubArray_53 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new z_dp_easy_maxSubArray_53().maxSubArray(arr));
    }

    /**
     * 99.97%
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int step = 0;
        for(int i=0;i<nums.length;i++){
            if(step<0){
                step = nums[i];
            }else{
                step += nums[i];
            }
            res = Math.max(res,step);
        }
        return res;
    }
    /**
     * 99.97%
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int k=0;
        while(k<nums.length&&nums[k]<=0){
            max = Math.max(max,nums[k]);
            k++;
        }
        int curr=0;
        for(int i=k;i<nums.length;i++){
            int a = 0;
            if(curr+nums[i]<=0){
                a = nums[i];
                curr=Math.max(0,nums[i]);
            }else {
                curr +=nums[i];
                a = curr;
            }
            max = Math.max(a,max);
        }
        return max;
    }
}
