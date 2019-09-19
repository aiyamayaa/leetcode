import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**执行用时 : 6 ms, 在所有 Java 提交中击败了94.56%的用户
 内存消耗 :40.1 MB, 在所有 Java 提交中击败了77.79%的用户
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-06 22:16
 */
public class lc39m3 {
    public static void main(String[] args) {
        int[] candidates =new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> ress = new lc39m3().combinationSum(candidates,target);
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
        Arrays.sort(candidates);        //关键
        List list = new ArrayList<Integer>();
        lc39m3 s = new lc39m3();
         s.helper(res,0,candidates,target,list);
        return res;
    }

    /**
     * 辅助函数
     * @param i
     * @param candidates
     * @param target
     * @param list
     */
    public void helper( List<List<Integer>>res,int i,int[] candidates, int target,List<Integer> list) {

        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }else if(target<0){
            return;
        }else{
            for(int j=i;j<candidates.length;j++){
                if(candidates[j]>target) break;     //关键
                list.add(candidates[j]);
                helper(res,j,candidates,target-candidates[j],list);

                list.remove(list.size()-1);
            }
            return;
        }
    }
}
