package dp;


/**
 * @program: lintcode 92
 * @description: https://www.lintcode.com/problem/backpack/description
 * 在n个物品中挑选若干物品装入背包，最多能装多大重量的物品？假设背包的大小为m，每个物品的大小为A[i]
 * 样例
 * 样例 1:
 * 	输入:  [3,4,8,5], backpack size=10
 * 	输出:  9
 *
 * 样例 2:
 * 	输入:  [2,3,5,7], backpack size=12
 * 	输出:  12
 *
 * 挑战
 * O(n x m) time and O(m) memory.
 *
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * @author: jiaxin_feng
 * @create: 2019-09-19 17:11
 */
public class S_Backpack {
    public static void main(String[] args) {
        int[] A = {3,4,8,5};
        System.out.println(backPack(10,A));     //9
    }

    /**
     * res[i]表示当前背包容量是i的时候，可以最多装多少
     * res[i] = res[i-a]+a;
     * @param m
     * @param A
     * @return
     */
    public static int backPack(int m, int[] A) {
        boolean[][] res = new boolean[A.length+1][m+1];
        res[0][0] = true;
        for(int i=1;i<=A.length;i++){
            for(int j=0;j<=m;j++){
                res[i][j] = res[i-1][j];
                if(j>=A[i-1]){
                    res[i][j] = res[i][j] || res[i-1][j-A[i-1]];
                }
            }
        }

        for(int i=m;i>=0;i--){
            if(res[A.length][i]){
                return i;
            }
        }
        return 0;
    }


}
