package test;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-15 16:55
 */
public class happy {
//    public static void main(String[] args) {
//        int[][] price = new int[][]{{100,73},{100,89},{30,21},{10,8}};
//        int[] happy = new int[]{60,35,30,10};
//        int money = 100;
//
//        int[][] price1 = new int[][]{{100,100},{80,80},{21,21}};
//        int[] happy1 = new int[]{60,35,30};
//        int money1 = 100;
//
//        Boolean[] buy = new Boolean[happy.length];
//        for(int i=0;i<happy.length;i++){
//            buy[i] = false;
//        }
//        System.out.println(gethappy(price1,happy1,money1,buy));
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] price = new int[n][2];
        int[] happy = new int[n];

        for(int i = 0; i < n; i++){

            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
            happy[i] = sc.nextInt();
        }
        Boolean[] buy = new Boolean[happy.length];
        for(int i=0;i<happy.length;i++){
            buy[i] = false;
        }
        System.out.println(gethappy(price,happy,m,buy));
    }
    /**
     * 求获得的最大快乐
     * res[i] = res[i-1]
     * 买背包i，
     * f[i]的快乐为：happy[i]+getHappy(price,happy,money-2price[i][1]+price[i][0],)
     * @param price 商品的价格和折扣的价格
     * @param happy 买商品获得的开心值
     * @param money 钱数，money+=(price[i][0]-price[i][1])
     * @return
     */

    public static int gethappy(int[][] price,int[] happy,int money,Boolean[] buy){

        if(price==null||happy==null||happy.length==0) return 0;
        int curr;
        int res = 0;
        for(int i=0;i<price.length;i++){
            if(buy[i]||money<price[i][1]){
                continue;
            }
            buy[i]=true;
            curr=happy[i]+gethappy(price,happy,money-2*price[i][1]+price[i][0],buy);

            buy[i] = false;
            res = Math.max(res,curr);
        }
        return res;


    }
}
