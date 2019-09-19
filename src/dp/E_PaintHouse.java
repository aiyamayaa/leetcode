package dp;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @program: leetcode
 * @description: 粉刷房子，
 *              要求：（1）有N中颜色，第i个房子粉刷为颜色j的花费为costs[i][j]
 *                   （2）粉刷房子的时候相邻的房子颜色不能一样
 *              输入：costs[][]代表粉刷房子的花费（第i个房子粉刷为颜色j花费为cost[i][j]）
 *              输出：求花费的最少金额
 * @author: jiaxin_feng
 * @create: 2019-09-13 18:09
 */
public class E_PaintHouse {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{14,2,11},{11,14,5,},{14,3,10}};
        //return 10;2+5+3
        System.out.println(minCost2(costs));
    }

    /**
     * 思路：粉刷房子i为颜色j的最小价格 minCos[i][j]= Math.min( minCos[i-1][0],minCos[i-1][1],...没有j）+costs[i][j]
     * @param costs:粉刷房子为特定颜色时候的价格
     * @return：返回粉刷所有房子需要的金额
     */
    public static int minCost(int[][] costs){
        int m = costs.length;
        int n = costs[0].length;
        int[][] minCos = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (i == 0) {
                    minCos[i][j] = costs[i][j];
                }else {
                    minCos[i][j]= Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        if (k != j)
                            minCos[i][j] = Math.min( minCos[i][j], minCos[i - 1][k]+ costs[i][j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;

        for(int c=0; c< minCos[0].length;c++){
            res= Math.min(res,minCos[minCos.length-1][c]);
        }
        return res;
    }


    /**
     * 房屋染色2
     *
     * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
     *
     * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。
     * 所有费用都是正整数
     *
     * 样例1
     *
     * 输入:
     * costs = [[14,2,11],[11,14,5],[14,3,10]]
     * 输出: 10
     * 说明:
     * 三个屋子分别使用第1,2,1种颜色，总花费是10。
     * 样例2
     *
     * 输入:
     * costs = [[5]]
     * 输出: 5
     *
     * 说明：
     * 只有一种颜色，一个房子，花费为5
     * 挑战
     * 用O(nk)的时间复杂度解决
     */
    /**
     * 您的提交打败了 79.80% 的提交!
     * @param costs
     * @return
     */
    public static int minCost2(int[][] costs){
        int len1 = costs.length;
        int len2 = costs[0].length;
        int[][] fee = new int[len1][len2];
        int[] num = new int[len2];
        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){

                if(i==0){
                    fee[i][j] = costs[i][j];

                }else {
                    //num[j]代表，第i-1栋房子，除了j颜色其他颜色中的最小钱数
                    fee[i][j]= costs[i][j]+num[j];
                }
                if(fee[i][j]<min0){
                    min1 = min0;
                    min0 = fee[i][j];
                }else if(fee[i][j]<min1){
                    min1 = fee[i][j];
                }

            }
            //min0表示第i栋房子的吐成某种颜色的最小钱数，min1表示第二小的钱数。
            for(int j=0;j<len2;j++){
                if(fee[i][j]==min0){    //如果j颜色是最小的钱数，那么除了j颜色以外最极小的钱数是min1
                    num[j] = min1;
                }else {
                    num[j] = min0;
                }
            }
            min0 = Integer.MAX_VALUE;
            min1 = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len2;i++){
            min = Math.min(min,fee[len1-1][i]);
        }
        return min;
    }

}
