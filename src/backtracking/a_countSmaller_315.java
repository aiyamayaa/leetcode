package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode:https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @description: 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * @author: jiaxin_feng
 * @create: 2019-10-01 19:23
 */
public class a_countSmaller_315 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        return res;
    }


    public static void main(String[] args) {

    }
}
