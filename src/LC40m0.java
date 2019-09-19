import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 29%
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-07 14:39
 */
public class LC40m0 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates==null||candidates.length==0||target==0){
            return res;
        }
        Arrays.sort(candidates);
        helper(res,candidates,target,new ArrayList<Integer>(),new Integer(0));
        return res;
    }

    public void helper(List<List<Integer>> res,int[] candidates, int target,List<Integer>  list,int i){
        if(target<0) return;
        else if(target==0) {
            if(!res.contains(list))
            res.add(new ArrayList<>(list));
        }
        else {
            for(int j=i;j<candidates.length;j++){
                if(candidates[j]>target) break;

                list.add(candidates[j]);
                helper(res,candidates,target-candidates[j],list,j+1);
                list.remove(list.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        int[] arrays = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        LC40m0 m = new LC40m0();
        List<List<Integer>> res = m.combinationSum2(arrays,target);
        System.out.println(res);
    }
}
