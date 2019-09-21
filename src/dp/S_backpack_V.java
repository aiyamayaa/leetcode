package dp;

/**
 * @program: lintcode 563
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-21 09:43
 */
public class S_backpack_V {
    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,7,3};
        int m = 7;
        System.out.println(backPack2(m,a));     //2
    }

    /**
     *
     * @param m   正整数m
     * @param A   数组A
     * @return  请问有多少种办法使得数组A中的元素可以组成正整数m，（A中的元素只能用一次）
     * 思路：f[i][j] 表示前i个物品可以有多少种办法组成数字j，
     *          f[i][j] = f[i-1][j] + f[i-1][j-A[i]];
     *          前i个物品可以组成j的方法 = i-1个物品组成j的方法数 + i-1个物品组成j-A[i]的方法数
     */
    public static int backPack(int m, int[] A){
        int n = A.length + 1;
        int[][] f = new int[n][m+1];
        f[0][0] = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<m+1;j++){
                f[i][j] = f[i-1][j];
                if(j-A[i-1]>=0)
                    f[i][j] += f[i-1][j-A[i-1]];
            }
        }
        return f[n-1][m];

    }

    /**
     *开辟一维数组的写法
     */
    public static int backPack2(int m, int[] A){
        int n = A.length + 1;
        int[] f = new int[m+1];
        f[0] = 1;
        for(int i=1;i<n;i++){
            for(int j=m;j>=0;j--){
                if(j>=A[i-1])
                    f[j] += f[j-A[i-1]];
            }
        }
        return f[m];

    }
}
