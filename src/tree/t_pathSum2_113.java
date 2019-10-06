package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode https://leetcode-cn.com/problems/path-sum-ii/
 * @description:
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author: jiaxin_feng
 * @create: 2019-10-01 20:01
 */
public class t_pathSum2_113 {


    /**
     * 99.10%
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        dfs(res,new ArrayList<Integer>(),root,sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if(root.left==null&&root.right==null){
            if(sum==root.val){
                list.add(root.val);
                res.add(new ArrayList(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        if(root.left!=null)
            dfs(res,list,root.left,sum-root.val);
        if(root.right!=null)
            dfs(res,list,root.right,sum-root.val);
        list.remove(list.size()-1);

    }
}
