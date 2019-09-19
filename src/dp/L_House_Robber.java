package dp;

/**
 * @program: leetcode
 * @description:
 *     假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 *     给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *     您在真实的面试中是否遇到过这个题？  是
 *     题目纠错
 *     样例
 *     样例 1:
 *
 *     输入: [3, 8, 4]
 *     输出: 8
 *     解释: 仅仅打劫第二个房子.
 *     样例 2:
 *
 *     输入: [5, 2, 1, 3]
 *     输出: 8
 *     解释: 抢第一个和最后一个房子
 *     挑战
 *     O(n) 时间复杂度 且 O(1) 存储。
 *
 * @author: jiaxin_feng
 * @create: 2019-09-14 23:09
 */
public class L_House_Robber {
    public static void main(String[] args) {

        int[] i = new int[]{3, 8, 4};
        System.out.println(houseRobber(i));
    }

    /**
     * 求获得的最多的钱
     * 您的提交打败了 92.00% 的提交!
     *
     * @param A
     * @return
     */
    public static long houseRobber(int[] A) {
        // write your code here
        if(A==null||A.length==0){
            return 0;
        }
        if(A.length==1) return A[0];
        if(A.length==2){
            return A[0]>A[1]?A[0]:A[1];
        }
        long p1 = A[0];
        long p2 = A[1];
        int len = A.length;
        for(int i=2;i<len;i++){
            p1 = Math.max(p1+A[i],p2);
            long a=p1;
            p1=p2;
            p2=a;
        }
        return p2;
    }


}

