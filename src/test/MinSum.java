package test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 21:56
 */
public class MinSum {
    public static void main(String[] args) {
        int[] num = new int[]{2,4,5,6,9};

        System.out.println(minSum(num,5));

    }
    public static int minSum(int[] num,int len){
        int sum = Arrays.stream(num).sum();
        int mid= sum/2+1;
        int[][] matrix = new int[len+1][mid];
        for(int i=0;i<matrix[0].length;i++){
            matrix[0][i] = 0;
        }
        for(int i=0;i<matrix.length;i++) matrix[i][0] = 0;
        for(int i=1;i<len+1;i++){
            for(int j=1;j<mid;j++){
                matrix[i][j] = matrix[i-1][j];
                if(j-num[i-1]>0&&matrix[i-1][j-num[i-1]]+num[i-1]>matrix[i][j]){
                    matrix[i][j] = matrix[i-1][j-num[i-1]]+num[i-1];
                }
            }
        }

        return sum-matrix[len][mid-1]*2;
    }
}
