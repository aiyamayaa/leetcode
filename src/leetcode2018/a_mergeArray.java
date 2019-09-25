package leetcode2018;

/**
 * @program: leetcode
 * @description:合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @author: jiaxin_feng
 * @create: 2019-09-24 17:14
 */
public class a_mergeArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,0};
        int[] nums2 = {1};
        merge(nums1,1,nums2,1);
        IOTools.print(nums1);
    }

    /**
     * 通过
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null || nums1.length==0||nums2==null||nums2.length==0||n==0){
            return;
        }
        int i = nums1.length-1;
        m--;
        n--;
        while (m>=-1&&n>=0){
            if(m<0){
                nums1[i] =nums2[n];
                n--;
            }else{
                if(nums1[m]>=nums2[n]){
                    nums1[i]=nums1[m];
                    m--;
                }else {
                    nums1[i]=nums2[n];
                    n--;
                }
            }
            i--;
        }
    }
}
