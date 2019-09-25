package dp;

/**
 * @program: lintcode  125
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-21 10:43
 */
public class S_backpack_II {
    public static void main(String[] args) {

        int[] A = new int[]{2, 3, 5, 7};

        int[] V = new int[]{1, 5, 2, 4};
        int m = 10;
        System.out.println(backPack(m,A,V));        //15    可以重复
        System.out.println(backPack2(m,A,V));       //9     不可以重复
    }

    /**
     * 不能重复:您的提交打败了 56.60% 的提交!
     * @param m
     * @param A
     * @param V
     * @return
     */
    public static int backPack2(int m, int[] A,int[] V){

        int[][] f = new int[A.length+1][m+1];
        f[0][0] = 0;
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=m;j++){
                if(j>=A[i-1])
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-A[i-1]]+V[i-1]);
                else
                    f[i][j] = f[i-1][j];
            }
        }
        IOTools.print(f);
        return f[A.length][m];
    }
    /**
     * 可以重复
     * @param m  背包的容量是m
     * @param A  第i个物品的重量是A[i]
     * @param V  第i个物品的价值是V[i]
     * @return   求背包能装的最大的价值的物品是多少（1、可以重复装；2、不可以重复装）
     */
    public static int backPack(int m, int[] A,int[] V){
        int[] f = new int[m+1];
        f[0] = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<A.length;j++){
                if(i>=A[j]){
                    f[i] = Math.max(f[i],f[i-A[j]]+V[j]);
                }
            }
        }
        return f[m];
    }


}
