/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-10 14:30
 */
public class TopK2 {

    public int[] quick(int[] nums){
        helper(nums,0, nums.length-1);
        return nums;
    }

    private void helper(int[] nums, int left, int right) {
        if(left>=right) return;
        int low = left,hight = right;
        int tmp = nums[left];
        while (low<hight){
            while (low<hight && nums[hight]>tmp){
                hight--;
            }
            nums[low] = nums[hight];
            while (low<hight && nums[low]<tmp) low++;
            nums[hight] = nums[low];
        }
        nums[low] = tmp;

        helper(nums,left,low-1);
        helper(nums,low+1,right);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,17,2,7,21,9,6};
        new TopK2().quick(nums);
        for (int a:
                nums) {
            System.out.println(a);
        }
    }
}
