/**
 * 有 N (N>1000000)个数,求出其中的前K个最小的数（又被称作topK问题）
 * 想法一：当k很小的时候，可以利用类似于冒泡排序的思想，不断狡猾数据将最小/大的浮出水面
 *
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-09 19:45
 */
public class TopK {

    /**
     * 方法一：冒泡排序的思想。复杂度k*nums.length
     * @param nums
     * @param k
     * @return
     */
    public static int[] topK(int[] nums,int k){
        int[] res = new int[k];
        if(nums==null||nums.length<k){
            return res;
        }
        for(int i=0;i<k;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    exch(nums,j-1,j);
                }
            }
            res[i] = nums[i];
        }
        return res;
    }

    /**
     * 方法二：目前有问题：{3,9,17,2,7,21,9,6};k=3的时候，2会把3替换掉
     *          可以采用数据池的思想，选择其中前K个数作为数据池，后面的N-K个数与这K个数进行比较，若小于其中的任何一个数，则进行替换。
     *        复杂度和方法一的一样O(k*N)
     * @param nums
     * @param k
     * @return
     */
    public static int[] topK2(int[] nums,int k){
        int[] res = new int[k];
        if(nums==null||nums.length<k){
            return nums;
        }

        for(int i=0;i<k;i++){
            res[i] = nums[i];
        }
        for(int i=k;i<nums.length;i++){
            for(int j=0;j<k;j++){
                if(res[j]>nums[i]){
                    res[j]=nums[i];
                    break;
                }
            }
        }


        return res;
    }


    /**
     * 用类似与快速排序的法来算
     * @param nums
     * @param k
     * @return
     */
    public static int[] topK3(int[] nums,int k){
        int[] res = new int[k];
        if(nums==null||nums.length<k){
            return nums;
        }

        helper(nums,k,0,nums.length-1);
        for(int i=0;i<k;i++){
            res[i] = nums[i];
        }

        return res;
    }

    private static void helper(int[] nums, int k,int left,int right) {
        if(left==right ){
            return;
        }
        int m = nums[left];
        int low = left;
        int hight = right;

       if(low<hight){
           while (low<hight){
               while (low<hight&&nums[hight]>=m){
                   hight--;
               }
               nums[low] = nums[hight];
               while (low<hight&&nums[low]<=m){
                   low++;
               }
               nums[hight] = nums[low];
           }
           nums[low]=m;
       }
        if(low>k){
            helper(nums,k,left,low);
        }else {
            helper(nums,k,left,low);
            helper(nums,k,low+1,right);
        }

    }


    private static void exch(int[] nums, int i, int j) {
        int m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,17,2,7,21,9,6};
        int[] res = TopK.topK3(nums,3);
        for (int a:
             res) {
            System.out.println(a);
        }
    }

}
