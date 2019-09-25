package leetcode2018;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @author: jiaxin_feng
 * @create: 2019-09-24 21:06
 */
public class b_partition {

    public static void main(String[] args) {
//        IOTools.print(partition("aab"));

        System.out.println(partition2("aaba"));
    }

    public static List<List<String>> partition(String s) {
        return null;
    }

    /**
     * 动态规划：
     * 找出所有存在的回文子串
     * "aaba"->[[a, a, b, a], [aa], [aba]]
     * @param s
     * @return
     */
    public static List<String> partition2(String s) {
        boolean[][] ispartition = new boolean[s.length()][s.length()];

        for(int i=s.length()-1;i>=0;i--){
            for (int j=0;j<s.length();j++){
                if(i==j){
                    ispartition[i][j] = true;
                }else {
                    if(i+1<=j)
                        ispartition[i][j] |= (s.charAt(i)==s.charAt(j))&&(i+1==j||ispartition[i+1][j-1]);
                }

            }
        }
        IOTools.print(ispartition);
        List<List<String>> res = new ArrayList<>();
//        for(int m=0;m<s.length();m++){
//            List<String> list = new ArrayList<>();
//            for(int j=m;j<s.length();j++){
//                int i=j-m;
//                if(ispartition[i][j])
//                    list.add(s.substring(i,j+1));
//            }
//            if(list.size()!=0){
//                res.add(list);
//            }
//
//        }
        List<String> res2 =new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(ispartition[i][j])
                    res2.add(s.substring(i,j+1));
            }
        }
        return res2;

    }
}
