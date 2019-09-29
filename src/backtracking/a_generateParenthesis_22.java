package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode 括号生成
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-26 10:05
 */
public class a_generateParenthesis_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result,n,n,"");
        return result;
    }

    /**
     * 91.43%
     * @param result
     * @param left
     * @param right
     * @param string
     */
    private static void helper(List<String> result, int left, int right,String string) {
        if(left==0&&right==0){
            result.add(string);
            return;
        }
        if(left>right) return;
        if(left>0){
            helper(result,left-1,right,string+"(");
        }
        if(left<right){
            helper(result,left,right-1,string+")");
        }
    }
}
