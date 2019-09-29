package backtracking;


import java.util.*;

/**
 * @program: leetcode
 * @description: 子集2
 * @author: jiaxin_feng
 * @create: 2019-09-25 12:23
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class a_subsetsWithDup_90 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param nums 可能包含重复元素的整数数组 nums
     * @return 返回所有不重复的子集
     */
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> intermediateResult) {
        res.add(new LinkedList<>(intermediateResult));
        for (int i = start; i < nums.length; i++) {
            // 遇见重复元素直接跳过
            if (i <= start || nums[i] != nums[i - 1]) {
                intermediateResult.add(nums[i]);
                backtrack(nums, i + 1, intermediateResult);
                intermediateResult.removeLast();
            }
        }
    }

}
