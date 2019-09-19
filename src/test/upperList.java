package test;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 21:21
 */
public class upperList {
    public static void main(String[] args) {

        int[] num = new int[]{1,1};
        System.out.println(dp(num));
    }
    public static int dp(int[] A){
        int size = A.length;
        int maxlen = 0;
        int[][] dp = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<i;j++){
                int diff = A[i] - A[j];
                if(dp[j][diff]>0){
                    dp[i][diff] = Math.max(dp[j][diff]+1,dp[i][diff]);
                }
                if(dp[i][diff]<=0) dp[i][diff] =2;

                maxlen = Math.max(maxlen,dp[i][diff]);
            }
        }
        return maxlen;
    }

}
