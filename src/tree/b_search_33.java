package tree;

/**
 * @program: leetcode
 * @description: binary_search 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author: jiaxin_feng
 * @create: 2019-10-02 15:23
 */
public class b_search_33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {5,1,3};
//        System.out.println(search(nums,0)); //4
        System.out.println(search(nums2,5));
    }

    /**
     * 97.17%
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int begin = nums[0];
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid  = left+(right-left)/2;
            if(nums[mid]>=begin){
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target||target<begin){
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }else {
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target||target>=begin){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
