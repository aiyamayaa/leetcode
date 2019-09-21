package dp;

/**
 * @program: https://www.lintcode.com/problem/copy-books/description
 * 437
 * @description:
 * 中文English
 * 给定 n 本书, 第 i 本书的页数为 pages[i]. 现在有 k 个人来复印这些书籍, 而每个人只能复印编号连续的一段的书, 比如一个人可以复印 pages[0], pages[1], pages[2], 但是不可以只复印 pages[0], pages[2], pages[3] 而不复印 pages[1].
 *
 * 所有人复印的速度是一样的, 复印一页需要花费一分钟, 并且所有人同时开始复印. 怎样分配这 k 个人的任务, 使得这 n 本书能够被尽快复印完?
 *
 * 返回完成复印任务最少需要的分钟数.
 *
 * 样例
 * 样例 1:
 *
 * 输入: pages = [3, 2, 4], k = 2
 * 输出: 5
 * 解释: 第一个人复印前两本书, 耗时 5 分钟. 第二个人复印第三本书, 耗时 4 分钟.
 * 样例 2:
 *
 * 输入: pages = [3, 2, 4], k = 3
 * 输出: 4
 * 解释: 三个人各复印一本书.
 * 挑战
 * 时间复杂度 O(nk)
 * @author: jiaxin_feng
 * @create: 2019-09-19 15:09
 */
public class Q_Copy_Books {
    public static void main(String[] args) {
        int[] pages = new int[]{3,2,4};
        System.out.println(copyBooks(pages,3));

    }

    /**
     * 您的提交打败了 28.00% 的提交!
     * 思路:time[i][j] = min(){  max{t[i][j-1]+pages[j]+..+pages[len]}  }
     * @param pages pages[i]表示第i本书有多少页
     * @param k 有k个人抄写
     * @return：返回k个人抄写这些书所用的最小时间
     */
    public static int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages==null|| pages.length==0) return 0;
        int len = pages.length;
        int[][] time = new int[k+1][len];
        time[1][0] = pages[0];
        for (int i=1;i< len;i++){
            time[1][i] = time[1][i-1]+pages[i];
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<len;j++){
                time[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                int max = 0;
                for(int m=j;m>=0;m--){
                    max = Math.max(time[i-1][m],sum);
                    sum+=pages[m];
                    time[i][j] = Math.min(max,time[i][j]);

                }

            }
        }
//        IOTools.print(time);
        return time[k][len-1];
    }
}
