import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *                                                  92%
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-07 15:04
 */
public class LC46m0 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> objects, int[] nums, int i) {
        if(i==nums.length){
            res.add(new ArrayList<Integer>(objects));
        }else {
            for (int j=i;j<nums.length;j++){

                exc(nums,i,j);
                objects.add(nums[i]);
                helper(res,objects,nums,i+1);
                objects.remove(objects.size()-1);
                exc(nums,i,j);
            }
        }
    }

    private void exc(int[] nums, int i, int j) {
        if(i==j) return;
        int m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3};

        List<List<Integer>> res = new LC46m0().permute(arrays);
        System.out.println(res);
    }
}
