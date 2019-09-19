import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-06 21:58
 */
public class lc39m2 {
    static List<List<Integer>> res=new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] candidates =new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> ress = new lc39m2().combinationSum(candidates,target);
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
//       res = new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0||target==0){
            return res;
        }
        List list = new ArrayList<Integer>();
        lc39m2 s = new lc39m2();
        s.helper(0,candidates,target,list);

        System.out.println(this.res);

        return  new ArrayList<List<Integer>>(res);
    }

    /**
     * 辅助函数
     * @param i
     * @param candidates
     * @param target
     * @param list
     */
    public void  helper( int i,int[] candidates, int target,List<Integer> list) {

        if(target==0){
            List<Integer> li = new ArrayList<>(list);
            this.res.add(li);
            System.out.println(res);
            return ;
        }else if(target<0){
            return;
        }else{
            for(int j=i;j<candidates.length;j++){
                list.add(candidates[j]);
                 helper(j,candidates,target-candidates[j],list);

                list.remove(list.size()-1);
            }
            return;
        }
    }
}
