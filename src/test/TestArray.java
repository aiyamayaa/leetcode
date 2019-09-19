package test;

import java.util.Scanner;

/**
 * @program: 猿辅导：逆时针打印数组
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 17:29
 */
public class TestArray {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] nums = new int[n][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//               nums[i][j] = sc.nextInt();
//            }
//        }
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        IOTools.print(solution(arr,4,3));
        int[] res = solution(arr,4,3);
        for (int k: res
             ) {
            System.out.print(k+" ");
        }
        System.out.println();
    }

    public static int[] solution(int[][] nums,int n,int m){
        int[] res = new int[n*m];
        int startX = 0;
        int startY=0;
        int endX = m-1;
        int endY = n-1;
        int index = 0;
        while (startX<=endX&&startY<=endY){
            if(startY<=endY){
                for(int i=startY;i<=endY;i++){
                    res[index++] = nums[i][startX];
                }
            }
            if(startX<endX){
                for(int i=startX+1;i<=endX;i++){
                    res[index++] = nums[endY][i];
                }
            }
            if(startX<endX && startY<endY){
                for(int i=endY-1;i>=startY;i--){
                    res[index++] = nums[i][endX];
                }
            }
            if(startX<endX-1&&startY<endY){
                for(int i=endX-1;i>=startX+1;i--){
                    res[index++] = nums[startY][i];
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return res;

    }

}
