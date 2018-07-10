package question23;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}

// 递归方法
public class MyPrintFromTopToBottom {
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root==null) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> list=new ArrayList<Integer>();

		list.add(root.val);
		recursive (root,list);

		return list;
	}
	private static void recursive(TreeNode root, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (root==null) {
			return;
		}
		if (root.left!=null) {
			list.add(root.left.val);
		}
		if (root.right!=null) {
			list.add(root.right.val);
		}
		recursive(root.left, list);
		recursive(root.right, list);

	}
	
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
		System.out.println("从上到下打印的节点依次为: ");
		System.out.println("递归方法打印如下");
		System.out.println(PrintFromTopToBottom(root));
		System.out.println("非递归方法打印如下");
		System.out.println(PrintFromTopToBottom1(root));
	}
	
	// 非递归方法
	private static  ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if (root==null) {
			return list;
		}
		Deque<TreeNode> q=new LinkedList<TreeNode>();
		
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode front=q.pop();
			list.add(front.val);
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right!=null) {
				q.add(front.right);
			}
			
		}
		return list;
	}

}
