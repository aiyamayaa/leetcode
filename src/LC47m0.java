import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-07 15:15
 */
public class LC47m0 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> list,int[] nums ,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
        }else {

            for(int j=i;j<nums.length;j++){
                if(j>i&&(nums[j]==nums[j-1]||nums[i]==nums[j])){
                    continue;
                }
                exch(nums,i,j);
                list.add(nums[i]);
                helper(res,list,nums,i+1);
                list.remove(list.size()-1);
                exch(nums,i,j);
            }
        }
    }

    private void exch(int[] nums, int i, int j) {
        if(i==j)return;
        int m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,1,2};

        List<List<Integer>> res = new LC47m0().permuteUnique(arrays);
        System.out.println(res);
    }

}
