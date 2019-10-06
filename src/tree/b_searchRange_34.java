package tree;

import string.IOTools;

/**
 * @program: leetcode
 * @description: binary_search 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author: jiaxin_feng
 * @create: 2019-10-02 15:07
 */
public class b_searchRange_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        IOTools.print(searchRange(nums,8));
    }

    /**
     * 100%
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums==null||nums.length==0) return res;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if(left<nums.length&&nums[left]==target)
            res[0] = left;
        else
            return res;
        left=0;
        right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if(right>=0&&nums[right]==target)
            res[1] = right;
        return res;
    }
}
