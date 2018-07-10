package junq;

/**
 * @Author : JunqWang
 * @Description: 二叉树的深度
 * @Date: 19:27 2018/6/21
 **/

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeDepth {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        int result = treeDepth(n1);
        System.out.println("预期结果是3，真实测试结果是： "+result);
    }


    public static int treeDepth(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}
