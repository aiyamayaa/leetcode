package test;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-15 17:43
 */
public class File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(getTimeAndStack(nums));
    }
    public static int getTimeAndStack(int[][] nums){
        return 0;
    }
}
