package search;

/**
 * @program: leetcode:200
 * @description:
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-05 16:35
 */
public class dfs_numIslands_200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid1 = new char[][]{
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','1'},
                {'0','0','0','0','1'}};
        System.out.println(new dfs_numIslands_200().numIslands(grid1));
    }

    /**
     * 98.78%
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid,int i,int j) {
        if(i<0||i>= grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }else {
            grid[i][j]='0';
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }

    }
}
