package tree;


import string.IOTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @description:计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * @author: jiaxin_feng
 * @create: 2019-10-02 18:27
 */
public class t_countSmaller_315_no {
    public static void main(String[] args) {
        int[] nums = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,
                32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(new t_countSmaller_315_no().countSmaller(nums));
    }
    private class BSTTree{
        int count;
        int val;
        BSTTree left;
        BSTTree right;

        public BSTTree(int val,int count) {
            this.count = count;
            this.val = val;
        }
    }

    /**
     * 19.16%
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> list = new ArrayList<>();
        if(nums==null||nums.length==0) return list;
        if(nums.length==1) {
            list.add(0);
            return list;
        }
        int[] res = new int[nums.length];
        BSTTree tree = new BSTTree(nums[nums.length-1],0);
        res[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            res[i] = insert(tree,new BSTTree(nums[i],0),0);
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

//    private int insert2(BSTTree tree, int num) {
//
//        int result=0;
//        while (tree.val!=num){
//            if(tree.val>num){
//
//                tree.count++;
//                if(tree.left==null) {
//                    tree.left = new BSTTree(num,0);
//                    return result;
//                }
//                tree=tree.left;
//            }else if(tree.val<num){
//                result+=tree.val;
//                if(tree.right==null){
//                    tree.right = new BSTTree(num,0);
//                    return result;
//                }
//                tree = tree.right;
//            }
//        }
//
//        tree.count++;
//        tree = tree.left;
//
//        return result;
//
//    }

    private int insert(BSTTree tree, BSTTree num,int res) {
        if(num.val<=tree.val){
            tree.count +=1;
            if(tree.left==null){
                tree.left=num;
                return res;
            }
            return insert(tree.left,num,res);
        }
        else{

            res+=tree.count;
            res+=1;
            if(tree.right==null){

                tree.right = num;
                return res;
            }
            return insert(tree.right,num,res);
        }
    }
    // [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]


}
