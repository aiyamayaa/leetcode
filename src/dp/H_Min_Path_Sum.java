package dp;

/**
 * @program: lintcode110
 * @description:https://www.lintcode.com/problem/minimum-path-sum/description
 * 描述
 * 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 *
 *
 * 你在同一时间只能向下或者向右移动一步
 * 您在真实的面试中是否遇到过这个题？  是
 * 题目纠错
 * 样例
 * 样例 1:
 * 	输入:  [[1,3,1],[1,5,1],[4,2,1]]
 * 	输出: 7
 *
 * 	样例解释：
 * 	路线为： 1 -> 3 -> 1 -> 1 -> 1。
 *
 *
 * 样例 2:
 * 	输入:  [[1,3,2]]
 * 	输出:  6
 *
 * 	解释:
 * 	路线是： 1 -> 3 -> 2
 * @author: jiaxin_feng
 * @create: 2019-09-14 00:53
 */
public class H_Min_Path_Sum {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum2(grid));

    }


    /**
     * 思路：path[i][j] = Math.min(path[i-1][j],path[i][j-1])+grid[i][j];
     * @param grid 输入的格子，每个格子带有一个权重
     * @return 返回从左上角到右下角的最小权重路径
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int[][] path = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    path[i][j] = grid[i][j];
                }else if(i==0){
                    path[i][j] = path[0][j-1]+grid[0][j];
                }else if(j==0){
                    path[i][j] = path[i-1][0]+grid[i][0];
                }else {
                    path[i][j] = Math.min(path[i-1][j],path[i][j-1])+grid[i][j];
                }
            }
        }
        return path[path.length-1][path[0].length-1];
    }

    /**
     * 滚动数组，降低空间复杂度
     * 您的提交打败了 64.20% 的提交!
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0) return 0;

        int[][] path = new int[2][grid[0].length];

        for(int i=0; i<grid.length ;i++){
            for(int j=0; j<grid[0].length ; j++){
                if(i==0){
                    if(j!=0)
                        path[i][j] = path[i][j-1] +grid[i][j];
                    else
                        path[0][0] = grid[0][0];
                }else if(i%2==0){
                    if(j==0)
                        path[0][j]=path[1][j]+grid[i][j];
                    else
                        path[0][j] = Math.min(path[1][j],path[0][j-1])+grid[i][j];
                }else if(i%2==1){
                    if(j==0)
                        path[1][j] = path[0][j]+grid[i][j];
                    else
                        path[1][j] = Math.min(path[0][j],path[1][j-1])+grid[i][j];
                }

            }
        }
        return path[(grid.length-1)%2][grid[0].length-1];

    }


}
