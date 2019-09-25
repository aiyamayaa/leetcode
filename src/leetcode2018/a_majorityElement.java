package leetcode2018;

/**
 * @program: leetcode
 * @description:求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @author: jiaxin_feng
 * @create: 2019-09-24 16:55
 */
public class a_majorityElement {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println(majorityElement(nums));
     }

    /**
     * 通过
     * @param nums
     * @return
     */
    public static  int majorityElement(int[] nums) {
        int max = 0;
        int count = 0;
        for(int num:nums){
            if(count==0){
                max = num;
                count++;
            }else {
                if(num == max){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return max;
    }

}
