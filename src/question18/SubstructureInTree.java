package question18;

import java.util.Scanner;

class TreeNode{
	int val;
	TreeNode left=null;
	TreeNode right=null;
	public TreeNode(int val) {
		this.val=val;
	}
}
public class SubstructureInTree {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		System.out.println("请输入树 1 的先序遍历:");
		TreeNode root1=creatTree(in);
		System.out.println("下面是树 1 的先序遍历:");
		display(root1);
		System.out.println();
		System.out.println("请输入树 2 的先序遍历:");
		TreeNode root2=creatTree(in);
		System.out.println("下面是树 2 的先序遍历:");
		display(root2);
		System.out.println();

		boolean result=	HasSubtree(root1,root2);
		System.out.println("树 1 是否包含 树 2:  "+result);
	}

	//树1 是否包含 树2
	private static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		boolean result=false;
		if (root1!=null&&root2!=null) {
			if (root1.val==root2.val) {
				result=DoesTreeHaveTree2(root1,root2);
			}
			if (!result) {
				result=HasSubtree(root1.left, root2);
			}
			if (!result) {
				result=HasSubtree(root1.right, root2);
			}
		}
		return result;

	}
	// 判断 ：当根节点相同时，树1 是否包含 树2
	private static boolean DoesTreeHaveTree2(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if (root2==null ) {
			return true;
		}

		if (root1==null) {
			return false;
		}


		if (root1.val!=root2.val) {
			return false;
		}

		return DoesTreeHaveTree2(root1.left, root2.left)&&DoesTreeHaveTree2(root1.right, root2.right);
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

}
