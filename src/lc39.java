import java.util.ArrayList;
import java.util.List;

/**
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-06 21:19
 */
public class lc39 {

    public static void main(String[] args) {
        int[] candidates =new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> ress = new lc39().combinationSum(candidates,target);
        System.out.println(ress);

    }

    /**
     * 官方函数
     * 说明：通过递归的方法，找到值
     * @param candidates
     * @param target
     * @return
     */
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates==null||candidates.length==0||target==0){
            return res;
        }
        List list = new ArrayList<Integer>();
        lc39 s = new lc39();
        res =  s.helper(res,0,candidates,target,list);
        return res;
    }

    /**
     * 辅助函数
     * @param i
     * @param candidates
     * @param target
     * @param list
     */
    public  List<List<Integer>> helper( List<List<Integer>>res,int i,int[] candidates, int target,List<Integer> list) {

        if(target==0){
            List<Integer> li = new ArrayList<>(list);
            res.add(li);
            return res;
        }else if(target<0){
            return res;
        }else{
            for(int j=i;j<candidates.length;j++){
                list.add(candidates[j]);
                res = helper(res,j,candidates,target-candidates[j],list);

                list.remove(list.size()-1);
            }
            return res;
        }
    }
}
