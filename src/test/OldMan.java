package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-15 16:29
 */
public class OldMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(getMax(nums));
    }

    private static int getMax(int[] nums) {

        int max = 0;
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int k = len/2+len%2;
        for(int i=0;i<k;i++){
            for(int j=len-1;j>i;j--){
                if(nums[j]>nums[j-1]){
                    int a = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = a;
                }
            }
            max+=nums[i];
        }

        return max;
    }
    private static int getMax2(int[] nums) {

        int res = 0;
        if(nums==null||nums.length==0){
            return 0;
        }

        int len = nums.length;
        int k = len/2+len%2;
        for(int i=0;i<k;i++){
            res+=Math.max(nums[i],nums[len-1-i]);

        }
        return res;
    }
    private static int getMax3(int[] nums) {

        int res = 0;
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        int len = nums.length;
        int k = len/2+len%2;
        for(int i=0;i<k;i++){
           res+=nums[i];

        }
        return res;
    }
}
