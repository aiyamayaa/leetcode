package test;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 17:51
 */
public class NobugClass {


    /**
     * 求最和小于某值的最长长子串
     * @param args
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] cla = new int[];
//        for(int i = 0; i < n; i++){
//            cla[i] = sc.nextInt();
//        }
        int[] a = {5,1,1,1,2,3};
        System.out.println(maxLength(a,5,6));

    }
    public static int maxLength(int[] arr,int k,int l){
        int[] h = new int[l+1];
        int sum = 0;
        h[0] = sum;
        for(int i=0;i != l;i++){
            sum+=arr[i];
            h[i+1] = Math.max(sum,h[i]);
        }
        sum = 0;
        int len = 0,index = 0,res = 0;
        for(int i=0;i<l;i++){
            sum += arr[i];
            index = getLessIndex(h,sum-k);
            len = index == -1?0:i-index+1;
            res = Math.max(res,len);
        }
        return res;

    }

    private static int getLessIndex(int[] arr, int num) {
        int l=0,r = arr.length-1,mid =0,res = -1;
        while (l<=r){
            mid = (l+r)/2;
            if(arr[mid] >=num){
                res = mid;
                r = mid-1;
            }else {
                l =mid+1;
            }
        }
        return res;
    }
}
