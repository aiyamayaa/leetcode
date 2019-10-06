package dp;

import java.util.List;

/**
 * @program: leetcode
 * @description: 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-06 15:07
 */
public class z_dp_minimumTotal_120 {
    /**
     * 42.28%
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int higth = triangle.size();
        int withd = triangle.get(triangle.size()-1).size();
        int[][] res = new int[higth][withd];
        res[0][0] = triangle.get(0).get(0);
        for(int i =1;i<res.length;i++){
            for(int j=i;j>=0;j--){
                res[i][j] = Integer.MAX_VALUE;
                if(j>=1){
                    res[i][j] = Math.min(res[i-1][j-1]+triangle.get(i).get(j),res[i][j]);
                }
                if(j<triangle.get(i).size()-1){
                    res[i][j] = Math.min(res[i-1][j]+triangle.get(i).get(j),res[i][j]);
                }
            }
        }
        int ret = res[higth-1][0];

        for(int i=0;i<higth;i++){
            ret = Math.min(res[higth-1][i],ret);
        }
        return ret;

    }

    public static void main(String[] args) {

    }

    /**
     * 86.4%
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int higth = triangle.size();

        int[][] res = new int[higth+1][higth+1];
        for(int i=higth-1;i>=0;i--){

            for(int j=0;j<=i;j++){
                res[i][j] = (Math.min(res[i+1][j],res[i+1][j+1])+triangle.get(i).get(j));
            }
        }
        return res[0][0];
    }

    /**
     * 96.23%
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            //第i行有i+1个数字
            for (int i = 0;i<=level;i++){
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }
}
