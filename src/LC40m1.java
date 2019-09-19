import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *                                              97%
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-07 14:56
 */
public class LC40m1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(target, 0, candidates, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrack(int target, int start, int[] candidates, List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            List<Integer> list1 = new ArrayList<>(list);
            lists.add(list1);
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(target - candidates[i], i + 1, candidates, list, lists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC40m1 m = new LC40m1();
        int[] arrays = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = m.combinationSum2(arrays,target);
        System.out.println(res);
    }
}
