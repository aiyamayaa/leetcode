package dp;

/**
 * @program: lintcode 513
 * @description: https://www.lintcode.com/problem/perfect-squares/description
 * @author: jiaxin_feng
 * @create: 2019-09-17 20:58
 */
public class O_perfect_squares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }


    /**
     * 思路：先设置第i位为i个1的平方的加和
     * @param n 给一个数
     * @return 求数字n最少可以由几个平方之和组成？
     */
    public static int numSquares(int n) {
        // write your code here
        int[] nums = new int[n+1];
        nums[1] = 1;

        for(int i=1;i<=n;i++){
            nums[i] = i;
            int j=1;
            while (i>=j*j){
                nums[i] = Math.min(nums[i],nums[i-j*j]+1);
                j++;
            }
        }
        return nums[n];
    }
}
