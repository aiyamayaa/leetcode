package backtracking;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: N皇后的问题
 * @author: jiaxin_feng
 * @create: 2019-09-29 17:38
 */
public class a_solveNQueens_51 {

    public static void main(String[] args) {

//        IOTools.print(mark(new boolean[4][4],3,3));
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens2(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[][] h = new boolean[n][n];

        helper(res,list,n,0,h);
        return res;
    }




    /**
     * 解法一
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[][] h = new boolean[n][n];

        helper(res,list,n,0,h);
        return res;
    }

    /**
     * 解法一：通过二维数组表示
     * @param res
     * @param list
     * @param n
     * @param index
     * @param p
     */
    private static void helper(List<List<String>> res, List<String> list, int n, int index,boolean[][] p) {
        if(index==n){
            res.add(new ArrayList<>(list));
            return;
        }

        String str = "";
        for(int i=0;i<n;i++){

            if(p[index][i]==false){
                str+='Q';
                int f= i;
                while (++f<n){
                    str+='.';
                }

                list.add(str);
                helper(res,list,n,index+1,mark(p,index,i));

                list.remove(list.size()-1);
                str = str.substring(0, i);
            }
            str+='.';
        }

    }
    public static boolean[][] mark(boolean[][] arr,int a,int b){
        int[] x = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] y = new int[]{0,1,1,1,0,-1,-1,-1};
        boolean[][] res = new boolean[arr.length][arr[0].length];
        for(int i=0;i<res.length;i++){
            res[i] = arr[i].clone();
        }
        for(int i=0;i<res.length;i++){

            for(int j=0;j<8;j++){
                int new_x = a+x[j]*i;
                int new_y = b+y[j]*i;
                if(new_x>=0&&new_x<res.length&&new_y>=0&&new_y<res[0].length){
                    res[new_x][new_y] = true;
                }
            }
        }
        return res.clone();
    }

}
