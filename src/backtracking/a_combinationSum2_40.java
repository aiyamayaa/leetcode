package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author: jiaxin_feng
 * @create: 2019-09-25 22:25
 */
public class a_combinationSum2_40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));   //[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        helper2(result,list,candidates,target,0);

        return result;
    }

    /**
     * 58%
     * @param result
     * @param list
     * @param candidates
     * @param target
     * @param index
     */
    private static void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target,int index) {
        if(target==0){
            result.add(new ArrayList<>(list));
        }else if( target<0|| index >= candidates.length){

            return;
        }else {
            for(int i=index;i<candidates.length;i++){
                if(i!=index && candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                helper(result,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }

        }

    }

    /**
     * 剪枝优化97.88%
     * @param result
     * @param list
     * @param candidates
     * @param target
     * @param index
     */
    private static void helper2(List<List<Integer>> result, List<Integer> list, int[] candidates, int target,int index) {
        if(target==0){
            result.add(new ArrayList<>(list));
        }else {
            for(int i=index;i<candidates.length;i++){
                if(candidates[i]>target) return;
                if(i!=index && candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                helper(result,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }

        }

    }

}
