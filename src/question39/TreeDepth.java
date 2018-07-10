package question39;

import java.util.ArrayList;
import java.util.Scanner;





class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}
public class TreeDepth {
	static int c1=0,c2=0;
	// 创建二叉树
	private static TreeNode creatTree(Scanner in) {
		// TODO Auto-generated method stub
		TreeNode newNode;
		int val=in.nextInt();
		if (val==-1) {     //设置 -1 为结束数字
			val=in.nextInt();
		}
		if (val!=0) {    // 0 代表空节点
			newNode=new TreeNode(val);
		}else {
			newNode=null;
			return null;
		}

		newNode.left=creatTree(in);
		newNode.right=creatTree(in);

		return newNode;

	}
	// 打印二叉树
	private static void display(TreeNode root) {
		// TODO Auto-generated method stub

		if (root!=null) {
			System.out.print(root.val+"  ");
			display( root.left);
			display(root.right);

		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
       
		System.out.println("请输入树 的先序遍历:");
		TreeNode root=creatTree(in);
		System.out.println("下面是树 的先序遍历:");
		display(root);
        System.out.println();
       int high=treeDepth(root);
       int width=treeWidth(root);
       Math.abs(2);
       System.out.println("depth of the tree is  :"+high);
       System.out.println("width of the tree is  :"+width);
       boolean isBalanced=isBalancedTree(root);
       System.out.println("方法一:isBalanced of the tree is  :"+isBalanced+"  遍历的总次数   "+c1);
       
       
       
       boolean isBalanced2=IsBalanced_Solution2(root);
       System.out.println("方法二:isBalanced2 of the tree is  :"+isBalanced2+"   遍历的总次数   "+c2);
	}
	private static boolean IsBalanced_Solution2(TreeNode root) {
		// TODO Auto-generated method stub
		int[] pDepth = new int[1];
		 return IsBalanced(root,pDepth);
	}
	private static boolean IsBalanced(TreeNode pRoot, int[] pDepth) {
		c2++;
		// TODO Auto-generated method stub
		 if(pRoot == null)
		    {
		        pDepth[0] = 0;
		        return true;
		    }

		    int left[] = new int[1];
			int[] right = new int[1];
		    if(IsBalanced(pRoot.left,left) 
		        && IsBalanced(pRoot.right,right))
		    {
		        int diff = left[0] - right[0];
		        if(diff <= 1 && diff >= -1)
		        {
		            pDepth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
		            return true;
		        }
		    }

		    return false;
	}
	private static boolean isBalancedTree(TreeNode root) {
		c1++;
		// TODO Auto-generated method stub
		if (root==null) {
			return true;
		}
		int left=treeDepth(root.left);
		int right=treeDepth(root.right);
		if (Math.abs(left-right)<2) {
			return isBalancedTree(root.left)&&isBalancedTree(root.right);
		}
		
		return false;
	}
	private static int treeWidth(TreeNode pRoot) {
		// TODO Auto-generated method stub
		if(pRoot==null) return 0;
		if (pRoot.left==null&&pRoot.right==null) {
			return 1;
		}
        int left=treeWidth(pRoot.left);
        int right=treeWidth(pRoot.right);
        return left+right;
	}
	private static int treeDepth(TreeNode pRoot) {
		c1++;
		// TODO Auto-generated method stub
		  if(pRoot==null) return 0;
	         int left=treeDepth(pRoot.left);
	         int right=treeDepth(pRoot.right);
	         return (left>right)? (left+1):(right+1);
	}

}
