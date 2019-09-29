package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode 组合总和
 * @description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @author: jiaxin_feng
 * @create: 2019-09-26 09:24
 */
public class a_combinationSum_39 {
    public static void main(String[] args) {
        int[] candidate = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidate,7));
    }

    /**
     * 93.1%
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res,list,candidates,target,0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int i) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i>=candidates.length||target<0){
            return;
        }
        for(int j=i;j<candidates.length;j++){
            list.add(candidates[j]);
            helper(res,list,candidates,target-candidates[j],j);
            list.remove(list.size()-1);
        }
    }

}
