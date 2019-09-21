package dp;

import java.util.StringTokenizer;

/**
 * @program: lintcode:https://www.lintcode.com/problem/palindrome-partitioning-ii/description
 * @description: 分割回文串
 * @author: jiaxin_feng
 * @create: 2019-09-19 13:47
 * 描述
 * 中文
 *
 * English
 * 给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
 *
 * 最少需要分割几次?
 * 您在真实的面试中是否遇到过这个题？  是
 * 题目纠错
 * 样例
 * 样例 1:
 *
 * 输入: "a"
 * 输出: 0
 * 解释: "a" 本身就是回文串, 无需分割
 * 样例 2:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 将 "aab" 分割一次, 得到 "aa" 和 "b", 它们都是回文串.
 */
public class P_palindrome_partitioning_2 {
    public static void main(String[] args) {

        IOTools.print(ispalindrome("dde"));
        System.out.println(minCut("dde"));
    }

    /**
     * 您的提交打败了 3.00% 的提交!
     * res[i] = min{1+res[i-j](j=0~i-1)}
     * @param s
     * @return
     */
    public static int minCut(String s) {
        // write your code here
        int len = s.length();
        int[] res = new int[len+1];
        res[0] = 0;
        boolean[][] is = ispalindrome(s) ;
        for(int i=1;i<=len;i++){
            res[i] = i;
            for(int j=i;j>=1;j--){
                if(is[j-1][i-1]){

                    res[i] = Math.min(res[i],res[j-1]+1);
                }
            }
        }
        return res[len]-1;
    }

    private static boolean[][] ispalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;i+j<len&&i-j>=0;j++){
                if(s.charAt(i+j)==s.charAt(i-j)){
                    res[i-j][i+j] = true;
                } else {
                    break;
                }
            }


        }
        for(int i=0;i<len;i++){
            for(int j=0;i+j+1<len&&i-j>=0;j++){
                if(s.charAt(i+j+1)==s.charAt(i-j)){
                    res[i-j][i+j+1] = true;
                } else {
                    break;
                }
            }


        }
        return res;
    }
}
