/**
 * 输入一个整形数组，求数组中连续的子数组使其和最大。比如，数组x
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-07 13:34
 */
public class ArraySum {

    /**
     * 思路：维护一个数字curr,只要当前curr>0就继续相加，小于0时候使其为它后面第一个正数
     * @param nums
     * @return
     */
    public static int maxSum(int[] nums){
        int[] res = new int[nums.length];
        int max=0,curr=0;
        int left=0,right = 0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            if(curr<0){
                while(i++<nums.length&&nums[i]<0){
                }
                if(i>=nums.length) break;
                curr=nums[i];
                left=i;
                right=i;
            }
            max=max>curr?max:curr;
            right=max>curr?right:i;
        }
        System.out.println("left:"+left);
        System.out.println("right:"+right);
        return max;
    }


    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSum(array));
    }
}
