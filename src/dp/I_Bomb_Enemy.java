package dp;

/**
 * @program: leetcode
 * @description: https://www.lintcode.com/problem/bomb-enemy/description
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
 * 你只能在空的地方放置炸弹.
 *  样例
 * 样例1
 *
 * 输入:
 * grid =[
 *      "0E00",
 *      "E0WE",
 *      "0E00"
 * ]
 * 输出: 3
 * 解释:
 * 把炸弹放在 (1,1) 能杀3个敌人
 * 样例2
 *
 * 输入:
 * grid =[
 *      "0E00",
 *      "EEWE",
 *      "0E00"
 * ]
 * 输出: 2
 * 解释:
 * P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或 (2,3) 能杀2个敌人
 *
 * @author: jiaxin_feng
 * @create: 2019-09-14 11:37
 */
public class I_Bomb_Enemy {
    public static void main(String[] args) {

    }

    /**
     * 思路：设置一个killed数组，如果是墙，killed[i][j]=0;如果是敌人killed[i][j]==
     * @param grid 一个表格，表示该坐标下是敌人、墙、还是空地
     * @return 求某个位置放置炸弹，那么可以在炸弹的前后左右可以炸死多少敌人
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here

        return 0;

    }
}
