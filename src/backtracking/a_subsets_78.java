package backtracking;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author: jiaxin_feng
 * @create: 2019-09-25 10:08
 */
public class a_subsets_78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));

    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.81%的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了54.65%的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        getSubset(nums,res,index,0);
        return res;
    }

    private static void getSubset(int[] nums, List<List<Integer>> res, List<Integer> index,int i) {
        if(i>=nums.length) {
            res.add(new ArrayList<>(index));
            return;
        }
        index.add(nums[i]);
        getSubset(nums,res,index,i+1);
        index.remove(index.size()-1);
        getSubset(nums,res,index,i+1);
    }
}
