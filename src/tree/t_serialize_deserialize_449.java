package tree;


/**
 * @program: leetcode https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * @description: 序列化和反序列化二叉搜索树
 * @author: jiaxin_feng
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * @create: 2019-10-02 17:36
 */
public class t_serialize_deserialize_449 {
    public static void main(String[] args) {
       String a = "3#9#1#0#7";
       t_serialize_deserialize_449 c = new t_serialize_deserialize_449();
       TreeNode node = c.deserialize(a);
        System.out.println(c.serialize(node));

    }


    /**
     * 99.19%
     * 序列化：给定一个树，返回序列化的字符串。前序遍历
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(TreeNode root,StringBuilder sb){
        if(root ==null) return;
        sb.append(root.val).append("#");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }


    /**
     * 反序列化：给定一个字符串构建一个二叉查找树树
     */

    public TreeNode deserialize(String data) {
        TreeNode node = null;
        if(data.equals("")){
            return null;
        }
        String[] nums = data.split("#");
        node = new TreeNode(Integer.parseInt(nums[0]));
        for(int i=1;i<nums.length;i++){
           int num = Integer.parseInt(nums[i]);
           insert(node,num);
        }
        return node;

    }
    public void insert(TreeNode node ,int num){
        if(node.val>=num){
            if(node.left==null){
                node.left = new TreeNode(num);
                return;
            }else
            insert(node.left,num);
        }else{
            if(node.right==null){
                node.right = new TreeNode(num);
                return;
            }else
            insert(node.right,num);
        }
    }
}
