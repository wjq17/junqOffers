package junq;

import java.util.Stack;

public class ConvertTreeToList {
    //节点类
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //主函数
    public static void main(String[] args) {
        TreeNode b = new TreeNode(2);
        TreeNode a = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        b.left = a;
        b.right = c;
        a.left=null;a.right=null;c.right=null;c.left=null;
        TreeNode temp = ConvertWithStack(b);
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.right;
        }

    }


    private TreeNode pre = null; //记录当前节点的前一个节点
    private TreeNode head = null; //记录链表的头结点

    /*递归，中序遍历二叉搜索树*/
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    /*中序遍历*/
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }

    /*把上面两个方法写到一个方法当中*/
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert2(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre = pRootOfTree.left;
            pre.right = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert2(pRootOfTree.right);
        return head;
    }

    /*如下，是非递归的方法：用一个栈来保存遍历的顺序*/
    public static TreeNode ConvertWithStack(TreeNode pRootOfTree) {
        //如果根节点为null，则直接返回null
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode newHead = null;
        //否则，用cur记录当前节点，初始时指向根节点
        TreeNode cur = pRootOfTree;
        //prenode用来记录当前节点的前一个节点
        TreeNode prenode = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || cur != null) {
            //左子树上的节点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //到了树的最左边时，将栈中的节点出栈
            cur = stack.pop();
            //初始时，prenode为null,将最左边的节点赋值给newHead,也同时赋值给prenode
            if (prenode == null) {
                newHead = cur;
                prenode = cur;
            }
            //prenode有值的时候，让前一个指针的右节点指向当前节点，当前节点的左指针指向前一个节点
            else {
                prenode.right = cur;
                cur.left = prenode;
                prenode = cur;
            }
            //遍历当前节点的右孩子
            cur = cur.right;
        }
        return newHead;
    }
}
