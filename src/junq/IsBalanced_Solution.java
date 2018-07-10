package junq;

/**
* @Author : ang
*
* @Description: 平衡二叉树--输入一颗二叉树，判断是否是平衡二叉树
*
* @Date: 19:58 2018/6/21
**/
import junq.util.TreeNode;//树节点引用

public class IsBalanced_Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        boolean result = isBalance_Solution(n1);
        System.out.println("预期结果是true，真实测试结果是： " + result);
    }

    public static boolean isBalance_Solution(TreeNode root) {
        if(root == null) return true; //空树也认为是平衡的
        //平衡树的左右子树高度差最大为1
        return (Math.abs(getDepth(root.left)-getDepth(root.right))<=1)?true:false;
    }

    private static int getDepth(TreeNode node) {
        return (node == null )? 0 : 1+Math.max(getDepth(node.left), getDepth(node.right));
    }


}
