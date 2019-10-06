package tree;

/**
 * @program: leetcode https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @description:二叉树展开为链表
 *给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author: jiaxin_feng
 * @create: 2019-10-01 21:23
 */
public class t_flatten_114 {

    /**
     * 99.57%
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left=null;
        while (root.right!=null){
            root = root.right;
        }
        root.right=tmp;
    }

    private TreeNode pre = null;

    /**
     * 99.57%
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
