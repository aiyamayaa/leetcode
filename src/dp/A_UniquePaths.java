package dp;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-13 01:04
 */
public class A_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePath(2,2));
    }

    /**
     * 状态：leetcode（62）测试通过
     * @param m m行
     * @param n n列
     * @return 一个m行n列的网格，求从（0，0）位置走到（m,n）位置有多少种走法？
     * 注意：只能向下和向右走
     */
    public static int uniquePath(int m,int n){
        int[][] position = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    position[i][j] = 1;
                }else {
                    position[i][j] = position[i - 1][j] + position[i][j - 1];
                }
            }
        }
        return position[m-1][n-1];
    }
}
