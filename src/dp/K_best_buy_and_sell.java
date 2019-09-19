package dp;

/**
 * @program: 买卖股票的最佳时机,149,150
 * @description: https://www.lintcode.com/problem/best-time-to-buy-and-sell-stock/description
 * @author: jiaxin_feng
 * @create: 2019-09-14 23:00
 */
public class K_best_buy_and_sell {
    public static void main(String[] args) {

        int[] input = new int[]{3, 2, 3, 1, 2};
        int[] input2 = new int[]{1, 2, 3, 4, 5};
        int[] input3 = new int[]{4,4,6,1,1,4,2,5};
        int[] input4 = new int[]{1,2};
         //买卖一次
//        System.out.println(maxProfit(input2));

        System.out.println(maxProfit22(input4,2));

    }


    /**
     * 最多买卖两次:Your submission beats 33.00% Submissions!
     * 三个状态要考虑：
     *              （1）第几天：i=0～prices.length
     *              （2）还可以交易几次:j=1,2
     *              （3）当前是否持有股票:k=0,1
     *              f[i][j][0] = Math.MAX(f[i-1][j][0] , f[i-1][j][1]+p[i])        当前没有股票的情况，可以交易一次，可以交易两次：前一天没有股票，前一天有股票卖出了
     *              f[i][j][1] = MAth.MAX(f[i-1][j][1], f[i-1][j-1][0]-p[i])                         当前有股票的情况,前一天有股票的最大值，和前一天没有股票的最大值-pi
     *
     * @return
     */
    public static int maxProfit2(int[] prices,int k){

        //第i天
        //第j次交易
        //状态：买入，卖出
        if(prices==null||prices.length==0||prices.length==1){return 0;}
        int len = prices.length;
        int[][][] profit = new int[len][k][2];
        for(int i=0;i<k;i++){
            profit[0][i][0] = (-1)*prices[i];
            profit[0][i][1] = 0;
        }

        for(int i=1;i<len;i++){
            for(int j=0;j<k;j++){
                //现在是买入状态
                if(j==0){
                    profit[i][j][0] = Math.max(profit[i-1][j][0],(-1)*prices[i]);
                } else
                    profit[i][j][0] = Math.max(profit[i-1][j][0],profit[i-1][j-1][1]-prices[i]);
                //现在是卖出状态
                profit[i][j][1] = Math.max(profit[i-1][j][1],profit[i-1][j][0]+prices[i]);
            }
        }

        int max = 0;
        for(int i=0;i<k;i++){
            max = Math.max(max,profit[len-1][i][1]);
        }
        return max;
    }

    /**
     * Your submission beats 7.40% Submissions!
     * @param prices
     * @param k
     * @return
     */
    public static int maxProfit22(int[] prices,int k){

        //第i天
        //第j次交易
        //状态：买入，卖出
        if(prices==null||prices.length==0||prices.length==1){return 0;}
        int len = prices.length;
        int[][][] profit = new int[len][k+1][2];
        for(int i=0;i<k;i++){
            profit[0][i+1][0] = (-1)*prices[i];
            profit[0][i+1][1] = 0;
        }
        for(int i=0;i<len;i++){
            profit[i][0][0] = (-1)*prices[i];
            profit[i][0][1] = 0;
        }

        for(int i=1;i<len;i++){
            for(int j=1;j<k+1;j++){
                //现在是买入状态
                profit[i][j][0] = Math.max(profit[i-1][j][0],profit[i-1][j-1][1]-prices[i]);
                //现在是卖出状态
                profit[i][j][1] = Math.max(profit[i-1][j][1],profit[i-1][j][0]+prices[i]);
            }
        }

        int max = 0;
        for(int i=1;i<k+1;i++){
            max = Math.max(max,profit[len-1][i][1]);
        }
        return max;
    }


    /**
     * 只允许买卖一次,您的提交打败了 21.20% 的提交!
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else {
                res = Math.max(res,prices[i]-min);
            }
        }
        return res;
    }


    /**
     * 可以交易无数次，买之前必须卖掉
     * 您的提交打败了 73.00% 的提交!
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        // write your code here
        int res = 0;
        int len  = prices.length;
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]){
                res += (prices[i]-prices[i-1]);
            }
        }
        return res;
    }

}
