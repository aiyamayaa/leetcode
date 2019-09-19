package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-15 16:04
 */

/**
 * 6
 * -2 0 1 2 3 6
 * 2
 */
public class k3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();

        int[] mynums = new int[]{-2,0,1,2,3,6};
        System.out.println(getK(mynums,2));
    }

    public static int getK(int[] nums,int k){
        int res = 0;
        if(nums==null||nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int m = k-nums[i];
            for(int j=i+1;j<nums.length-1;j++){
                int n = m-nums[j];
                for(int s=j+1;s<nums.length;s++){
                    if(nums[s]<n) res++;
                }
            }
        }
        return res;
    }
}
