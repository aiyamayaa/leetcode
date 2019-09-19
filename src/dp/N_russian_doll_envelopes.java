package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: lintcode602
 * @description: 俄罗斯套娃信封
 * @author: jiaxin_feng
 * @create: 2019-09-17 19:51
 */
public class N_russian_doll_envelopes {
    public static void main(String[] args) {

        int[][] input = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(input));
    }

    /**
     * O（N^2）的解法,你的代码运行时间超过了限制
     * @param envelopes  n行两列的数组，第一列表示长度，第二列表示宽度
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        // write your code here
        Arrays.sort(envelopes,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        int[] dp = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            dp[i] = 1;
           for(int j=i;j>=0;j--){
               if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                   dp[i] = Math.max(dp[i],dp[j]+1);
               }
           }
        }
        int max=1;
        for(int i:dp){
            max = max>i?max:i;
        }
        return max;
    }

}
