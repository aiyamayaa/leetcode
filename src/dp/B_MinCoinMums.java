package dp;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-13 00:52
 */
public class B_MinCoinMums {
    public static void main(String[] args) {

        int[] conins = new int[]{2,3,7};
        System.out.println(minCoins(conins,34));
    }

    /**
     *
     * @param conins 硬币面额 {2,3,7}
     * @param num  硬币组成的值为num
     * @return 求如果要组成num的面额，最少要多少硬币？
     */
    public static int minCoins(int[] conins,int num) {
        int[] nums = new int[num+1];
        nums[0] = 0;
        for(int i=1;i<nums.length;i++)
        {
            nums[i] = Integer.MAX_VALUE;
            for(int j=0;j<conins.length;j++)
            {
                if(conins[j]<=i && nums[i-conins[j]]!=Integer.MAX_VALUE)
                {
                    nums[i] = Math.min(nums[i],nums[i-conins[j]]+1);
                }
            }
        }
        if(nums[num]!=Integer.MAX_VALUE)
        {
            return nums[num];
        }
        return -1;
    }
}
