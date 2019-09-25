package dp;

/**
 * @program: lintcode 564
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-21 10:06
 */
public class S_backpack_VI {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,4};
        int m = 4;
        System.out.println(backPack(4,A));          //6
    }

    /**
     *
     * @param m 给正整数m
     * @param A 给定数组A[]
     *          将A[]中的数字放入背包m中
     * @return  请问A[]中的元素有多少种方法能组成m,(A中的元素可以用多次)
     * 思路：定义一个f[i][j]表示组成数字j用前i个元素，有多少种可行方案。
     *
     * */
    public static int backPack(int m, int[] A){
        int[] f = new int[m+1];
        f[0] = 1;
        for(int i=1;i<=m;i++){
            f[i] = 0;
            for(int j=0;j<A.length;j++){
                if(i>=A[j])
                    f[i]+=f[i-A[j]];
            }
        }

        return f[m];
    }
}
