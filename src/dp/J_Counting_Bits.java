package dp;

import string.IOTools;

/**
 * @program: lintcode https://www.lintcode.com/problem/counting-bits/description
 * @description:
 * 给出一个非负整数 num，对所有满足 0 ≤ i ≤ num 条件的数字 i 均需要计算其二进制表示中数字 1 的个数并以数组的形式返回。
 * 样例
 * 样例1
 *
 * 输入： 5
 * 输出： [0,1,1,2,1,2]
 * 解释：
 * 0~5的二进制表示分别是：
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * 每个数字中1的个数为： 0,1,1,2,1,2
 * 样例2
 *
 * 输入： 3
 * 输出： [0,1,1,2]
 * 挑战
 * 1.时间复杂度为 O(n * sizeof(integer))的解法很容易想到, 尝试挑战线性的时间复杂度 O(n) (只遍历一遍)。
 * 2.空间复杂度应为 O(n).
 * 3.你能完成这项挑战吗? 不借助任何内嵌的函数, 比如C++ 中的 __builtin_popcount 亦或是任何其他语言中的方法
 * @author: jiaxin_feng
 * @create: 2019-09-14 13:18
 */
public class J_Counting_Bits {
    public static void main(String[] args) {

        IOTools.print(countBits(5));

    }


    /**
     * 您的提交打败了 77.40% 的提交!
     * 思路：可以通过动态规划减少运算的次数，数字n中1的个数为n/2中1的个数+n%2.
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        // write your code here
        int[] nums = new int[num+1];
        nums[0]=0;
        for(int i=1;i<=num;i++){
            nums[i] = nums[i>>1]+i%2;
        }
        return nums;
    }
}
