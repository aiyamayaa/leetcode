package dp;

/**
 * @program: leetcode  坐标型动态规划
 * @description: 机器人在网格上移动，有障碍，求机器人有多少种方法从左上角走到右下角
 * @author: jiaxin_feng
 * @create: 2019-09-13 15:06
 */
public class D_UniquePath2 {

    /**
     * 注意这种情况：[[0,0],[1,1],[0,0]]
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathWithObstacles(nums));

    }

    /**
     * 状态：leetcode（63）测试通过
     * @param obstacleGrid ：输入为一个地图，其中坐标（x,y）为0表示该坐标下有障碍，否则机器人可以通行
     * @return：求机器人有多少种路径从左上角走到到右下角？（0，0）->(coordinates.length,coordinates[0].length)
     * 注意：机器人只能向右或者向下走
     *
     * 思路：机器人从（0，0）走到（x,y）坐标的路径数为：（x-1,y）+(x,y-1)坐标的路径数的和。
     *     如果地图坐标上某点为障碍，到达该点的路径数为0
     */
    public static int uniquePathWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid == null || obstacleGrid.length == 0|| obstacleGrid[0].length==0){
            return 0;
        }
        int paths[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        paths[0][0] = 1;
        for (int i=0;i<obstacleGrid.length;i++){
            for (int j=0;j<obstacleGrid[0].length;j++){

                if(obstacleGrid[i][j] == 1){
                    paths[i][j] = 0;
                }else if(i!=0||j!=0){
                    paths[i][j] = 0;
                    if(i!=0){
                        paths[i][j]+=paths[i-1][j];
                    }
                    if(j!=0){
                        paths[i][j]+=paths[i][j-1];
                    }
                }
            }
        }
        return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
