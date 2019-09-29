package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-25 19:52
 */
public class hw_pingpangTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNums = sc.nextInt();
        for(int i=0;i<testNums;i++){
            int days = sc.nextInt();
            int max = 0;
            int curr = 0;

            int[] data = new int[days];
            data[0] = sc.nextInt();
            for(int j=1;j<days;j++){
                data[j] = sc.nextInt();
                curr = getCurr(data,j,curr);
                max = Math.max(curr,max);
                Arrays.sort(data);
            }

            System.out.print(max+" ");
            System.out.println(curr);
        }
    }

    private static int getCurr(int[] data, int j, int curr) {
        for(int i=j-1;i>=0;i--){
            if(data[i]<data[j]){
                curr++;
            }else if(data[i]>data[j]){
                curr--;
            }
        }
        return curr;
    }
    private static int getCurr2(int[] data, int j, int curr) {
        int i=j-1;
        while (data[i]>data[j]){
            i--;
        }
        int n= i+1;
        while (data[i]==data[j]){
            i--;
        }

        int m=i+1;
        curr+=m;
        curr-=(j-n);
        return curr;
    }
    private static int getCurr3(int[] data, int j, int curr) {

        int a = getFirstIndex(data,0,j-1,data[j]);
        curr+=a;

        while (data[a]==data[j]){
            a++;
        }
        curr-=(j-a);
        return curr;

    }

    private static int getFirstIndex(int[] data, int m, int n, int k) {
        int mid ;
        while (m<=n){
            mid = (m+n)/2;
            if(k==data[mid]){
                if(mid==m||data[mid-1]!=k){
                    return mid;
                } else {
                    n = mid -1;
                }
            } else if(k<data[mid]){
                n  =mid -1;
            } else {
                m = mid +1;

            }
        }
        return m-1;
    }
}
